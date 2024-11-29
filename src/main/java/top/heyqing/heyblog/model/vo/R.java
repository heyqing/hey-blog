package top.heyqing.heyblog.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.heyqing.heyblog.model.enums.StatusCodeEnum;
import static top.heyqing.heyblog.model.enums.StatusCodeEnum.*;

/**
 * ClassName:R
 * Package:top.heyqing.heyblog.model.vo
 * Description:
 * 用户返回实体
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("all")
public class R<T> {
    private Boolean flag;

    private Integer code;

    private String message;

    private T data;

    public static <T> R<T> ok() {
        return r(true, SUCCESS.getCode(), SUCCESS.getDesc(), null);
    }

    public static <T> R<T> ok(T data) {
        return r(true, SUCCESS.getCode(), SUCCESS.getDesc(), data);
    }

    public static <T> R<T> ok(T data, String message) {
        return r(true, SUCCESS.getCode(), message, data);
    }

    public static <T> R<T> fail() {
        return r(false, FAIL.getCode(), FAIL.getDesc(), null);
    }

    public static <T> R<T> fail(StatusCodeEnum statusCodeEnum) {
        return r(false, statusCodeEnum.getCode(), statusCodeEnum.getDesc(), null);
    }

    public static <T> R<T> fail(String message) {
        return r(false, message);
    }

    public static <T> R<T> fail(T data) {
        return r(false, FAIL.getCode(), FAIL.getDesc(), data);
    }

    public static <T> R<T> fail(T data, String message) {
        return r(false, FAIL.getCode(), message, data);
    }

    public static <T> R<T> fail(Integer code, String message) {
        return r(false, code, message, null);
    }

    private static <T> R<T> r(Boolean flag, String message) {
        return R.<T>builder()
                .flag(flag)
                .code(flag ? SUCCESS.getCode() : FAIL.getCode())
                .message(message).build();
    }

    private static <T> R<T> r(Boolean flag, Integer code, String message, T data) {
        return R.<T>builder()
                .flag(flag)
                .code(code)
                .message(message)
                .data(data).build();
    }
}
