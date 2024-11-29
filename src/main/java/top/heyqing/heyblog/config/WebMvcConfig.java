package top.heyqing.heyblog.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.heyqing.heyblog.interceptor.AccessLimitInterceptor;
import top.heyqing.heyblog.interceptor.PaginationInterceptor;

/**
 * ClassName:WebMvcConfig
 * Package:top.heyqing.heyblog.config
 * Description:
 * web跨域设置
 *
 * @Date:2024/11/28
 * @Author:Heyqing
 */
@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {


    private final PaginationInterceptor paginationInterceptor;


    private final AccessLimitInterceptor accessLimitInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("*");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(paginationInterceptor);
        registry.addInterceptor(accessLimitInterceptor);
    }

}
