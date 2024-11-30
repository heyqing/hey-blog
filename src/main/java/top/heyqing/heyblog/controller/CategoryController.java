package top.heyqing.heyblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.heyqing.heyblog.annotation.OptLog;
import top.heyqing.heyblog.model.dto.CategoryAdminDTO;
import top.heyqing.heyblog.model.dto.CategoryDTO;
import top.heyqing.heyblog.model.dto.CategoryOptionDTO;
import top.heyqing.heyblog.model.dto.PageResultDTO;
import top.heyqing.heyblog.model.vo.CategoryVO;
import top.heyqing.heyblog.model.vo.ConditionVO;
import top.heyqing.heyblog.model.vo.R;
import top.heyqing.heyblog.service.CategoryService;

import javax.validation.Valid;
import java.util.List;

import static top.heyqing.heyblog.constants.OptTypeConstant.DELETE;
import static top.heyqing.heyblog.constants.OptTypeConstant.SAVE_OR_UPDATE;

/**
 * ClassName:CategoryController
 * Package:top.heyqing.heyblog.controller
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Api(tags = "分类模块")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation("获取所有分类")
    @GetMapping("/categories/all")
    public R<List<CategoryDTO>> listCategories() {
        return R.ok(categoryService.listCategories());
    }

    @ApiOperation(value = "查看后台分类列表")
    @GetMapping("/admin/categories")
    public R<PageResultDTO<CategoryAdminDTO>> listCategoriesAdmin(ConditionVO conditionVO) {
        return R.ok(categoryService.listCategoriesAdmin(conditionVO));
    }

    @ApiOperation(value = "搜索文章分类")
    @GetMapping("/admin/categories/search")
    public R<List<CategoryOptionDTO>> listCategoriesAdminBySearch(ConditionVO conditionVO) {
        return R.ok(categoryService.listCategoriesBySearch(conditionVO));
    }

    @OptLog(optType = DELETE)
    @ApiOperation(value = "删除分类")
    @DeleteMapping("/admin/categories")
    public R<?> deleteCategories(@RequestBody List<Integer> categoryIds) {
        categoryService.deleteCategories(categoryIds);
        return R.ok();
    }

    @OptLog(optType = SAVE_OR_UPDATE)
    @ApiOperation(value = "添加或修改分类")
    @PostMapping("/admin/categories")
    public R<?> saveOrUpdateCategory(@Valid @RequestBody CategoryVO categoryVO) {
        categoryService.saveOrUpdateCategory(categoryVO);
        return R.ok();
    }


}

