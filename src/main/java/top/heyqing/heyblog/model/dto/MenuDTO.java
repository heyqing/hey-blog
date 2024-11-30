package top.heyqing.heyblog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * ClassName:MenuDTO
 * Package:top.heyqing.heyblog.model.dto
 * Description:
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO {

    private Integer id;

    private String name;

    private String path;

    private String component;

    private String icon;

    private LocalDateTime createTime;

    private Integer orderNum;

    private Integer isDisable;

    private Integer isHidden;

    private List<MenuDTO> children;

}
