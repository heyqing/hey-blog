package top.heyqing.heyblog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:HeyBlogHomeInfoDTO
 * Package:top.heyqing.heyblog.model.dto
 * Description:
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HeyBlogHomeInfoDTO {

    private Integer articleCount;

    private Integer talkCount;

    private Integer categoryCount;

    private Integer tagCount;

    private WebsiteConfigDTO websiteConfigDTO;

    private Integer viewCount;

}
