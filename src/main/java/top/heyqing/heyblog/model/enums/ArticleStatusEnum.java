package top.heyqing.heyblog.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName:ArticleStatusEnum
 * Package:top.heyqing.heyblog.model.enums
 * Description:
 * 文章状态枚举类
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
@Getter
@AllArgsConstructor
public enum ArticleStatusEnum {

    PUBLIC(1, "公开"),

    SECRET(2, "密码"),

    DRAFT(3, "草稿");

    private final Integer status;

    private final String desc;

}
