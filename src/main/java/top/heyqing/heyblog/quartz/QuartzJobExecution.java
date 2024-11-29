package top.heyqing.heyblog.quartz;

import org.quartz.JobExecutionContext;
import top.heyqing.heyblog.model.entity.Job;
import top.heyqing.heyblog.util.JobInvokeUtil;

/**
 * ClassName:QuartzJobExecution
 * Package:top.heyqing.heyblog.quartz
 * Description:
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
public class QuartzJobExecution extends AbstractQuartzJob {

    @Override
    protected void doExecute(JobExecutionContext context, Job job) throws Exception {
        JobInvokeUtil.invokeMethod(job);
    }
}
