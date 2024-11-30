package top.heyqing.heyblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.heyqing.heyblog.annotation.OptLog;
import top.heyqing.heyblog.model.dto.AboutDTO;
import top.heyqing.heyblog.model.dto.HeyBlogAdminInfoDTO;
import top.heyqing.heyblog.model.dto.HeyBlogHomeInfoDTO;
import top.heyqing.heyblog.model.dto.WebsiteConfigDTO;
import top.heyqing.heyblog.model.enums.FilePathEnum;
import top.heyqing.heyblog.model.vo.AboutVO;
import top.heyqing.heyblog.model.vo.R;
import top.heyqing.heyblog.model.vo.WebsiteConfigVO;
import top.heyqing.heyblog.service.HeyBlogInfoService;
import top.heyqing.heyblog.strategy.context.UploadStrategyContext;

import javax.validation.Valid;

import static top.heyqing.heyblog.constants.OptTypeConstant.UPDATE;
import static top.heyqing.heyblog.constants.OptTypeConstant.UPLOAD;

/**
 * ClassName:HeyBlogInfoController
 * Package:top.heyqing.heyblog.controller
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Api(tags = "hey-blog信息")
@RestController
public class HeyBlogInfoController {

    @Autowired
    private HeyBlogInfoService heyBlogInfoService;

    @Autowired
    private UploadStrategyContext uploadStrategyContext;

    @ApiOperation(value = "上报访客信息")
    @PostMapping("/report")
    public R<?> report() {
        heyBlogInfoService.report();
        return R.ok();
    }

    @ApiOperation(value = "获取系统信息")
    @GetMapping("/")
    public R<HeyBlogHomeInfoDTO> getBlogHomeInfo() {
        return R.ok(heyBlogInfoService.getHeyBlogHomeInfo());
    }

    @ApiOperation(value = "获取系统后台信息")
    @GetMapping("/admin")
    public R<HeyBlogAdminInfoDTO> getBlogBackInfo() {
        return R.ok(heyBlogInfoService.getHeyBlogAdminInfo());
    }

    @OptLog(optType = UPDATE)
    @ApiOperation(value = "更新网站配置")
    @PutMapping("/admin/website/config")
    public R<?> updateWebsiteConfig(@Valid @RequestBody WebsiteConfigVO websiteConfigVO) {
        heyBlogInfoService.updateWebsiteConfig(websiteConfigVO);
        return R.ok();
    }

    @ApiOperation(value = "获取网站配置")
    @GetMapping("/admin/website/config")
    public R<WebsiteConfigDTO> getWebsiteConfig() {
        return R.ok(heyBlogInfoService.getWebsiteConfig());
    }

    @ApiOperation(value = "查看关于我信息")
    @GetMapping("/about")
    public R<AboutDTO> getAbout() {
        return R.ok(heyBlogInfoService.getAbout());
    }

    @OptLog(optType = UPDATE)
    @ApiOperation(value = "修改关于我信息")
    @PutMapping("/admin/about")
    public R<?> updateAbout(@Valid @RequestBody AboutVO aboutVO) {
        heyBlogInfoService.updateAbout(aboutVO);
        return R.ok();
    }

    @OptLog(optType = UPLOAD)
    @ApiOperation(value = "上传博客配置图片")
    @ApiImplicitParam(name = "file", value = "图片", required = true, dataType = "MultipartFile")
    @PostMapping("/admin/config/images")
    public R<String> savePhotoAlbumCover(MultipartFile file) {
        return R.ok(uploadStrategyContext.executeUploadStrategy(file, FilePathEnum.CONFIG.getPath()));
    }

}
