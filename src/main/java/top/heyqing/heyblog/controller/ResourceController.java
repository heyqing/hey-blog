package top.heyqing.heyblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.heyqing.heyblog.annotation.OptLog;
import top.heyqing.heyblog.model.dto.LabelOptionDTO;
import top.heyqing.heyblog.model.dto.ResourceDTO;
import top.heyqing.heyblog.model.vo.ConditionVO;
import top.heyqing.heyblog.model.vo.R;
import top.heyqing.heyblog.model.vo.ResourceVO;
import top.heyqing.heyblog.service.ResourceService;

import javax.validation.Valid;
import java.util.List;

import static top.heyqing.heyblog.constants.OptTypeConstant.SAVE_OR_UPDATE;
import static top.heyqing.heyblog.constants.OptTypeConstant.DELETE;

/**
 * ClassName:ResourceController
 * Package:top.heyqing.heyblog.controller
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Api(tags = "资源模块")
@RestController
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @ApiOperation(value = "查看资源列表")
    @GetMapping("/admin/resources")
    public R<List<ResourceDTO>> listResources(ConditionVO conditionVO) {
        return R.ok(resourceService.listResources(conditionVO));
    }

    @OptLog(optType = DELETE)
    @ApiOperation(value = "删除资源")
    @DeleteMapping("/admin/resources/{resourceId}")
    public R<?> deleteResource(@PathVariable("resourceId") Integer resourceId) {
        resourceService.deleteResource(resourceId);
        return R.ok();
    }

    @OptLog(optType = SAVE_OR_UPDATE)
    @ApiOperation(value = "新增或修改资源")
    @PostMapping("/admin/resources")
    public R<?> saveOrUpdateResource(@RequestBody @Valid ResourceVO resourceVO) {
        resourceService.saveOrUpdateResource(resourceVO);
        return R.ok();
    }

    @ApiOperation(value = "查看角色资源选项")
    @GetMapping("/admin/role/resources")
    public R<List<LabelOptionDTO>> listResourceOption() {
        return R.ok(resourceService.listResourceOption());
    }
}
