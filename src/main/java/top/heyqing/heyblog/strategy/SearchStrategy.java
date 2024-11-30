package top.heyqing.heyblog.strategy;

import top.heyqing.heyblog.model.dto.ArticleSearchDTO;

import java.util.List;

/**
 * ClassName:SearchStrategy
 * Package:top.heyqing.heyblog.strategy
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
public interface SearchStrategy {

    List<ArticleSearchDTO> searchArticle(String keywords);

}
