package top.heyqing.heyblog.service;

import io.jsonwebtoken.Claims;
import top.heyqing.heyblog.model.dto.UserDetailsDTO;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName:TokenService
 * Package:top.heyqing.heyblog.service
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
public interface TokenService {

    String createToken(UserDetailsDTO userDetailsDTO);

    String createToken(String subject);

    void refreshToken(UserDetailsDTO userDetailsDTO);

    void renewToken(UserDetailsDTO userDetailsDTO);

    Claims parseToken(String token);

    UserDetailsDTO getUserDetailDTO(HttpServletRequest request);

    void delLoginUser(Integer userId);

}
