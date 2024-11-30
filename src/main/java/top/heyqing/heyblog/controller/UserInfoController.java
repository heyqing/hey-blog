package top.heyqing.heyblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.heyqing.heyblog.annotation.OptLog;
import top.heyqing.heyblog.model.dto.PageResultDTO;
import top.heyqing.heyblog.model.dto.UserInfoDTO;
import top.heyqing.heyblog.model.dto.UserOnlineDTO;
import top.heyqing.heyblog.model.vo.*;
import top.heyqing.heyblog.service.UserInfoService;

import javax.validation.Valid;

import static top.heyqing.heyblog.constants.OptTypeConstant.*;

/**
 * ClassName:UserInfoController
 * Package:top.heyqing.heyblog.controller
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Api(tags = "用户信息模块")
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @OptLog(optType = UPDATE)
    @ApiOperation("更新用户信息")
    @PutMapping("/users/info")
    public R<?> updateUserInfo(@Valid @RequestBody UserInfoVO userInfoVO) {
        userInfoService.updateUserInfo(userInfoVO);
        return R.ok();
    }

    @OptLog(optType = UPDATE)
    @ApiOperation("更新用户头像")
    @ApiImplicitParam(name = "file", value = "用户头像", required = true, dataType = "MultipartFile")
    @PostMapping("/users/avatar")
    public R<String> updateUserAvatar(MultipartFile file) {
        return R.ok(userInfoService.updateUserAvatar(file));
    }

    @OptLog(optType = UPDATE)
    @ApiOperation("绑定用户邮箱")
    @PutMapping("/users/email")
    public R<?> saveUserEmail(@Valid @RequestBody EmailVO emailVO) {
        userInfoService.saveUserEmail(emailVO);
        return R.ok();
    }

    @OptLog(optType = UPDATE)
    @ApiOperation("修改用户的订阅状态")
    @PutMapping("/users/subscribe")
    public R<?> updateUserSubscribe(@RequestBody SubscribeVO subscribeVO) {
        userInfoService.updateUserSubscribe(subscribeVO);
        return R.ok();
    }

    @OptLog(optType = UPDATE)
    @ApiOperation(value = "修改用户角色")
    @PutMapping("/admin/users/role")
    public R<?> updateUserRole(@Valid @RequestBody UserRoleVO userRoleVO) {
        userInfoService.updateUserRole(userRoleVO);
        return R.ok();
    }

    @OptLog(optType = UPDATE)
    @ApiOperation(value = "修改用户禁用状态")
    @PutMapping("/admin/users/disable")
    public R<?> updateUserDisable(@Valid @RequestBody UserDisableVO userDisableVO) {
        userInfoService.updateUserDisable(userDisableVO);
        return R.ok();
    }

    @ApiOperation(value = "查看在线用户")
    @GetMapping("/admin/users/online")
    public R<PageResultDTO<UserOnlineDTO>> listOnlineUsers(ConditionVO conditionVO) {
        return R.ok(userInfoService.listOnlineUsers(conditionVO));
    }

    @OptLog(optType = DELETE)
    @ApiOperation(value = "下线用户")
    @DeleteMapping("/admin/users/{userInfoId}/online")
    public R<?> removeOnlineUser(@PathVariable("userInfoId") Integer userInfoId) {
        userInfoService.removeOnlineUser(userInfoId);
        return R.ok();
    }

    @ApiOperation("根据id获取用户信息")
    @GetMapping("/users/info/{userInfoId}")
    public R<UserInfoDTO> getUserInfoById(@PathVariable("userInfoId") Integer userInfoId) {
        return R.ok(userInfoService.getUserInfoById(userInfoId));
    }

}
