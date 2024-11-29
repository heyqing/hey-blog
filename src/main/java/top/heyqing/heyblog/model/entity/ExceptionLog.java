package top.heyqing.heyblog.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * ClassName:ExceptionLog
 * Package:top.heyqing.heyblog.model.entity
 * Description:
 * 异常表
 *
 * @Date:2024/11/28
 * @Author:Heyqing
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_exception_log")
public class ExceptionLog {

    /**
     * 唯一标识
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 请求接口
     */
    private String optUri;

    /**
     * 请求方式
     */
    private String optMethod;

    /**
     * 请求方法
     */
    private String requestMethod;

    /**
     * 请求参数
     */
    private String requestParam;

    /**
     * 操作描述
     */
    private String optDesc;

    /**
     * 异常信息
     */
    private String exceptionInfo;

    /**
     * ip
     */
    private String ipAddress;

    /**
     * ip源
     */
    private String ipSource;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

}

