package top.heyqing.heyblog.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:QQConfigProperties
 * Package:top.heyqing.heyblog.config.properties
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "qq")
public class QQConfigProperties {

    private String appId;

    private String checkTokenUrl;

    private String userInfoUrl;

}

