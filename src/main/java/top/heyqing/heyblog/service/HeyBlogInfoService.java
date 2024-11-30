package top.heyqing.heyblog.service;

import top.heyqing.heyblog.model.dto.AboutDTO;
import top.heyqing.heyblog.model.dto.HeyBlogAdminInfoDTO;
import top.heyqing.heyblog.model.dto.HeyBlogHomeInfoDTO;
import top.heyqing.heyblog.model.dto.WebsiteConfigDTO;
import top.heyqing.heyblog.model.vo.AboutVO;
import top.heyqing.heyblog.model.vo.WebsiteConfigVO;

/**
 * ClassName:HeyBlogInfoService
 * Package:top.heyqing.heyblog.service
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
public interface HeyBlogInfoService {
    void report();

    HeyBlogHomeInfoDTO getHeyBlogHomeInfo();

    HeyBlogAdminInfoDTO getHeyBlogAdminInfo();

    void updateWebsiteConfig(WebsiteConfigVO websiteConfigVO);

    WebsiteConfigDTO getWebsiteConfig();

    void updateAbout(AboutVO aboutVO);

    AboutDTO getAbout();
}
