package top.heyqing.heyblog.strategy.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import top.heyqing.heyblog.exception.BizException;
import top.heyqing.heyblog.mapper.UserAuthMapper;
import top.heyqing.heyblog.mapper.UserInfoMapper;
import top.heyqing.heyblog.mapper.UserRoleMapper;
import top.heyqing.heyblog.model.dto.SocialTokenDTO;
import top.heyqing.heyblog.model.dto.SocialUserInfoDTO;
import top.heyqing.heyblog.model.dto.UserDetailsDTO;
import top.heyqing.heyblog.model.dto.UserInfoDTO;
import top.heyqing.heyblog.model.entity.UserAuth;
import top.heyqing.heyblog.model.entity.UserInfo;
import top.heyqing.heyblog.model.entity.UserRole;
import top.heyqing.heyblog.model.enums.RoleEnum;
import top.heyqing.heyblog.service.TokenService;
import top.heyqing.heyblog.service.impl.UserDetailServiceImpl;
import top.heyqing.heyblog.strategy.SocialLoginStrategy;
import top.heyqing.heyblog.util.BeanCopyUtil;
import top.heyqing.heyblog.util.IpUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Objects;

import static top.heyqing.heyblog.constants.CommonConstant.TRUE;

/**
 * ClassName:AbstractSocialLoginStrategyImpl
 * Package:top.heyqing.heyblog.strategy.impl
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Service
public abstract class AbstractSocialLoginStrategyImpl implements SocialLoginStrategy {

    @Autowired
    private UserAuthMapper userAuthMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private TokenService tokenService;

    @Resource
    private HttpServletRequest request;

    @Override
    public UserInfoDTO login(String data) {
        UserDetailsDTO userDetailsDTO;
        SocialTokenDTO socialToken = getSocialToken(data);
        String ipAddress = IpUtil.getIpAddress(request);
        String ipSource = IpUtil.getIpSource(ipAddress);
        UserAuth user = getUserAuth(socialToken);
        if (Objects.nonNull(user)) {
            userDetailsDTO = getUserDetail(user, ipAddress, ipSource);
        } else {
            userDetailsDTO = saveUserDetail(socialToken, ipAddress, ipSource);
        }
        if (userDetailsDTO.getIsDisable().equals(TRUE)) {
            throw new BizException("用户帐号已被锁定");
        }
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetailsDTO, null, userDetailsDTO.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
        UserInfoDTO userInfoDTO = BeanCopyUtil.copyObject(userDetailsDTO, UserInfoDTO.class);
        String token = tokenService.createToken(userDetailsDTO);
        userInfoDTO.setToken(token);
        return userInfoDTO;
    }

    public abstract SocialTokenDTO getSocialToken(String data);

    public abstract SocialUserInfoDTO getSocialUserInfo(SocialTokenDTO socialTokenDTO);

    private UserAuth getUserAuth(SocialTokenDTO socialTokenDTO) {
        return userAuthMapper.selectOne(new LambdaQueryWrapper<UserAuth>()
                .eq(UserAuth::getUsername, socialTokenDTO.getOpenId())
                .eq(UserAuth::getLoginType, socialTokenDTO.getLoginType()));
    }

    private UserDetailsDTO getUserDetail(UserAuth user, String ipAddress, String ipSource) {
        userAuthMapper.update(new UserAuth(), new LambdaUpdateWrapper<UserAuth>()
                .set(UserAuth::getLastLoginTime, LocalDateTime.now())
                .set(UserAuth::getIpAddress, ipAddress)
                .set(UserAuth::getIpSource, ipSource)
                .eq(UserAuth::getId, user.getId()));
        return userDetailService.convertUserDetail(user, request);
    }

    private UserDetailsDTO saveUserDetail(SocialTokenDTO socialToken, String ipAddress, String ipSource) {
        SocialUserInfoDTO socialUserInfo = getSocialUserInfo(socialToken);
        UserInfo userInfo = UserInfo.builder()
                .nickname(socialUserInfo.getNickname())
                .avatar(socialUserInfo.getAvatar())
                .build();
        userInfoMapper.insert(userInfo);
        UserAuth userAuth = UserAuth.builder()
                .userInfoId(userInfo.getId())
                .username(socialToken.getOpenId())
                .password(socialToken.getAccessToken())
                .loginType(socialToken.getLoginType())
                .lastLoginTime(LocalDateTime.now())
                .ipAddress(ipAddress)
                .ipSource(ipSource)
                .build();
        userAuthMapper.insert(userAuth);
        UserRole userRole = UserRole.builder()
                .userId(userInfo.getId())
                .roleId(RoleEnum.USER.getRoleId())
                .build();
        userRoleMapper.insert(userRole);
        return userDetailService.convertUserDetail(userAuth, request);
    }

}

