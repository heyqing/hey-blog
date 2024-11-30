package top.heyqing.heyblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.heyqing.heyblog.annotation.AccessLimit;
import top.heyqing.heyblog.annotation.OptLog;
import top.heyqing.heyblog.model.dto.CommentAdminDTO;
import top.heyqing.heyblog.model.dto.CommentDTO;
import top.heyqing.heyblog.model.dto.PageResultDTO;
import top.heyqing.heyblog.model.dto.ReplyDTO;
import top.heyqing.heyblog.model.vo.CommentVO;
import top.heyqing.heyblog.model.vo.ConditionVO;
import top.heyqing.heyblog.model.vo.R;
import top.heyqing.heyblog.model.vo.ReviewVO;
import top.heyqing.heyblog.service.CommentService;

import javax.validation.Valid;
import java.util.List;

import static top.heyqing.heyblog.constants.OptTypeConstant.*;

/**
 * ClassName:CommentController
 * Package:top.heyqing.heyblog.controller
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Api(tags = "评论模块")
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @AccessLimit(seconds = 60, maxCount = 3)
    @OptLog(optType = SAVE)
    @ApiOperation("添加评论")
    @PostMapping("/comments/save")
    public R<?> saveComment(@Valid @RequestBody CommentVO commentVO) {
        commentService.saveComment(commentVO);
        return R.ok();
    }

    @ApiOperation("获取评论")
    @GetMapping("/comments")
    public R<PageResultDTO<CommentDTO>> getComments(CommentVO commentVO) {
        return R.ok(commentService.listComments(commentVO));
    }

    @ApiOperation(value = "根据commentId获取回复")
    @GetMapping("/comments/{commentId}/replies")
    public R<List<ReplyDTO>> listRepliesByCommentId(@PathVariable("commentId") Integer commentId) {
        return R.ok(commentService.listRepliesByCommentId(commentId));
    }

    @ApiOperation("获取前六个评论")
    @GetMapping("/comments/topSix")
    public R<List<CommentDTO>> listTopSixComments() {
        return R.ok(commentService.listTopSixComments());
    }

    @ApiOperation(value = "查询后台评论")
    @GetMapping("/admin/comments")
    public R<PageResultDTO<CommentAdminDTO>> listCommentBackDTO(ConditionVO conditionVO) {
        return R.ok(commentService.listCommentsAdmin(conditionVO));
    }

    @OptLog(optType = UPDATE)
    @ApiOperation(value = "审核评论")
    @PutMapping("/admin/comments/review")
    public R<?> updateCommentsReview(@Valid @RequestBody ReviewVO reviewVO) {
        commentService.updateCommentsReview(reviewVO);
        return R.ok();
    }

    @OptLog(optType = DELETE)
    @ApiOperation(value = "删除评论")
    @DeleteMapping("/admin/comments")
    public R<?> deleteComments(@RequestBody List<Integer> commentIdList) {
        commentService.removeByIds(commentIdList);
        return R.ok();
    }

}

