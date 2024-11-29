package top.heyqing.heyblog.annotation;

import java.lang.annotation.*;

/**
 * ClassName:AccessLimit
 * Package:top.heyqing.heyblog.annotation
 * Description:
 * 访问限制
 *
 * @Date:2024/11/28
 * @Author:Heyqing
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AccessLimit {

    int seconds();

    int maxCount();
}

