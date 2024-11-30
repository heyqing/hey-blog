package top.heyqing.heyblog.mapper;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import top.heyqing.heyblog.model.dto.ArticleSearchDTO;

/**
 * ClassName:ElasticsearchMapper
 * Package:top.heyqing.heyblog.mapper
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Repository
public interface ElasticsearchMapper extends ElasticsearchRepository<ArticleSearchDTO,Integer> {

}
