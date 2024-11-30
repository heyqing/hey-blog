package top.heyqing.heyblog.strategy.impl;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.heyqing.heyblog.exception.BizException;
import top.heyqing.heyblog.model.vo.ArticleVO;
import top.heyqing.heyblog.service.ArticleService;
import top.heyqing.heyblog.strategy.ArticleImportStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

import static top.heyqing.heyblog.model.enums.ArticleStatusEnum.DRAFT;

/**
 * ClassName:NormalArticleImportStrategyImpl
 * Package:top.heyqing.heyblog.strategy.impl
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Slf4j
@Service("normalArticleImportStrategyImpl")
public class NormalArticleImportStrategyImpl implements ArticleImportStrategy {

    @Autowired
    private ArticleService articleService;

    @Override
    public void importArticles(MultipartFile file) {
        String articleTitle = Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[0];
        StringBuilder articleContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            while (reader.ready()) {
                articleContent.append((char) reader.read());
            }
        } catch (IOException e) {
            log.error(StrUtil.format("导入文章失败, 堆栈:{}", ExceptionUtil.stacktraceToString(e)));
            throw new BizException("导入文章失败");
        }
        ArticleVO articleVO = ArticleVO.builder()
                .articleTitle(articleTitle)
                .articleContent(articleContent.toString())
                .status(DRAFT.getStatus())
                .build();
        articleService.saveOrUpdateArticle(articleVO);
    }
}

