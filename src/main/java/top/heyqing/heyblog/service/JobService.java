package top.heyqing.heyblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.heyqing.heyblog.model.dto.JobDTO;
import top.heyqing.heyblog.model.dto.PageResultDTO;
import top.heyqing.heyblog.model.entity.Job;
import top.heyqing.heyblog.model.vo.JobRunVO;
import top.heyqing.heyblog.model.vo.JobSearchVO;
import top.heyqing.heyblog.model.vo.JobStatusVO;
import top.heyqing.heyblog.model.vo.JobVO;

import java.util.List;

/**
 * ClassName:JobService
 * Package:top.heyqing.heyblog.service
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
public interface JobService extends IService<Job> {

    void saveJob(JobVO jobVO);

    void updateJob(JobVO jobVO);

    void deleteJobs(List<Integer> tagIds);

    JobDTO getJobById(Integer jobId);

    PageResultDTO<JobDTO> listJobs(JobSearchVO jobSearchVO);

    void updateJobStatus(JobStatusVO jobStatusVO);

    void runJob(JobRunVO jobRunVO);

    List<String> listJobGroups();

}