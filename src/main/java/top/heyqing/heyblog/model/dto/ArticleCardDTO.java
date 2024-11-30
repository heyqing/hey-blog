package top.heyqing.heyblog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.heyqing.heyblog.model.entity.Tag;
import top.heyqing.heyblog.model.entity.UserInfo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * ClassName:ArticleCardDTO
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
public class ArticleCardDTO {

    private Integer id;

    private String articleCover;

    private String articleTitle;

    private String articleContent;

    private Integer isTop;

    private Integer isFeatured;

    private UserInfo author;

    private String categoryName;

    private List<Tag> tags;

    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
