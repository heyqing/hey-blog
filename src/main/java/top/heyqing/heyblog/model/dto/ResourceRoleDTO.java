package top.heyqing.heyblog.model.dto;

import lombok.Data;

import java.util.List;

/**
 * ClassName:ResourceRoleDTO
 * Package:top.heyqing.heyblog.model.dto
 * Description:
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
@Data
public class ResourceRoleDTO {

    private Integer id;

    private String url;

    private String requestMethod;

    private List<String> roleList;

}
