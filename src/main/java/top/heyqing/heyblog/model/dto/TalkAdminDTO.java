package top.heyqing.heyblog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * ClassName:TalkAdminDTO
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
public class TalkAdminDTO {

    private Integer id;

    private String nickname;

    private String avatar;

    private String content;

    private String images;

    private List<String> imgs;

    private Integer isTop;

    private Integer status;

    private LocalDateTime createTime;

}