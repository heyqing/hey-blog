package top.heyqing.heyblog.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Objects;

/**
 * ClassName:PageUtil
 * Package:top.heyqing.heyblog.util
 * Description:
 *
 * @Date:2024/11/28
 * @Author:Heyqing
 */
public class PageUtil {

    private static final ThreadLocal<Page<?>> PAGE_HOLDER = new ThreadLocal<>();

    public static void setCurrentPage(Page<?> page) {
        PAGE_HOLDER.set(page);
    }

    public static Page<?> getPage() {
        Page<?> page = PAGE_HOLDER.get();
        if (Objects.isNull(page)) {
            setCurrentPage(new Page<>());
        }
        return PAGE_HOLDER.get();
    }

    public static Long getCurrent() {
        return getPage().getCurrent();
    }

    public static Long getSize() {
        return getPage().getSize();
    }

    public static Long getLimitCurrent() {
        return (getCurrent() - 1) * getSize();
    }

    public static void remove() {
        PAGE_HOLDER.remove();
    }

}
