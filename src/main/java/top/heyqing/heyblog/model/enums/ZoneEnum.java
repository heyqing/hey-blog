package top.heyqing.heyblog.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName:ZoneEnum
 * Package:top.heyqing.heyblog.model.enums
 * Description:
 * 时区枚举类
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
@Getter
@AllArgsConstructor
public enum ZoneEnum {

    SHANGHAI("Asia/Shanghai", "中国上海");


    private final String zone;


    private final String desc;
}
