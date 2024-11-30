package top.heyqing.heyblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.heyqing.heyblog.annotation.OptLog;
import top.heyqing.heyblog.model.dto.ExceptionLogDTO;
import top.heyqing.heyblog.model.dto.PageResultDTO;
import top.heyqing.heyblog.model.vo.ConditionVO;
import top.heyqing.heyblog.model.vo.R;
import top.heyqing.heyblog.service.ExceptionLogService;

import java.util.List;

import static top.heyqing.heyblog.constants.OptTypeConstant.DELETE;

/**
 * ClassName:ExceptionLogController
 * Package:top.heyqing.heyblog.controller
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Api(tags = "异常日志模块")
@RestController
public class ExceptionLogController {

    @Autowired
    private ExceptionLogService exceptionLogService;

    @ApiOperation("获取异常日志")
    @GetMapping("/admin/exception/logs")
    public R<PageResultDTO<ExceptionLogDTO>> listExceptionLogs(ConditionVO conditionVO) {
        return R.ok(exceptionLogService.listExceptionLogs(conditionVO));
    }

    @OptLog(optType = DELETE)
    @ApiOperation(value = "删除异常日志")
    @DeleteMapping("/admin/exception/logs")
    public R<?> deleteExceptionLogs(@RequestBody List<Integer> exceptionLogIds) {
        exceptionLogService.removeByIds(exceptionLogIds);
        return R.ok();
    }

}

