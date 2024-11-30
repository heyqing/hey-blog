package top.heyqing.heyblog.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:OssConfigProperties
 * Package:top.heyqing.heyblog.config.properties
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "upload.oss")
public class OssConfigProperties {

    private String url;

    private String endpoint;

    private String accessKeyId;

    private String accessKeySecret;

    private String bucketName;

}

