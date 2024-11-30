package top.heyqing.heyblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.heyqing.heyblog.model.dto.OperationLogDTO;
import top.heyqing.heyblog.model.dto.PageResultDTO;
import top.heyqing.heyblog.model.entity.OperationLog;
import top.heyqing.heyblog.model.vo.ConditionVO;

/**
 * ClassName:OperationLogService
 * Package:top.heyqing.heyblog.service
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
public interface OperationLogService extends IService<OperationLog> {

    PageResultDTO<OperationLogDTO> listOperationLogs(ConditionVO conditionVO);

}
