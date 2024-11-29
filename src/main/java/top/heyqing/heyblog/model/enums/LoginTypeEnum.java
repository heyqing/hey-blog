package top.heyqing.heyblog.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName:LoginTypeEnum
 * Package:top.heyqing.heyblog.model.enums
 * Description:
 * 登录类型枚举类
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
@Getter
@AllArgsConstructor
public enum LoginTypeEnum {

    EMAIL(1, "邮箱登录", ""),

    QQ(2, "QQ登录", "qqLoginStrategyImpl");

    private final Integer type;

    private final String desc;

    private final String strategy;

}