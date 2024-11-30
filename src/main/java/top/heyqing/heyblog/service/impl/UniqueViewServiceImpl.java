package top.heyqing.heyblog.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.heyqing.heyblog.mapper.UniqueViewMapper;
import top.heyqing.heyblog.model.dto.UniqueViewDTO;
import top.heyqing.heyblog.model.entity.UniqueView;
import top.heyqing.heyblog.service.UniqueViewService;

import java.util.Date;
import java.util.List;

/**
 * ClassName:UniqueViewServiceImpl
 * Package:top.heyqing.heyblog.service.impl
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Service
public class UniqueViewServiceImpl extends ServiceImpl<UniqueViewMapper, UniqueView> implements UniqueViewService {

    @Autowired
    private UniqueViewMapper uniqueViewMapper;

    @Override
    public List<UniqueViewDTO> listUniqueViews() {
        DateTime startTime = DateUtil.beginOfDay(DateUtil.offsetDay(new Date(), -7));
        DateTime endTime = DateUtil.endOfDay(new Date());
        return uniqueViewMapper.listUniqueViews(startTime, endTime);
    }

}
