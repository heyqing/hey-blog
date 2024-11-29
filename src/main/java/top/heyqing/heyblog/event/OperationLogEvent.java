package top.heyqing.heyblog.event;

import org.springframework.context.ApplicationEvent;
import top.heyqing.heyblog.model.entity.OperationLog;

/**
 * ClassName:OperationLogEvent
 * Package:top.heyqing.heyblog.event
 * Description:
 *
 * @Date:2024/11/28
 * @Author:Heyqing
 */
public class OperationLogEvent extends ApplicationEvent {

    public OperationLogEvent(OperationLog operationLog) {
        super(operationLog);
    }
}

