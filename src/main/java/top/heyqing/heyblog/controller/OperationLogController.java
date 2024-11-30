package top.heyqing.heyblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.heyqing.heyblog.annotation.OptLog;
import top.heyqing.heyblog.model.dto.OperationLogDTO;
import top.heyqing.heyblog.model.dto.PageResultDTO;
import top.heyqing.heyblog.model.vo.ConditionVO;
import top.heyqing.heyblog.model.vo.R;
import top.heyqing.heyblog.service.OperationLogService;

import java.util.List;

import static top.heyqing.heyblog.constants.OptTypeConstant.DELETE;

/**
 * ClassName:OperationLogController
 * Package:top.heyqing.heyblog.controller
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Api(tags = "操作日志模块")
@RestController
public class OperationLogController {

    @Autowired
    private OperationLogService operationLogService;

    @ApiOperation(value = "查看操作日志")
    @GetMapping("/admin/operation/logs")
    public R<PageResultDTO<OperationLogDTO>> listOperationLogs(ConditionVO conditionVO) {
        return R.ok(operationLogService.listOperationLogs(conditionVO));
    }

    @OptLog(optType = DELETE)
    @ApiOperation(value = "删除操作日志")
    @DeleteMapping("/admin/operation/logs")
    public R<?> deleteOperationLogs(@RequestBody List<Integer> operationLogIds) {
        operationLogService.removeByIds(operationLogIds);
        return R.ok();
    }

}

