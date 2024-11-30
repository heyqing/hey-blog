package top.heyqing.heyblog.consumer;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.heyqing.heyblog.mapper.ElasticsearchMapper;
import top.heyqing.heyblog.model.dto.ArticleSearchDTO;
import top.heyqing.heyblog.model.dto.MaxwellDataDTO;
import top.heyqing.heyblog.model.entity.Article;
import top.heyqing.heyblog.util.BeanCopyUtil;

import static top.heyqing.heyblog.constants.RabbitMQConstant.MAXWELL_QUEUE;

/**
 * ClassName:MaxWellConsumer
 * Package:top.heyqing.heyblog.consumer
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Component
@RabbitListener(queues = MAXWELL_QUEUE)
public class MaxWellConsumer {

    @Autowired
    private ElasticsearchMapper elasticsearchMapper;

    @RabbitHandler
    public void process(byte[] data) {
        MaxwellDataDTO maxwellDataDTO = JSON.parseObject(new String(data), MaxwellDataDTO.class);
        Article article = JSON.parseObject(JSON.toJSONString(maxwellDataDTO.getData()), Article.class);
        switch (maxwellDataDTO.getType()) {
            case "insert":
            case "update":
                elasticsearchMapper.save(BeanCopyUtil.copyObject(article, ArticleSearchDTO.class));
                break;
            case "delete":
                elasticsearchMapper.deleteById(article.getId());
                break;
            default:
                break;
        }
    }
}