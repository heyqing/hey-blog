package top.heyqing.heyblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.heyqing.heyblog.exception.BizException;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName:BizExceptionController
 * Package:top.heyqing.heyblog.controller
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Api(tags = "异常处理模块")
@RestController
public class BizExceptionController {

    @SneakyThrows
    @ApiOperation("/处理BizException")
    @RequestMapping("/bizException")
    public void handleBizException(HttpServletRequest request) {
        if (request.getAttribute("bizException") instanceof BizException) {
            System.out.println(request.getAttribute("bizException"));
            throw ((BizException) request.getAttribute("bizException"));
        } else {
            throw new Exception();
        }
    }

}
