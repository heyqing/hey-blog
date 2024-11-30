package top.heyqing.heyblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.heyqing.heyblog.annotation.OptLog;
import top.heyqing.heyblog.model.dto.JobDTO;
import top.heyqing.heyblog.model.dto.PageResultDTO;
import top.heyqing.heyblog.model.vo.*;
import top.heyqing.heyblog.service.JobService;

import java.util.List;

import static top.heyqing.heyblog.constants.OptTypeConstant.*;

/**
 * ClassName:JobController
 * Package:top.heyqing.heyblog.controller
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Api(tags = "定时任务模块")
@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @OptLog(optType = SAVE)
    @ApiOperation("添加定时任务")
    @PostMapping("/admin/jobs")
    public R<?> saveJob(@RequestBody JobVO jobVO) {
        jobService.saveJob(jobVO);
        return R.ok();
    }

    @OptLog(optType = UPDATE)
    @ApiOperation("修改定时任务")
    @PutMapping("/admin/jobs")
    public R<?> updateJob(@RequestBody JobVO jobVO) {
        jobService.updateJob(jobVO);
        return R.ok();
    }

    @OptLog(optType = DELETE)
    @ApiOperation("删除定时任务")
    @DeleteMapping("/admin/jobs")
    public R<?> deleteJobById(@RequestBody List<Integer> jobIds) {
        jobService.deleteJobs(jobIds);
        return R.ok();
    }

    @ApiOperation("根据id获取任务")
    @GetMapping("/admin/jobs/{id}")
    public R<JobDTO> getJobById(@PathVariable("id") Integer jobId) {
        return R.ok(jobService.getJobById(jobId));
    }

    @ApiOperation("获取任务列表")
    @GetMapping("/admin/jobs")
    public R<PageResultDTO<JobDTO>> listJobs(JobSearchVO jobSearchVO) {
        return R.ok(jobService.listJobs(jobSearchVO));
    }

    @ApiOperation("更改任务的状态")
    @PutMapping("/admin/jobs/status")
    public R<?> updateJobStatus(@RequestBody JobStatusVO jobStatusVO) {
        jobService.updateJobStatus(jobStatusVO);
        return R.ok();
    }

    @ApiOperation("执行某个任务")
    @PutMapping("/admin/jobs/run")
    public R<?> runJob(@RequestBody JobRunVO jobRunVO) {
        jobService.runJob(jobRunVO);
        return R.ok();
    }

    @ApiOperation("获取所有job分组")
    @GetMapping("/admin/jobs/jobGroups")
    public R<List<String>> listJobGroup() {
        return R.ok(jobService.listJobGroups());
    }
}

