package top.heyqing.heyblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.heyqing.heyblog.annotation.OptLog;
import top.heyqing.heyblog.model.dto.JobLogDTO;
import top.heyqing.heyblog.model.dto.PageResultDTO;
import top.heyqing.heyblog.model.vo.JobLogSearchVO;
import top.heyqing.heyblog.model.vo.R;
import top.heyqing.heyblog.service.JobLogService;

import java.util.List;

import static top.heyqing.heyblog.constants.OptTypeConstant.DELETE;

/**
 * ClassName:JobLogController
 * Package:top.heyqing.heyblog.controller
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Api(tags = "定时任务日志模块")
@RestController
public class JobLogController {

    @Autowired
    private JobLogService jobLogService;

    @ApiOperation("获取定时任务的日志列表")
    @GetMapping("/admin/jobLogs")
    public R<PageResultDTO<JobLogDTO>> listJobLogs(JobLogSearchVO jobLogSearchVO) {
        return R.ok(jobLogService.listJobLogs(jobLogSearchVO));
    }

    @OptLog(optType = DELETE)
    @ApiOperation("删除定时任务的日志")
    @DeleteMapping("/admin/jobLogs")
    public R<?> deleteJobLogs(@RequestBody List<Integer> ids) {
        jobLogService.deleteJobLogs(ids);
        return R.ok();
    }

    @OptLog(optType = DELETE)
    @ApiOperation("清除定时任务的日志")
    @DeleteMapping("/admin/jobLogs/clean")
    public R<?> cleanJobLogs() {
        jobLogService.cleanJobLogs();
        return R.ok();
    }

    @ApiOperation("获取定时任务日志的所有组名")
    @GetMapping("/admin/jobLogs/jobGroups")
    public R<?> listJobLogGroups() {
        return R.ok(jobLogService.listJobLogGroups());
    }
}

