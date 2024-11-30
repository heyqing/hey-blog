package top.heyqing.heyblog.strategy.context;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.heyqing.heyblog.model.enums.MarkdownTypeEnum;
import top.heyqing.heyblog.strategy.ArticleImportStrategy;

import java.util.Map;

/**
 * ClassName:ArticleImportStrategyContext
 * Package:top.heyqing.heyblog.strategy.context
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Service
public class ArticleImportStrategyContext {

    @Autowired
    private Map<String, ArticleImportStrategy> articleImportStrategyMap;

    public void importArticles(MultipartFile file, String type) {
        articleImportStrategyMap.get(MarkdownTypeEnum.getMarkdownType(type)).importArticles(file);
    }
}

