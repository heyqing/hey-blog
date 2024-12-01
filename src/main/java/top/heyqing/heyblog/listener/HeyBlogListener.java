package top.heyqing.heyblog.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import top.heyqing.heyblog.event.ExceptionLogEvent;
import top.heyqing.heyblog.event.OperationLogEvent;
import top.heyqing.heyblog.mapper.ExceptionLogMapper;
import top.heyqing.heyblog.mapper.OperationLogMapper;
import top.heyqing.heyblog.model.entity.ExceptionLog;
import top.heyqing.heyblog.model.entity.OperationLog;

/**
 * ClassName:HeyBlogListener
 * Package:top.heyqing.heyblog.listener
 * Description:
 *
 * @Date:2024/12/1
 * @Author:Heyqing
 */
@Component
public class HeyBlogListener {
    @Autowired
    private OperationLogMapper operationLogMapper;

    @Autowired
    private ExceptionLogMapper exceptionLogMapper;

    @Async
    @EventListener(OperationLogEvent.class)
    public void saveOperationLog(OperationLogEvent operationLogEvent) {
        operationLogMapper.insert((OperationLog) operationLogEvent.getSource());
    }

    @Async
    @EventListener(ExceptionLogEvent.class)
    public void saveExceptionLog(ExceptionLogEvent exceptionLogEvent) {
        exceptionLogMapper.insert((ExceptionLog) exceptionLogEvent.getSource());
    }
}
