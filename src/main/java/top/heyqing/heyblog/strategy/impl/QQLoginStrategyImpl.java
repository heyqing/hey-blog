package top.heyqing.heyblog.strategy.impl;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import top.heyqing.heyblog.config.properties.QQConfigProperties;
import top.heyqing.heyblog.constants.SocialLoginConstant;
import top.heyqing.heyblog.exception.BizException;
import top.heyqing.heyblog.model.dto.QQTokenDTO;
import top.heyqing.heyblog.model.dto.QQUserInfoDTO;
import top.heyqing.heyblog.model.dto.SocialTokenDTO;
import top.heyqing.heyblog.model.dto.SocialUserInfoDTO;
import top.heyqing.heyblog.model.enums.LoginTypeEnum;
import top.heyqing.heyblog.model.vo.QQLoginVO;
import top.heyqing.heyblog.util.CommonUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static top.heyqing.heyblog.constants.SocialLoginConstant.*;
import static top.heyqing.heyblog.model.enums.StatusCodeEnum.QQ_LOGIN_ERROR;

/**
 * ClassName:QQLoginStrategyImpl
 * Package:top.heyqing.heyblog.strategy.impl
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Service("qqLoginStrategyImpl")
public class QQLoginStrategyImpl extends AbstractSocialLoginStrategyImpl {

    @Autowired
    private QQConfigProperties qqConfigProperties;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public SocialTokenDTO getSocialToken(String data) {
        QQLoginVO qqLoginVO = JSON.parseObject(data, QQLoginVO.class);
        checkQQToken(qqLoginVO);
        return SocialTokenDTO.builder()
                .openId(qqLoginVO.getOpenId())
                .accessToken(qqLoginVO.getAccessToken())
                .loginType(LoginTypeEnum.QQ.getType())
                .build();
    }

    @Override
    public SocialUserInfoDTO getSocialUserInfo(SocialTokenDTO socialTokenDTO) {
        Map<String, String> formData = new HashMap<>(3);
        formData.put(QQ_OPEN_ID, socialTokenDTO.getOpenId());
        formData.put(ACCESS_TOKEN, socialTokenDTO.getAccessToken());
        formData.put(OAUTH_CONSUMER_KEY, qqConfigProperties.getAppId());
        QQUserInfoDTO qqUserInfoDTO = JSON.parseObject(restTemplate.getForObject(qqConfigProperties.getUserInfoUrl(), String.class, formData), QQUserInfoDTO.class);
        return SocialUserInfoDTO.builder()
                .nickname(Objects.requireNonNull(qqUserInfoDTO).getNickname())
                .avatar(qqUserInfoDTO.getFigureurl_qq_1())
                .build();
    }

    private void checkQQToken(QQLoginVO qqLoginVO) {
        Map<String, String> qqData = new HashMap<>(1);
        qqData.put(SocialLoginConstant.ACCESS_TOKEN, qqLoginVO.getAccessToken());
        try {
            String result = restTemplate.getForObject(qqConfigProperties.getCheckTokenUrl(), String.class, qqData);
            QQTokenDTO qqTokenDTO = JSON.parseObject(CommonUtil.getBracketsContent(Objects.requireNonNull(result)), QQTokenDTO.class);
            if (!qqLoginVO.getOpenId().equals(qqTokenDTO.getOpenid())) {
                throw new BizException(QQ_LOGIN_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizException(QQ_LOGIN_ERROR);
        }
    }

}