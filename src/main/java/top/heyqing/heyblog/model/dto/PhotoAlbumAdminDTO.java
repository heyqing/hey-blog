package top.heyqing.heyblog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:PhotoAlbumAdminDTO
 * Package:top.heyqing.heyblog.model.dto
 * Description:
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhotoAlbumAdminDTO {

    private Integer id;

    private String albumName;

    private String albumDesc;

    private String albumCover;

    private Integer photoCount;

    private Integer status;

}
