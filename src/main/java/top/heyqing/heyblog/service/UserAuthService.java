package top.heyqing.heyblog.service;

import top.heyqing.heyblog.model.dto.*;
import top.heyqing.heyblog.model.vo.ConditionVO;
import top.heyqing.heyblog.model.vo.PasswordVO;
import top.heyqing.heyblog.model.vo.QQLoginVO;
import top.heyqing.heyblog.model.vo.UserVO;

import java.util.List;

/**
 * ClassName:UserAuthService
 * Package:top.heyqing.heyblog.service
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
public interface UserAuthService {

    void sendCode(String username);

    List<UserAreaDTO> listUserAreas(ConditionVO conditionVO);

    void register(UserVO userVO);

    void updatePassword(UserVO userVO);

    void updateAdminPassword(PasswordVO passwordVO);

    PageResultDTO<UserAdminDTO> listUsers(ConditionVO condition);

    UserLogoutStatusDTO logout();

    UserInfoDTO qqLogin(QQLoginVO qqLoginVO);

}