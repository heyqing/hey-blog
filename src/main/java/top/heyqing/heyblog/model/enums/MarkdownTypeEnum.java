package top.heyqing.heyblog.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName:MarkdownTypeEnum
 * Package:top.heyqing.heyblog.model.enums
 * Description:
 * md文章导入
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
@Getter
@AllArgsConstructor
public enum MarkdownTypeEnum {

    NORMAL("", "normalArticleImportStrategyImpl");

    private final String type;

    private final String strategy;

    public static String getMarkdownType(String name) {
        if (name == null) {
            return NORMAL.getStrategy();
        }
        for (MarkdownTypeEnum value : MarkdownTypeEnum.values()) {
            if (value.getType().equalsIgnoreCase(name)) {
                return value.getStrategy();
            }
        }
        return null;
    }
}

