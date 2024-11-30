package top.heyqing.heyblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.heyqing.heyblog.model.dto.PageResultDTO;
import top.heyqing.heyblog.model.dto.PhotoAdminDTO;
import top.heyqing.heyblog.model.dto.PhotoDTO;
import top.heyqing.heyblog.model.entity.Photo;
import top.heyqing.heyblog.model.vo.ConditionVO;
import top.heyqing.heyblog.model.vo.DeleteVO;
import top.heyqing.heyblog.model.vo.PhotoInfoVO;
import top.heyqing.heyblog.model.vo.PhotoVO;

import java.util.List;

/**
 * ClassName:PhotoService
 * Package:top.heyqing.heyblog.service
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
public interface PhotoService extends IService<Photo> {

    PageResultDTO<PhotoAdminDTO> listPhotos(ConditionVO conditionVO);

    void updatePhoto(PhotoInfoVO photoInfoVO);

    void savePhotos(PhotoVO photoVO);

    void updatePhotosAlbum(PhotoVO photoVO);

    void updatePhotoDelete(DeleteVO deleteVO);

    void deletePhotos(List<Integer> photoIds);

    PhotoDTO listPhotosByAlbumId(Integer albumId);

}

