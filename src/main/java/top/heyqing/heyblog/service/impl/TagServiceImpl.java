package top.heyqing.heyblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.heyqing.heyblog.exception.BizException;
import top.heyqing.heyblog.mapper.ArticleTagMapper;
import top.heyqing.heyblog.mapper.TagMapper;
import top.heyqing.heyblog.model.dto.PageResultDTO;
import top.heyqing.heyblog.model.dto.TagAdminDTO;
import top.heyqing.heyblog.model.dto.TagDTO;
import top.heyqing.heyblog.model.entity.ArticleTag;
import top.heyqing.heyblog.model.entity.Tag;
import top.heyqing.heyblog.model.vo.ConditionVO;
import top.heyqing.heyblog.model.vo.TagVO;
import top.heyqing.heyblog.service.TagService;
import top.heyqing.heyblog.util.BeanCopyUtil;
import top.heyqing.heyblog.util.PageUtil;

import java.util.List;
import java.util.Objects;

/**
 * ClassName:TagServiceImpl
 * Package:top.heyqing.heyblog.service.impl
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private ArticleTagMapper articleTagMapper;

    @Override
    public List<TagDTO> listTags() {
        return tagMapper.listTags();
    }

    @Override
    public List<TagDTO> listTopTenTags() {
        return tagMapper.listTopTenTags();
    }

    @SneakyThrows
    @Override
    public PageResultDTO<TagAdminDTO> listTagsAdmin(ConditionVO conditionVO) {
        Integer count = tagMapper.selectCount(new LambdaQueryWrapper<Tag>()
                .like(StringUtils.isNotBlank(conditionVO.getKeywords()), Tag::getTagName, conditionVO.getKeywords()));
        if (count == 0) {
            return new PageResultDTO<>();
        }
        List<TagAdminDTO> tags = tagMapper.listTagsAdmin(PageUtil.getLimitCurrent(), PageUtil.getSize(), conditionVO);
        return new PageResultDTO<>(tags, count);
    }

    @SneakyThrows
    @Override
    public List<TagAdminDTO> listTagsAdminBySearch(ConditionVO conditionVO) {
        List<Tag> tags = tagMapper.selectList(new LambdaQueryWrapper<Tag>()
                .like(StringUtils.isNotBlank(conditionVO.getKeywords()), Tag::getTagName, conditionVO.getKeywords())
                .orderByDesc(Tag::getId));
        return BeanCopyUtil.copyList(tags, TagAdminDTO.class);
    }

    @Override
    public void saveOrUpdateTag(TagVO tagVO) {
        Tag existTag = tagMapper.selectOne(new LambdaQueryWrapper<Tag>()
                .select(Tag::getId)
                .eq(Tag::getTagName, tagVO.getTagName()));
        if (Objects.nonNull(existTag) && !existTag.getId().equals(tagVO.getId())) {
            throw new BizException("标签名已存在");
        }
        Tag tag = BeanCopyUtil.copyObject(tagVO, Tag.class);
        this.saveOrUpdate(tag);
    }

    @Override
    public void deleteTag(List<Integer> tagIds) {
        Integer count = articleTagMapper.selectCount(new LambdaQueryWrapper<ArticleTag>()
                .in(ArticleTag::getTagId, tagIds));
        if (count > 0) {
            throw new BizException("删除失败，该标签下存在文章");
        }
        tagMapper.deleteBatchIds(tagIds);
    }

}
