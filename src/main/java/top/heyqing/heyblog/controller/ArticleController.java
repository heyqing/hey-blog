package top.heyqing.heyblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.heyqing.heyblog.annotation.OptLog;
import top.heyqing.heyblog.model.dto.*;
import top.heyqing.heyblog.model.enums.FilePathEnum;
import top.heyqing.heyblog.model.vo.*;
import top.heyqing.heyblog.service.ArticleService;
import top.heyqing.heyblog.strategy.context.ArticleImportStrategyContext;
import top.heyqing.heyblog.strategy.context.UploadStrategyContext;

import javax.validation.Valid;
import java.util.List;

import static top.heyqing.heyblog.constants.OptTypeConstant.*;

/**
 * ClassName:ArticleController
 * Package:top.heyqing.heyblog.controller
 * Description:
 * 文章模块
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
@Api(tags = "文章模块")
@RestController
@RequestMapping
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private UploadStrategyContext uploadStrategyContext;

    @Autowired
    private ArticleImportStrategyContext articleImportStrategyContext;

    @ApiOperation("获取置顶和推荐文章")
    @GetMapping("/articles/topAndFeatured")
    public R<TopAndFeaturedArticlesDTO> listTopAndFeaturedArticles() {
        return R.ok(articleService.listTopAndFeaturedArticles());
    }

    @ApiOperation("获取所有文章")
    @GetMapping("/articles/all")
    public R<PageResultDTO<ArticleCardDTO>> listArticles() {
        return R.ok(articleService.listArticles());
    }

    @ApiOperation("根据分类id获取文章")
    @GetMapping("/articles/categoryId")
    public R<PageResultDTO<ArticleCardDTO>> getArticlesByCategoryId(@RequestParam Integer categoryId) {
        return R.ok(articleService.listArticlesByCategoryId(categoryId));
    }

    @ApiOperation("根据id获取文章")
    @GetMapping("/articles/{articleId}")
    public R<ArticleDTO> getArticleById(@PathVariable("articleId") Integer articleId) {
        return R.ok(articleService.getArticleById(articleId));
    }

    @ApiOperation("校验文章访问密码")
    @PostMapping("/articles/access")
    public R<?> accessArticle(@Valid @RequestBody ArticlePasswordVO articlePasswordVO) {
        articleService.accessArticle(articlePasswordVO);
        return R.ok();
    }

    @ApiOperation("根据标签id获取文章")
    @GetMapping("/articles/tagId")
    public R<PageResultDTO<ArticleCardDTO>> listArticlesByTagId(@RequestParam Integer tagId) {
        return R.ok(articleService.listArticlesByTagId(tagId));
    }

    @ApiOperation("获取所有文章归档")
    @GetMapping("/archives/all")
    public R<PageResultDTO<ArchiveDTO>> listArchives() {
        return R.ok(articleService.listArchives());
    }

    @ApiOperation("获取后台文章")
    @GetMapping("/admin/articles")
    public R<PageResultDTO<ArticleAdminDTO>> listArticlesAdmin(ConditionVO conditionVO) {
        return R.ok(articleService.listArticlesAdmin(conditionVO));
    }

    @OptLog(optType = SAVE_OR_UPDATE)
    @ApiOperation("保存和修改文章")
    @PostMapping("/admin/articles")
    public R<?> saveOrUpdateArticle(@Valid @RequestBody ArticleVO articleVO) {
        articleService.saveOrUpdateArticle(articleVO);
        return R.ok();
    }

    @OptLog(optType = UPDATE)
    @ApiOperation("修改文章是否置顶和推荐")
    @PutMapping("/admin/articles/topAndFeatured")
    public R<?> updateArticleTopAndFeatured(@Valid @RequestBody ArticleTopFeaturedVO articleTopFeaturedVO) {
        articleService.updateArticleTopAndFeatured(articleTopFeaturedVO);
        return R.ok();
    }

    @ApiOperation("删除或者恢复文章")
    @PutMapping("/admin/articles")
    public R<?> updateArticleDelete(@Valid @RequestBody DeleteVO deleteVO) {
        articleService.updateArticleDelete(deleteVO);
        return R.ok();
    }

    @OptLog(optType = DELETE)
    @ApiOperation(value = "物理删除文章")
    @DeleteMapping("/admin/articles/delete")
    public R<?> deleteArticles(@RequestBody List<Integer> articleIds) {
        articleService.deleteArticles(articleIds);
        return R.ok();
    }

    @OptLog(optType = UPLOAD)
    @ApiOperation("上传文章图片")
    @ApiImplicitParam(name = "file", value = "文章图片", required = true, dataType = "MultipartFile")
    @PostMapping("/admin/articles/images")
    public R<String> saveArticleImages(MultipartFile file) {
        return R.ok(uploadStrategyContext.executeUploadStrategy(file, FilePathEnum.ARTICLE.getPath()));
    }

    @ApiOperation("根据id查看后台文章")
    @ApiImplicitParam(name = "articleId", value = "文章id", required = true, dataType = "Integer")
    @GetMapping("/admin/articles/{articleId}")
    public R<ArticleAdminViewDTO> getArticleBackById(@PathVariable("articleId") Integer articleId) {
        return R.ok(articleService.getArticleByIdAdmin(articleId));
    }

    @OptLog(optType = UPLOAD)
    @ApiOperation(value = "导入文章")
    @PostMapping("/admin/articles/import")
    public R<?> importArticles(MultipartFile file, @RequestParam(required = false) String type) {
        articleImportStrategyContext.importArticles(file, type);
        return R.ok();
    }

    @OptLog(optType = EXPORT)
    @ApiOperation(value = "导出文章")
    @ApiImplicitParam(name = "articleIdList", value = "文章id", required = true, dataType = "List<Integer>")
    @PostMapping("/admin/articles/export")
    public R<List<String>> exportArticles(@RequestBody List<Integer> articleIds) {
        return R.ok(articleService.exportArticles(articleIds));
    }

    @ApiOperation(value = "搜索文章")
    @GetMapping("/articles/search")
    public R<List<ArticleSearchDTO>> listArticlesBySearch(ConditionVO condition) {
        return R.ok(articleService.listArticlesBySearch(condition));
    }

}
