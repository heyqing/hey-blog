package top.heyqing.heyblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.heyqing.heyblog.model.dto.PageResultDTO;
import top.heyqing.heyblog.model.dto.RoleDTO;
import top.heyqing.heyblog.model.dto.UserRoleDTO;
import top.heyqing.heyblog.model.entity.Role;
import top.heyqing.heyblog.model.vo.ConditionVO;
import top.heyqing.heyblog.model.vo.RoleVO;

import java.util.List;

/**
 * ClassName:RoleService
 * Package:top.heyqing.heyblog.service
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
public interface RoleService extends IService<Role> {

    List<UserRoleDTO> listUserRoles();

    PageResultDTO<RoleDTO> listRoles(ConditionVO conditionVO);

    void saveOrUpdateRole(RoleVO roleVO);

    void deleteRoles(List<Integer> ids);

}