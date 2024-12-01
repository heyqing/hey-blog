package top.heyqing.heyblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.Collections;

/**
 * ClassName:Knife4jConfig
 * Package:top.heyqing.heyblog.config
 * Description:
 *
 * @Date:2024/12/1
 * @Author:Heyqing
 */
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .protocols(Collections.singleton("http"))
                .host("http://www.heyqing.top")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.heyqing.heyblog.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("HeyBlog接口文档")
                .description("heyblog")
                .contact(new Contact("何以晴", "", "heyqings@163.com"))
                .termsOfServiceUrl("https://www.heyqing.top/api")
                .version("v1.0.0")
                .build();
    }

}