package top.heyqing.heyblog.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import top.heyqing.heyblog.constants.ScheduleConstant;
import top.heyqing.heyblog.mapper.JobLogMapper;
import top.heyqing.heyblog.model.entity.Job;
import top.heyqing.heyblog.model.entity.JobLog;
import top.heyqing.heyblog.util.ExceptionUtil;
import top.heyqing.heyblog.util.SpringUtil;

import java.util.Date;

import static top.heyqing.heyblog.constants.CommonConstant.ONE;
import static top.heyqing.heyblog.constants.CommonConstant.ZERO;

/**
 * ClassName:AbstractQuartzJob
 * Package:top.heyqing.heyblog.quartz
 * Description:
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
public abstract class AbstractQuartzJob implements org.quartz.Job {

    private static final Logger log = LoggerFactory.getLogger(AbstractQuartzJob.class);

    private static final ThreadLocal<Date> THREAD_LOCAL = new ThreadLocal<>();

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Job job = new Job();
        BeanUtils.copyProperties(context.getMergedJobDataMap().get(ScheduleConstant.TASK_PROPERTIES), job);
        try {
            before(context, job);
            doExecute(context, job);
            after(context, job, null);
        } catch (Exception e) {
            log.error("任务执行异常:", e);
            after(context, job, e);
        }
    }

    protected void before(JobExecutionContext context, Job job) {
        THREAD_LOCAL.set(new Date());
    }

    protected void after(JobExecutionContext context, Job job, Exception e) {
        Date startTime = THREAD_LOCAL.get();
        THREAD_LOCAL.remove();
        final JobLog jobLog = new JobLog();
        jobLog.setJobId(job.getId());
        jobLog.setJobName(job.getJobName());
        jobLog.setJobGroup(job.getJobGroup());
        jobLog.setInvokeTarget(job.getInvokeTarget());
        jobLog.setStartTime(startTime);
        jobLog.setEndTime(new Date());
        long runMs = jobLog.getEndTime().getTime() - jobLog.getStartTime().getTime();
        jobLog.setJobMessage(jobLog.getJobName() + " 总共耗时：" + runMs + "毫秒");
        if (e != null) {
            jobLog.setStatus(ZERO);
            jobLog.setExceptionInfo(ExceptionUtil.getTrace(e));
        } else {
            jobLog.setStatus(ONE);
        }
        SpringUtil.getBean(JobLogMapper.class).insert(jobLog);
    }

    protected abstract void doExecute(JobExecutionContext context, Job job) throws Exception;
}

