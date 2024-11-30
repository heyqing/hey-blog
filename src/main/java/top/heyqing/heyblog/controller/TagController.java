package top.heyqing.heyblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.heyqing.heyblog.annotation.OptLog;
import top.heyqing.heyblog.model.dto.PageResultDTO;
import top.heyqing.heyblog.model.dto.TagAdminDTO;
import top.heyqing.heyblog.model.dto.TagDTO;
import top.heyqing.heyblog.model.vo.ConditionVO;
import top.heyqing.heyblog.model.vo.R;
import top.heyqing.heyblog.model.vo.TagVO;
import top.heyqing.heyblog.service.TagService;

import javax.validation.Valid;
import java.util.List;

import static top.heyqing.heyblog.constants.OptTypeConstant.DELETE;
import static top.heyqing.heyblog.constants.OptTypeConstant.SAVE_OR_UPDATE;

/**
 * ClassName:TagController
 * Package:top.heyqing.heyblog.controller
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Api(tags = "标签模块")
@RestController
public class TagController {


    @Autowired
    private TagService tagService;

    @ApiOperation("获取所有标签")
    @GetMapping("/tags/all")
    public R<List<TagDTO>> getAllTags() {
        return R.ok(tagService.listTags());
    }

    @ApiOperation("获取前十个标签")
    @GetMapping("/tags/topTen")
    public R<List<TagDTO>> getTopTenTags() {
        return R.ok(tagService.listTopTenTags());
    }

    @ApiOperation(value = "查询后台标签列表")
    @GetMapping("/admin/tags")
    public R<PageResultDTO<TagAdminDTO>> listTagsAdmin(ConditionVO conditionVO) {
        return R.ok(tagService.listTagsAdmin(conditionVO));
    }

    @ApiOperation(value = "搜索文章标签")
    @GetMapping("/admin/tags/search")
    public R<List<TagAdminDTO>> listTagsAdminBySearch(ConditionVO condition) {
        return R.ok(tagService.listTagsAdminBySearch(condition));
    }

    @OptLog(optType = SAVE_OR_UPDATE)
    @ApiOperation(value = "添加或修改标签")
    @PostMapping("/admin/tags")
    public R<?> saveOrUpdateTag(@Valid @RequestBody TagVO tagVO) {
        tagService.saveOrUpdateTag(tagVO);
        return R.ok();
    }

    @OptLog(optType = DELETE)
    @ApiOperation(value = "删除标签")
    @DeleteMapping("/admin/tags")
    public R<?> deleteTag(@RequestBody List<Integer> tagIdList) {
        tagService.deleteTag(tagIdList);
        return R.ok();
    }
}
