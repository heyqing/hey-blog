package top.heyqing.heyblog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * ClassName:CommentAdminDTO
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
public class CommentAdminDTO {

    private Integer id;

    private String avatar;

    private String nickname;

    private String replyNickname;

    private String articleTitle;

    private String commentContent;

    private Integer type;

    private Integer isReview;

    private LocalDateTime createTime;

}
