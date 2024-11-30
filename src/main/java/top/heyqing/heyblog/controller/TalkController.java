package top.heyqing.heyblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.heyqing.heyblog.annotation.OptLog;
import top.heyqing.heyblog.model.dto.PageResultDTO;
import top.heyqing.heyblog.model.dto.TalkAdminDTO;
import top.heyqing.heyblog.model.dto.TalkDTO;
import top.heyqing.heyblog.model.enums.FilePathEnum;
import top.heyqing.heyblog.model.vo.ConditionVO;
import top.heyqing.heyblog.model.vo.R;
import top.heyqing.heyblog.model.vo.TalkVO;
import top.heyqing.heyblog.service.TalkService;
import top.heyqing.heyblog.strategy.context.UploadStrategyContext;

import javax.validation.Valid;
import java.util.List;

import static top.heyqing.heyblog.constants.OptTypeConstant.*;

/**
 * ClassName:TalkController
 * Package:top.heyqing.heyblog.controller
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Api(tags = "说说模块")
@RestController
public class TalkController {

    @Autowired
    private TalkService talkService;

    @Autowired
    private UploadStrategyContext uploadStrategyContext;

    @ApiOperation(value = "查看说说列表")
    @GetMapping("/talks")
    public R<PageResultDTO<TalkDTO>> listTalks() {
        return R.ok(talkService.listTalks());
    }

    @ApiOperation(value = "根据id查看说说")
    @ApiImplicitParam(name = "talkId", value = "说说id", required = true, dataType = "Integer")
    @GetMapping("/talks/{talkId}")
    public R<TalkDTO> getTalkById(@PathVariable("talkId") Integer talkId) {
        return R.ok(talkService.getTalkById(talkId));
    }

    @OptLog(optType = UPLOAD)
    @ApiOperation(value = "上传说说图片")
    @ApiImplicitParam(name = "file", value = "说说图片", required = true, dataType = "MultipartFile")
    @PostMapping("/admin/talks/images")
    public R<String> saveTalkImages(MultipartFile file) {
        return R.ok(uploadStrategyContext.executeUploadStrategy(file, FilePathEnum.TALK.getPath()));
    }

    @OptLog(optType = SAVE_OR_UPDATE)
    @ApiOperation(value = "保存或修改说说")
    @PostMapping("/admin/talks")
    public R<?> saveOrUpdateTalk(@Valid @RequestBody TalkVO talkVO) {
        talkService.saveOrUpdateTalk(talkVO);
        return R.ok();
    }

    @OptLog(optType = DELETE)
    @ApiOperation(value = "删除说说")
    @DeleteMapping("/admin/talks")
    public R<?> deleteTalks(@RequestBody List<Integer> talkIds) {
        talkService.deleteTalks(talkIds);
        return R.ok();
    }

    @ApiOperation(value = "查看后台说说")
    @GetMapping("/admin/talks")
    public R<PageResultDTO<TalkAdminDTO>> listBackTalks(ConditionVO conditionVO) {
        return R.ok(talkService.listBackTalks(conditionVO));
    }

    @ApiOperation(value = "根据id查看后台说说")
    @ApiImplicitParam(name = "talkId", value = "说说id", required = true, dataType = "Integer")
    @GetMapping("/admin/talks/{talkId}")
    public R<TalkAdminDTO> getBackTalkById(@PathVariable("talkId") Integer talkId) {
        return R.ok(talkService.getBackTalkById(talkId));
    }

}

