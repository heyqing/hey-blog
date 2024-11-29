package top.heyqing.heyblog.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:RoleResource
 * Package:top.heyqing.heyblog.model.entity
 * Description:
 * 角色资源关联表
 *
 * @Date:2024/11/28
 * @Author:Heyqing
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_role_resource")
public class RoleResource {

    /**
     * 唯一标识
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 资源id
     */
    private Integer resourceId;

}