package top.heyqing.heyblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.heyqing.heyblog.model.dto.CategoryAdminDTO;
import top.heyqing.heyblog.model.dto.CategoryDTO;
import top.heyqing.heyblog.model.dto.CategoryOptionDTO;
import top.heyqing.heyblog.model.dto.PageResultDTO;
import top.heyqing.heyblog.model.entity.Category;
import top.heyqing.heyblog.model.vo.CategoryVO;
import top.heyqing.heyblog.model.vo.ConditionVO;

import java.util.List;

/**
 * ClassName:CategoryService
 * Package:top.heyqing.heyblog.service
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
public interface CategoryService extends IService<Category> {

    List<CategoryDTO> listCategories();

    PageResultDTO<CategoryAdminDTO> listCategoriesAdmin(ConditionVO conditionVO);

    List<CategoryOptionDTO> listCategoriesBySearch(ConditionVO conditionVO);

    void deleteCategories(List<Integer> categoryIds);

    void saveOrUpdateCategory(CategoryVO categoryVO);

}

