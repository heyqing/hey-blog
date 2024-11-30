package top.heyqing.heyblog.strategy;

import top.heyqing.heyblog.model.dto.UserInfoDTO;

/**
 * ClassName:SocialLoginStrategy
 * Package:top.heyqing.heyblog.strategy
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
public interface SocialLoginStrategy {

    UserInfoDTO login(String data);

}
