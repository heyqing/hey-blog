package top.heyqing.heyblog.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import top.heyqing.heyblog.model.dto.UserDetailsDTO;

/**
 * ClassName:UserUtil
 * Package:top.heyqing.heyblog.util
 * Description:
 *
 * @Date:2024/11/28
 * @Author:Heyqing
 */
@Component
public class UserUtil {

    public static UserDetailsDTO getUserDetailsDTO() {
        return (UserDetailsDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

}