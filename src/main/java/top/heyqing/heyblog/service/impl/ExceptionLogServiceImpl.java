package top.heyqing.heyblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import top.heyqing.heyblog.mapper.ExceptionLogMapper;
import top.heyqing.heyblog.model.dto.ExceptionLogDTO;
import top.heyqing.heyblog.model.dto.PageResultDTO;
import top.heyqing.heyblog.model.entity.ExceptionLog;
import top.heyqing.heyblog.model.vo.ConditionVO;
import top.heyqing.heyblog.service.ExceptionLogService;
import top.heyqing.heyblog.util.BeanCopyUtil;
import top.heyqing.heyblog.util.PageUtil;

import java.util.List;

/**
 * ClassName:ExceptionLogServiceImpl
 * Package:top.heyqing.heyblog.service.impl
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Service
public class ExceptionLogServiceImpl extends ServiceImpl<ExceptionLogMapper, ExceptionLog> implements ExceptionLogService {

    @Override
    public PageResultDTO<ExceptionLogDTO> listExceptionLogs(ConditionVO conditionVO) {
        Page<ExceptionLog> page = new Page<>(PageUtil.getCurrent(), PageUtil.getSize());
        Page<ExceptionLog> exceptionLogPage = this.page(page, new LambdaQueryWrapper<ExceptionLog>()
                .like(StringUtils.isNotBlank(conditionVO.getKeywords()), ExceptionLog::getOptDesc, conditionVO.getKeywords())
                .orderByDesc(ExceptionLog::getId));
        List<ExceptionLogDTO> exceptionLogDTOs = BeanCopyUtil.copyList(exceptionLogPage.getRecords(), ExceptionLogDTO.class);
        return new PageResultDTO<>(exceptionLogDTOs, (int) exceptionLogPage.getTotal());
    }

}