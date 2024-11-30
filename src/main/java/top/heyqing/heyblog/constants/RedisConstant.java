package top.heyqing.heyblog.constants;

/**
 * ClassName:RedisConstant
 * Package:top.heyqing.heyblog.constants
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
public interface RedisConstant {

    long CODE_EXPIRE_TIME = 15 * 60;

    String USER_CODE_KEY = "code:";

    String BLOG_VIEWS_COUNT = "blog_views_count";

    String ARTICLE_VIEWS_COUNT = "article_views_count";

    String WEBSITE_CONFIG = "website_config";

    String USER_AREA = "user_area";

    String VISITOR_AREA = "visitor_area";

    String ABOUT = "about";

    String UNIQUE_VISITOR = "unique_visitor";

    String LOGIN_USER = "login_user";

    String ARTICLE_ACCESS = "article_access:";

}
