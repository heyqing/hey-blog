package top.heyqing.heyblog.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:JobRunVO
 * Package:top.heyqing.heyblog.model.vo
 * Description:
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobRunVO {

    @ApiModelProperty(name="任务id" ,value = "id",required = true, dataType = "Integer")
    private Integer id;

    @ApiModelProperty(name="任务组别" ,value = "jobGroup",required = true, dataType = "String")
    private String jobGroup;
}
