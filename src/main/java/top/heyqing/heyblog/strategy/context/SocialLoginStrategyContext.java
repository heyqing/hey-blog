package top.heyqing.heyblog.strategy.context;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.heyqing.heyblog.model.dto.UserInfoDTO;
import top.heyqing.heyblog.model.enums.LoginTypeEnum;
import top.heyqing.heyblog.strategy.SocialLoginStrategy;

import java.util.Map;

/**
 * ClassName:SocialLoginStrategyContext
 * Package:top.heyqing.heyblog.strategy.context
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Service
public class SocialLoginStrategyContext {


    @Autowired
    private Map<String, SocialLoginStrategy> socialLoginStrategyMap;

    public UserInfoDTO executeLoginStrategy(String data, LoginTypeEnum loginTypeEnum) {
        return socialLoginStrategyMap.get(loginTypeEnum.getStrategy()).login(data);
    }

}
