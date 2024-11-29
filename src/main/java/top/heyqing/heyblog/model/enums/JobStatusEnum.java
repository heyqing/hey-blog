package top.heyqing.heyblog.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName:JobStatusEnum
 * Package:top.heyqing.heyblog.model.enums
 * Description:
 * 任务状态枚举类
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
@Getter
@AllArgsConstructor
public enum JobStatusEnum {

    NORMAL(1),

    PAUSE(0);

    private final Integer value;

}
