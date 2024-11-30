package top.heyqing.heyblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.heyqing.heyblog.annotation.OptLog;
import top.heyqing.heyblog.model.dto.PageResultDTO;
import top.heyqing.heyblog.model.dto.RoleDTO;
import top.heyqing.heyblog.model.dto.UserRoleDTO;
import top.heyqing.heyblog.model.vo.ConditionVO;
import top.heyqing.heyblog.model.vo.R;
import top.heyqing.heyblog.model.vo.RoleVO;
import top.heyqing.heyblog.service.RoleService;

import javax.validation.Valid;
import java.util.List;

import static top.heyqing.heyblog.constants.OptTypeConstant.DELETE;
import static top.heyqing.heyblog.constants.OptTypeConstant.SAVE_OR_UPDATE;

/**
 * ClassName:RoleController
 * Package:top.heyqing.heyblog.controller
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Api(tags = "角色模块")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "查询用户角色选项")
    @GetMapping("/admin/users/role")
    public R<List<UserRoleDTO>> listUserRoles() {
        return R.ok(roleService.listUserRoles());
    }


    @ApiOperation(value = "查询角色列表")
    @GetMapping("/admin/roles")
    public R<PageResultDTO<RoleDTO>> listRoles(ConditionVO conditionVO) {
        return R.ok(roleService.listRoles(conditionVO));
    }

    @OptLog(optType = SAVE_OR_UPDATE)
    @ApiOperation(value = "保存或更新角色")
    @PostMapping("/admin/role")
    public R<?> saveOrUpdateRole(@RequestBody @Valid RoleVO roleVO) {
        roleService.saveOrUpdateRole(roleVO);
        return R.ok();
    }

    @OptLog(optType = DELETE)
    @ApiOperation(value = "删除角色")
    @DeleteMapping("/admin/roles")
    public R<?> deleteRoles(@RequestBody List<Integer> roleIdList) {
        roleService.deleteRoles(roleIdList);
        return R.ok();
    }
}

