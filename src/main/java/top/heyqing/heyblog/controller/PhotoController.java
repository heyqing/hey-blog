package top.heyqing.heyblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.heyqing.heyblog.annotation.OptLog;
import top.heyqing.heyblog.model.dto.PageResultDTO;
import top.heyqing.heyblog.model.dto.PhotoAdminDTO;
import top.heyqing.heyblog.model.dto.PhotoDTO;
import top.heyqing.heyblog.model.enums.FilePathEnum;
import top.heyqing.heyblog.model.vo.*;
import top.heyqing.heyblog.service.PhotoService;
import top.heyqing.heyblog.strategy.context.UploadStrategyContext;

import javax.validation.Valid;
import java.util.List;

import static top.heyqing.heyblog.constants.OptTypeConstant.*;

/**
 * ClassName:PhotoController
 * Package:top.heyqing.heyblog.controller
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Api(tags = "照片模块")
@RestController
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @Autowired
    private UploadStrategyContext uploadStrategyContext;

    @OptLog(optType = UPLOAD)
    @ApiOperation(value = "上传照片")
    @ApiImplicitParam(name = "file", value = "照片", required = true, dataType = "MultipartFile")
    @PostMapping("/admin/photos/upload")
    public R<String> savePhotoAlbumCover(MultipartFile file) {
        return R.ok(uploadStrategyContext.executeUploadStrategy(file, FilePathEnum.PHOTO.getPath()));
    }

    @ApiOperation(value = "根据相册id获取照片列表")
    @GetMapping("/admin/photos")
    public R<PageResultDTO<PhotoAdminDTO>> listPhotos(ConditionVO conditionVO) {
        return R.ok(photoService.listPhotos(conditionVO));
    }

    @OptLog(optType = UPDATE)
    @ApiOperation(value = "更新照片信息")
    @PutMapping("/admin/photos")
    public R<?> updatePhoto(@Valid @RequestBody PhotoInfoVO photoInfoVO) {
        photoService.updatePhoto(photoInfoVO);
        return R.ok();
    }

    @OptLog(optType = SAVE)
    @ApiOperation(value = "保存照片")
    @PostMapping("/admin/photos")
    public R<?> savePhotos(@Valid @RequestBody PhotoVO photoVO) {
        photoService.savePhotos(photoVO);
        return R.ok();
    }

    @OptLog(optType = UPDATE)
    @ApiOperation(value = "移动照片相册")
    @PutMapping("/admin/photos/album")
    public R<?> updatePhotosAlbum(@Valid @RequestBody PhotoVO photoVO) {
        photoService.updatePhotosAlbum(photoVO);
        return R.ok();
    }

    @OptLog(optType = UPDATE)
    @ApiOperation(value = "更新照片删除状态")
    @PutMapping("/admin/photos/delete")
    public R<?> updatePhotoDelete(@Valid @RequestBody DeleteVO deleteVO) {
        photoService.updatePhotoDelete(deleteVO);
        return R.ok();
    }

    @OptLog(optType = DELETE)
    @ApiOperation(value = "删除照片")
    @DeleteMapping("/admin/photos")
    public R<?> deletePhotos(@RequestBody List<Integer> photoIds) {
        photoService.deletePhotos(photoIds);
        return R.ok();
    }

    @ApiOperation(value = "根据相册id查看照片列表")
    @GetMapping("/albums/{albumId}/photos")
    public R<PhotoDTO> listPhotosByAlbumId(@PathVariable("albumId") Integer albumId) {
        return R.ok(photoService.listPhotosByAlbumId(albumId));
    }

}

