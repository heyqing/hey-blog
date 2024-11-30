package top.heyqing.heyblog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * ClassName:UserAdminDTO
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
public class UserAdminDTO {

    private Integer id;

    private Integer userInfoId;

    private String avatar;

    private String nickname;

    private List<UserRoleDTO> roles;

    private Integer loginType;

    private String ipAddress;

    private String ipSource;

    private Date createTime;

    private Date lastLoginTime;

    private Integer isDisable;

    private Integer status;

}

