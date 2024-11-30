package top.heyqing.heyblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.heyqing.heyblog.model.dto.TagAdminDTO;
import top.heyqing.heyblog.model.dto.TagDTO;
import top.heyqing.heyblog.model.entity.Tag;
import top.heyqing.heyblog.model.vo.ConditionVO;

import java.util.List;

/**
 * ClassName:TagMapper
 * Package:top.heyqing.heyblog.mapper
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Repository
public interface TagMapper extends BaseMapper<Tag> {

    List<TagDTO> listTags();

    List<TagDTO> listTopTenTags();

    List<String> listTagNamesByArticleId(Integer articleId);

    List<TagAdminDTO> listTagsAdmin(@Param("current") Long current, @Param("size") Long size, @Param("conditionVO") ConditionVO conditionVO);

}

