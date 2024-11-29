package top.heyqing.heyblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.heyqing.heyblog.config.LogoConfig;

/**
 * ClassName:HeyBlogApplication
 * Package:top.heyqing.heyblog
 * Description:
 * 博客系统
 *
 * @Date:2024/11/27
 * @Author:Heyqing
 */
@SpringBootApplication
@MapperScan("top.heyqing.heyblog.mapper")
public class HeyBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(HeyBlogApplication.class, args);
        LogoConfig.logo();
    }
}
