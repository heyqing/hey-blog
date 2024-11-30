package top.heyqing.heyblog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * ClassName:UserOnlineDTO
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
public class UserOnlineDTO {

    private Integer userInfoId;

    private String nickname;

    private String avatar;

    private String ipAddress;

    private String ipSource;

    private String browser;

    private String os;

    private LocalDateTime lastLoginTime;

}
