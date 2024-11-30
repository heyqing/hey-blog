package top.heyqing.heyblog.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import top.heyqing.heyblog.constants.CommonConstant;
import top.heyqing.heyblog.model.vo.R;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName:AuthenticationFailHandlerImpl
 * Package:top.heyqing.heyblog.handler
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Component
public class AuthenticationFailHandlerImpl implements AuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        httpServletResponse.setContentType(CommonConstant.APPLICATION_JSON);
        httpServletResponse.getWriter().write(JSON.toJSONString(R.fail(e.getMessage())));
    }

}