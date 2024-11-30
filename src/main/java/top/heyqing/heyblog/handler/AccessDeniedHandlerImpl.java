package top.heyqing.heyblog.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import top.heyqing.heyblog.constants.CommonConstant;
import top.heyqing.heyblog.model.vo.R;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName:AccessDeniedHandlerImpl
 * Package:top.heyqing.heyblog.handler
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        response.setContentType(CommonConstant.APPLICATION_JSON);
        response.getWriter().write(JSON.toJSONString(R.fail("权限不足")));
    }
}
