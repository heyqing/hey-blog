package top.heyqing.heyblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.heyqing.heyblog.model.dto.ArticleAdminDTO;
import top.heyqing.heyblog.model.dto.ArticleCardDTO;
import top.heyqing.heyblog.model.dto.ArticleDTO;
import top.heyqing.heyblog.model.dto.ArticleStatisticsDTO;
import top.heyqing.heyblog.model.entity.Article;
import top.heyqing.heyblog.model.vo.ConditionVO;

import java.util.List;

/**
 * ClassName:ArticleMapper
 * Package:top.heyqing.heyblog.mapper
 * Description:
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
@Repository
public interface ArticleMapper extends BaseMapper<Article> {

    List<ArticleCardDTO> listTopAndFeaturedArticles();

    List<ArticleCardDTO> listArticles(@Param("current") Long current, @Param("size") Long size);

    List<ArticleCardDTO> getArticlesByCategoryId(@Param("current") Long current, @Param("size") Long size, @Param("categoryId") Integer categoryId);

    ArticleDTO getArticleById(@Param("articleId") Integer articleId);

    ArticleCardDTO getPreArticleById(@Param("articleId") Integer articleId);

    ArticleCardDTO getNextArticleById(@Param("articleId") Integer articleId);

    ArticleCardDTO getFirstArticle();

    ArticleCardDTO getLastArticle();

    List<ArticleCardDTO> listArticlesByTagId(@Param("current") Long current, @Param("size") Long size, @Param("tagId") Integer tagId);

    List<ArticleCardDTO> listArchives(@Param("current") Long current, @Param("size") Long size);

    Integer countArticleAdmins(@Param("conditionVO") ConditionVO conditionVO);

    List<ArticleAdminDTO> listArticlesAdmin(@Param("current") Long current, @Param("size") Long size, @Param("conditionVO") ConditionVO conditionVO);

    List<ArticleStatisticsDTO> listArticleStatistics();

}
