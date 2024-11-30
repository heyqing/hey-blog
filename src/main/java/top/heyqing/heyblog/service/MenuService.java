package top.heyqing.heyblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.heyqing.heyblog.model.dto.LabelOptionDTO;
import top.heyqing.heyblog.model.dto.MenuDTO;
import top.heyqing.heyblog.model.dto.UserMenuDTO;
import top.heyqing.heyblog.model.entity.Menu;
import top.heyqing.heyblog.model.vo.ConditionVO;
import top.heyqing.heyblog.model.vo.IsHiddenVO;
import top.heyqing.heyblog.model.vo.MenuVO;

import java.util.List;

/**
 * ClassName:MenuService
 * Package:top.heyqing.heyblog.service
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
public interface MenuService extends IService<Menu> {

    List<MenuDTO> listMenus(ConditionVO conditionVO);

    void saveOrUpdateMenu(MenuVO menuVO);

    void updateMenuIsHidden(IsHiddenVO isHiddenVO);

    void deleteMenu(Integer menuId);

    List<LabelOptionDTO> listMenuOptions();

    List<UserMenuDTO> listUserMenus();

}