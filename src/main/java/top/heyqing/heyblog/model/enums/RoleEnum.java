package top.heyqing.heyblog.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName:RoleEnum
 * Package:top.heyqing.heyblog.model.enums
 * Description:
 * 角色枚举类
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
@Getter
@AllArgsConstructor
public enum RoleEnum {

    ADMIN(1, "管理员", "admin"),

    USER(2, "用户", "user"),

    TEST(3, "测试", "test");

    private final Integer roleId;

    private final String name;

    private final String label;

}
