package top.heyqing.heyblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.heyqing.heyblog.model.dto.JobLogDTO;
import top.heyqing.heyblog.model.dto.PageResultDTO;
import top.heyqing.heyblog.model.entity.JobLog;
import top.heyqing.heyblog.model.vo.JobLogSearchVO;

import java.util.List;

/**
 * ClassName:JobLogService
 * Package:top.heyqing.heyblog.service
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
public interface JobLogService extends IService<JobLog> {

    PageResultDTO<JobLogDTO> listJobLogs(JobLogSearchVO jobLogSearchVO);

    void deleteJobLogs(List<Integer> ids);

    void cleanJobLogs();

    List<String> listJobLogGroups();

}