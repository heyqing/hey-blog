package top.heyqing.heyblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.heyqing.heyblog.annotation.OptLog;
import top.heyqing.heyblog.model.dto.PageResultDTO;
import top.heyqing.heyblog.model.dto.PhotoAlbumAdminDTO;
import top.heyqing.heyblog.model.dto.PhotoAlbumDTO;
import top.heyqing.heyblog.model.enums.FilePathEnum;
import top.heyqing.heyblog.model.vo.ConditionVO;
import top.heyqing.heyblog.model.vo.PhotoAlbumVO;
import top.heyqing.heyblog.model.vo.R;
import top.heyqing.heyblog.service.PhotoAlbumService;
import top.heyqing.heyblog.strategy.context.UploadStrategyContext;

import javax.validation.Valid;
import java.util.List;

import static top.heyqing.heyblog.constants.OptTypeConstant.*;

/**
 * ClassName:PhotoAlbumController
 * Package:top.heyqing.heyblog.controller
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Api(tags = "相册模块")
@RestController
public class PhotoAlbumController {

    @Autowired
    private UploadStrategyContext uploadStrategyContext;

    @Autowired
    private PhotoAlbumService photoAlbumService;


    @OptLog(optType = UPLOAD)
    @ApiOperation(value = "上传相册封面")
    @ApiImplicitParam(name = "file", value = "相册封面", required = true, dataType = "MultipartFile")
    @PostMapping("/admin/photos/albums/upload")
    public R<String> savePhotoAlbumCover(MultipartFile file) {
        return R.ok(uploadStrategyContext.executeUploadStrategy(file, FilePathEnum.PHOTO.getPath()));
    }

    @OptLog(optType = SAVE_OR_UPDATE)
    @ApiOperation(value = "保存或更新相册")
    @PostMapping("/admin/photos/albums")
    public R<?> saveOrUpdatePhotoAlbum(@Valid @RequestBody PhotoAlbumVO photoAlbumVO) {
        photoAlbumService.saveOrUpdatePhotoAlbum(photoAlbumVO);
        return R.ok();
    }

    @ApiOperation(value = "查看后台相册列表")
    @GetMapping("/admin/photos/albums")
    public R<PageResultDTO<PhotoAlbumAdminDTO>> listPhotoAlbumBacks(ConditionVO conditionVO) {
        return R.ok(photoAlbumService.listPhotoAlbumsAdmin(conditionVO));
    }

    @ApiOperation(value = "获取后台相册列表信息")
    @GetMapping("/admin/photos/albums/info")
    public R<List<PhotoAlbumDTO>> listPhotoAlbumBackInfos() {
        return R.ok(photoAlbumService.listPhotoAlbumInfosAdmin());
    }

    @ApiOperation(value = "根据id获取后台相册信息")
    @ApiImplicitParam(name = "albumId", value = "相册id", required = true, dataType = "Integer")
    @GetMapping("/admin/photos/albums/{albumId}/info")
    public R<PhotoAlbumAdminDTO> getPhotoAlbumBackById(@PathVariable("albumId") Integer albumId) {
        return R.ok(photoAlbumService.getPhotoAlbumByIdAdmin(albumId));
    }

    @OptLog(optType = DELETE)
    @ApiOperation(value = "根据id删除相册")
    @ApiImplicitParam(name = "albumId", value = "相册id", required = true, dataType = "Integer")
    @DeleteMapping("/admin/photos/albums/{albumId}")
    public R<?> deletePhotoAlbumById(@PathVariable("albumId") Integer albumId) {
        photoAlbumService.deletePhotoAlbumById(albumId);
        return R.ok();
    }

    @ApiOperation(value = "获取相册列表")
    @GetMapping("/photos/albums")
    public R<List<PhotoAlbumDTO>> listPhotoAlbums() {
        return R.ok(photoAlbumService.listPhotoAlbums());
    }

}
