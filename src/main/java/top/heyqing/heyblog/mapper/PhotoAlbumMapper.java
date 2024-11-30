package top.heyqing.heyblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.heyqing.heyblog.model.dto.PhotoAlbumAdminDTO;
import top.heyqing.heyblog.model.entity.PhotoAlbum;
import top.heyqing.heyblog.model.vo.ConditionVO;

import java.util.List;

/**
 * ClassName:PhotoAlbumMapper
 * Package:top.heyqing.heyblog.mapper
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Repository
public interface PhotoAlbumMapper extends BaseMapper<PhotoAlbum> {

    List<PhotoAlbumAdminDTO> listPhotoAlbumsAdmin(@Param("current") Long current, @Param("size") Long size, @Param("condition") ConditionVO conditionVO);

}
