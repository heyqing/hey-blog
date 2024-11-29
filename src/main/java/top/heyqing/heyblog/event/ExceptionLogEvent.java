package top.heyqing.heyblog.event;

import org.springframework.context.ApplicationEvent;
import top.heyqing.heyblog.model.entity.ExceptionLog;

/**
 * ClassName:ExceptionLogEvent
 * Package:top.heyqing.heyblog.event
 * Description:
 *
 * @Date:2024/11/28
 * @Author:Heyqing
 */
public class ExceptionLogEvent extends ApplicationEvent {
    public ExceptionLogEvent(ExceptionLog exceptionLog) {
        super(exceptionLog);
    }
}
