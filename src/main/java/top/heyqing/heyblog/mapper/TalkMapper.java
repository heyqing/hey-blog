package top.heyqing.heyblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.heyqing.heyblog.model.dto.TalkAdminDTO;
import top.heyqing.heyblog.model.dto.TalkDTO;
import top.heyqing.heyblog.model.entity.Talk;
import top.heyqing.heyblog.model.vo.ConditionVO;

import java.util.List;

/**
 * ClassName:TalkMapper
 * Package:top.heyqing.heyblog.mapper
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Repository
public interface TalkMapper extends BaseMapper<Talk> {

    List<TalkDTO> listTalks(@Param("current") Long current, @Param("size") Long size);

    TalkDTO getTalkById(@Param("talkId") Integer talkId);

    List<TalkAdminDTO> listTalksAdmin(@Param("current") Long current, @Param("size") Long size, @Param("conditionVO") ConditionVO conditionVO);

    TalkAdminDTO getTalkByIdAdmin(@Param("talkId") Integer talkId);

}
