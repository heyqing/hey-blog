package top.heyqing.heyblog.annotation;

import java.lang.annotation.*;

/**
 * ClassName:OptLog
 * Package:top.heyqing.heyblog.annotation
 * Description:
 * 操作 日志
 *
 * @Date:2024/11/28
 * @Author:Heyqing
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OptLog {

    /**
     * 操作类型
     *
     * @return
     */
    String optType() default "";

}
