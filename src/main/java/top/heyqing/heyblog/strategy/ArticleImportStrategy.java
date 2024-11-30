package top.heyqing.heyblog.strategy;

import org.springframework.web.multipart.MultipartFile;

/**
 * ClassName:ArticleImportStrategy
 * Package:top.heyqing.heyblog.strategy
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
public interface ArticleImportStrategy {

    void importArticles(MultipartFile file);

}

