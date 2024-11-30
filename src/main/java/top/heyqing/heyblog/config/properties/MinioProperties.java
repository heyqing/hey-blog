package top.heyqing.heyblog.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:MinioProperties
 * Package:top.heyqing.heyblog.config.properties
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "upload.minio")
public class MinioProperties {

    private String url;

    private String endpoint;

    private String accessKey;

    private String secretKey;

    private String bucketName;
}
