package top.heyqing.heyblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.heyqing.heyblog.exception.BizException;
import top.heyqing.heyblog.mapper.ArticleMapper;
import top.heyqing.heyblog.mapper.CategoryMapper;
import top.heyqing.heyblog.model.dto.CategoryAdminDTO;
import top.heyqing.heyblog.model.dto.CategoryDTO;
import top.heyqing.heyblog.model.dto.CategoryOptionDTO;
import top.heyqing.heyblog.model.dto.PageResultDTO;
import top.heyqing.heyblog.model.entity.Article;
import top.heyqing.heyblog.model.entity.Category;
import top.heyqing.heyblog.model.vo.CategoryVO;
import top.heyqing.heyblog.model.vo.ConditionVO;
import top.heyqing.heyblog.service.CategoryService;
import top.heyqing.heyblog.util.BeanCopyUtil;
import top.heyqing.heyblog.util.PageUtil;

import java.util.List;
import java.util.Objects;

/**
 * ClassName:CategoryServiceImpl
 * Package:top.heyqing.heyblog.service.impl
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<CategoryDTO> listCategories() {
        return categoryMapper.listCategories();
    }

    @SneakyThrows
    @Override
    public PageResultDTO<CategoryAdminDTO> listCategoriesAdmin(ConditionVO conditionVO) {
        Integer count = categoryMapper.selectCount(new LambdaQueryWrapper<Category>()
                .like(StringUtils.isNotBlank(conditionVO.getKeywords()), Category::getCategoryName, conditionVO.getKeywords()));
        if (count == 0) {
            return new PageResultDTO<>();
        }
        List<CategoryAdminDTO> categoryList = categoryMapper.listCategoriesAdmin(PageUtil.getLimitCurrent(), PageUtil.getSize(), conditionVO);
        return new PageResultDTO<>(categoryList, count);
    }

    @SneakyThrows
    @Override
    public List<CategoryOptionDTO> listCategoriesBySearch(ConditionVO conditionVO) {
        List<Category> categoryList = categoryMapper.selectList(new LambdaQueryWrapper<Category>()
                .like(StringUtils.isNotBlank(conditionVO.getKeywords()), Category::getCategoryName, conditionVO.getKeywords())
                .orderByDesc(Category::getId));
        return BeanCopyUtil.copyList(categoryList, CategoryOptionDTO.class);
    }


    @Override
    public void deleteCategories(List<Integer> categoryIds) {
        Integer count = articleMapper.selectCount(new LambdaQueryWrapper<Article>()
                .in(Article::getCategoryId, categoryIds));
        if (count > 0) {
            throw new BizException("删除失败，该分类下存在文章");
        }
        categoryMapper.deleteBatchIds(categoryIds);
    }

    @Override
    public void saveOrUpdateCategory(CategoryVO categoryVO) {
        Category existCategory = categoryMapper.selectOne(new LambdaQueryWrapper<Category>()
                .select(Category::getId)
                .eq(Category::getCategoryName, categoryVO.getCategoryName()));
        if (Objects.nonNull(existCategory) && !existCategory.getId().equals(categoryVO.getId())) {
            throw new BizException("分类名已存在");
        }
        Category category = Category.builder()
                .id(categoryVO.getId())
                .categoryName(categoryVO.getCategoryName())
                .build();
        this.saveOrUpdate(category);
    }

}
