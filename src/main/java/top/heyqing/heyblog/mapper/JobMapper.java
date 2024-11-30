package top.heyqing.heyblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.heyqing.heyblog.model.dto.JobDTO;
import top.heyqing.heyblog.model.entity.Job;
import top.heyqing.heyblog.model.vo.JobSearchVO;

import java.util.List;

/**
 * ClassName:JobMapper
 * Package:top.heyqing.heyblog.mapper
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Repository
public interface JobMapper extends BaseMapper<Job> {

    Integer countJobs(@Param("jobSearchVO") JobSearchVO jobSearchVO);

    List<JobDTO> listJobs(@Param("current") Long current, @Param("size") Long size, @Param("jobSearchVO")JobSearchVO jobSearchVO);

    List<String> listJobGroups();

}
