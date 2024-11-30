package top.heyqing.heyblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.heyqing.heyblog.annotation.AccessLimit;
import top.heyqing.heyblog.annotation.OptLog;
import top.heyqing.heyblog.model.dto.*;
import top.heyqing.heyblog.model.vo.*;
import top.heyqing.heyblog.service.UserAuthService;

import javax.validation.Valid;
import java.util.List;

import static top.heyqing.heyblog.constants.OptTypeConstant.UPDATE;

/**
 * ClassName:UserAuthController
 * Package:top.heyqing.heyblog.controller
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Api(tags = "用户账号模块")
@RestController
public class UserAuthController {

    @Autowired
    private UserAuthService userAuthService;

    @AccessLimit(seconds = 60, maxCount = 1)
    @ApiOperation(value = "发送邮箱验证码")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String")
    @GetMapping("/users/code")
    public R<?> sendCode(String username) {
        userAuthService.sendCode(username);
        return R.ok();
    }

    @ApiOperation(value = "获取用户区域分布")
    @GetMapping("/admin/users/area")
    public R<List<UserAreaDTO>> listUserAreas(ConditionVO conditionVO) {
        return R.ok(userAuthService.listUserAreas(conditionVO));
    }

    @ApiOperation(value = "查询后台用户列表")
    @GetMapping("/admin/users")
    public R<PageResultDTO<UserAdminDTO>> listUsers(ConditionVO conditionVO) {
        return R.ok(userAuthService.listUsers(conditionVO));
    }

    @ApiOperation(value = "用户注册")
    @PostMapping("/users/register")
    public R<?> register(@Valid @RequestBody UserVO userVO) {
        userAuthService.register(userVO);
        return R.ok();
    }

    @OptLog(optType = UPDATE)
    @ApiOperation(value = "修改密码")
    @PutMapping("/users/password")
    public R<?> updatePassword(@Valid @RequestBody UserVO user) {
        userAuthService.updatePassword(user);
        return R.ok();
    }

    @OptLog(optType = UPDATE)
    @ApiOperation(value = "修改管理员密码")
    @PutMapping("/admin/users/password")
    public R<?> updateAdminPassword(@Valid @RequestBody PasswordVO passwordVO) {
        userAuthService.updateAdminPassword(passwordVO);
        return R.ok();
    }

    @ApiOperation("用户登出")
    @PostMapping("/users/logout")
    public R<UserLogoutStatusDTO> logout() {
        return R.ok(userAuthService.logout());
    }

    @ApiOperation(value = "qq登录")
    @PostMapping("/users/oauth/qq")
    public R<UserInfoDTO> qqLogin(@Valid @RequestBody QQLoginVO qqLoginVO) {
        return R.ok(userAuthService.qqLogin(qqLoginVO));
    }

}
