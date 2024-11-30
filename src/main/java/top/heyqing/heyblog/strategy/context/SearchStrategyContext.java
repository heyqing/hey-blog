package top.heyqing.heyblog.strategy.context;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.heyqing.heyblog.model.dto.ArticleSearchDTO;
import top.heyqing.heyblog.strategy.SearchStrategy;

import java.util.List;
import java.util.Map;

import static top.heyqing.heyblog.model.enums.SearchModeEnum.getStrategy;

/**
 * ClassName:SearchStrategyContext
 * Package:top.heyqing.heyblog.strategy.context
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Service
public class SearchStrategyContext {

    @Value("${search.mode}")
    private String searchMode;


    @Autowired
    private Map<String, SearchStrategy> searchStrategyMap;

    public List<ArticleSearchDTO> executeSearchStrategy(String keywords) {
        return searchStrategyMap.get(getStrategy(searchMode)).searchArticle(keywords);
    }

}
