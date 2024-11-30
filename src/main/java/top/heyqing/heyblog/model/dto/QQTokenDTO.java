package top.heyqing.heyblog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:QQTokenDTO
 * Package:top.heyqing.heyblog.model.dto
 * Description:
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QQTokenDTO {

    private String openid;

    private String client_id;

}
