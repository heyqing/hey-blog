package top.heyqing.heyblog.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:IsHiddenVO
 * Package:top.heyqing.heyblog.model.vo
 * Description:
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IsHiddenVO {

    private Integer id;

    private Integer isHidden;
}
