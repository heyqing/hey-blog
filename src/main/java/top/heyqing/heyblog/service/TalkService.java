package top.heyqing.heyblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.heyqing.heyblog.model.dto.PageResultDTO;
import top.heyqing.heyblog.model.dto.TalkAdminDTO;
import top.heyqing.heyblog.model.dto.TalkDTO;
import top.heyqing.heyblog.model.entity.Talk;
import top.heyqing.heyblog.model.vo.ConditionVO;
import top.heyqing.heyblog.model.vo.TalkVO;

import java.util.List;

/**
 * ClassName:TalkService
 * Package:top.heyqing.heyblog.service
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
public interface TalkService extends IService<Talk> {

    PageResultDTO<TalkDTO> listTalks();

    TalkDTO getTalkById(Integer talkId);

    void saveOrUpdateTalk(TalkVO talkVO);

    void deleteTalks(List<Integer> talkIdList);

    PageResultDTO<TalkAdminDTO> listBackTalks(ConditionVO conditionVO);

    TalkAdminDTO getBackTalkById(Integer talkId);

}
