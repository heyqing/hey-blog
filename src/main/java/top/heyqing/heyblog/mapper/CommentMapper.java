package top.heyqing.heyblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.heyqing.heyblog.model.dto.CommentAdminDTO;
import top.heyqing.heyblog.model.dto.CommentCountDTO;
import top.heyqing.heyblog.model.dto.CommentDTO;
import top.heyqing.heyblog.model.dto.ReplyDTO;
import top.heyqing.heyblog.model.entity.Comment;
import top.heyqing.heyblog.model.vo.CommentVO;
import top.heyqing.heyblog.model.vo.ConditionVO;

import java.util.List;

/**
 * ClassName:CommentMapper
 * Package:top.heyqing.heyblog.mapper
 * Description:
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
@Repository
public interface CommentMapper extends BaseMapper<Comment> {

    List<CommentDTO> listComments(@Param("current") Long current, @Param("size") Long size, @Param("commentVO") CommentVO commentVO);

    List<ReplyDTO> listReplies(@Param("commentIds") List<Integer> commentIdList);

    List<CommentDTO> listTopSixComments();

    Integer countComments(@Param("conditionVO") ConditionVO conditionVO);

    List<CommentAdminDTO> listCommentsAdmin(@Param("current") Long current, @Param("size") Long size, @Param("conditionVO") ConditionVO conditionVO);

    List<CommentCountDTO> listCommentCountByTypeAndTopicIds(@Param("type") Integer type, @Param("topicIds") List<Integer> topicIds);

    CommentCountDTO listCommentCountByTypeAndTopicId(@Param("type") Integer type, @Param("topicId") Integer topicId);

}
