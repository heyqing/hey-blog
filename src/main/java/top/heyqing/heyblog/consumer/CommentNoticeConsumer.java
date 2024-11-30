package top.heyqing.heyblog.consumer;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.heyqing.heyblog.model.dto.EmailDTO;
import top.heyqing.heyblog.util.EmailUtil;

import static top.heyqing.heyblog.constants.RabbitMQConstant.EMAIL_QUEUE;

/**
 * ClassName:CommentNoticeConsumer
 * Package:top.heyqing.heyblog.consumer
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Component
@RabbitListener(queues = EMAIL_QUEUE)
public class CommentNoticeConsumer {

    @Autowired
    private EmailUtil emailUtil;

    @RabbitHandler
    public void process(byte[] data) {
        EmailDTO emailDTO = JSON.parseObject(new String(data), EmailDTO.class);
        emailUtil.sendHtmlMail(emailDTO);
    }

}

