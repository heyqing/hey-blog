package top.heyqing.heyblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.heyqing.heyblog.annotation.OptLog;
import top.heyqing.heyblog.model.dto.LabelOptionDTO;
import top.heyqing.heyblog.model.dto.MenuDTO;
import top.heyqing.heyblog.model.dto.UserMenuDTO;
import top.heyqing.heyblog.model.vo.ConditionVO;
import top.heyqing.heyblog.model.vo.IsHiddenVO;
import top.heyqing.heyblog.model.vo.MenuVO;
import top.heyqing.heyblog.model.vo.R;
import top.heyqing.heyblog.service.MenuService;

import javax.validation.Valid;
import java.util.List;

import static top.heyqing.heyblog.constants.OptTypeConstant.*;

/**
 * ClassName:MenuController
 * Package:top.heyqing.heyblog.controller
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Api(tags = "菜单模块")
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "查看菜单列表")
    @GetMapping("/admin/menus")
    public R<List<MenuDTO>> listMenus(ConditionVO conditionVO) {
        return R.ok(menuService.listMenus(conditionVO));
    }

    @OptLog(optType = SAVE_OR_UPDATE)
    @ApiOperation(value = "新增或修改菜单")
    @PostMapping("/admin/menus")
    public R<?> saveOrUpdateMenu(@Valid @RequestBody MenuVO menuVO) {
        menuService.saveOrUpdateMenu(menuVO);
        return R.ok();
    }

    @OptLog(optType = UPDATE)
    @ApiOperation(value = "修改目录是否隐藏")
    @PutMapping("/admin/menus/isHidden")
    public R<?> updateMenuIsHidden(@RequestBody IsHiddenVO isHiddenVO) {
        menuService.updateMenuIsHidden(isHiddenVO);
        return R.ok();
    }

    @OptLog(optType = DELETE)
    @ApiOperation(value = "删除菜单")
    @DeleteMapping("/admin/menus/{menuId}")
    public R<?> deleteMenu(@PathVariable("menuId") Integer menuId) {
        menuService.deleteMenu(menuId);
        return R.ok();
    }

    @ApiOperation(value = "查看角色菜单选项")
    @GetMapping("/admin/role/menus")
    public R<List<LabelOptionDTO>> listMenuOptions() {
        return R.ok(menuService.listMenuOptions());
    }

    @ApiOperation(value = "查看当前用户菜单")
    @GetMapping("/admin/user/menus")
    public R<List<UserMenuDTO>> listUserMenus() {
        return R.ok(menuService.listUserMenus());
    }
}
