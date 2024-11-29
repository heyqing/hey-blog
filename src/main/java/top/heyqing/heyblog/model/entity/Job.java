package top.heyqing.heyblog.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * ClassName:Job
 * Package:top.heyqing.heyblog.model.entity
 * Description:
 * 任务表
 *
 * @Date:2024/11/28
 * @Author:Heyqing
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_job")
public class Job {

    /**
     * 唯一标识
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 任务名
     */
    private String jobName;

    /**
     * 任务组别
     */
    private String jobGroup;

    /**
     * 调用目标字符串
     */
    private String invokeTarget;

    /**
     * cron执行语句
     */
    private String cronExpression;

    /**
     * 执行错误列表
     */
    private Integer misfirePolicy;

    /**
     * 是否并发执行
     */
    private Integer concurrent;

    /**
     * 任务状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更改时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 下一次有效时间
     */
    @TableField(exist = false)
    private Date nextValidTime;

}

