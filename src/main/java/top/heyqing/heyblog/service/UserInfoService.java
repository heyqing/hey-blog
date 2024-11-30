package top.heyqing.heyblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;
import top.heyqing.heyblog.model.dto.PageResultDTO;
import top.heyqing.heyblog.model.dto.UserInfoDTO;
import top.heyqing.heyblog.model.dto.UserOnlineDTO;
import top.heyqing.heyblog.model.entity.UserInfo;
import top.heyqing.heyblog.model.vo.*;

/**
 * ClassName:UserInfoService
 * Package:top.heyqing.heyblog.service
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
public interface UserInfoService extends IService<UserInfo> {

    void updateUserInfo(UserInfoVO userInfoVO);

    String updateUserAvatar(MultipartFile file);

    void saveUserEmail(EmailVO emailVO);

    void updateUserSubscribe(SubscribeVO subscribeVO);

    void updateUserRole(UserRoleVO userRoleVO);

    void updateUserDisable(UserDisableVO userDisableVO);

    PageResultDTO<UserOnlineDTO> listOnlineUsers(ConditionVO conditionVO);

    void removeOnlineUser(Integer userInfoId);

    UserInfoDTO getUserInfoById(Integer id);

}
