package top.heyqing.heyblog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName:TopAndFeaturedArticlesDTO
 * Package:top.heyqing.heyblog.model.dto
 * Description:
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopAndFeaturedArticlesDTO {

    private ArticleCardDTO topArticle;

    private List<ArticleCardDTO> featuredArticles;
}
