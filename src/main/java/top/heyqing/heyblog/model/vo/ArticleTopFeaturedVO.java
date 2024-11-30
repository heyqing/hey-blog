package top.heyqing.heyblog.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * ClassName:ArticleTopFeaturedVO
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
public class ArticleTopFeaturedVO {
    @NotNull(message = "id不能为空")
    private Integer id;

    @NotNull(message = "是否置顶不能为空")
    private Integer isTop;

    @NotNull(message = "是否推荐不能为空")
    private Integer isFeatured;
}
