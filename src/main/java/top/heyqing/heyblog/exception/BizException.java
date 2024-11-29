package top.heyqing.heyblog.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import top.heyqing.heyblog.model.enums.StatusCodeEnum;

/**
 * ClassName:BizException
 * Package:top.heyqing.heyblog.exception
 * Description:
 * 业务异常
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
@Getter
@AllArgsConstructor
public class BizException extends RuntimeException {

    private Integer code = StatusCodeEnum.FAIL.getCode();

    private final String message;

    public BizException(String message) {
        this.message = message;
    }

    public BizException(StatusCodeEnum statusCodeEnum) {
        this.code = statusCodeEnum.getCode();
        this.message = statusCodeEnum.getDesc();
    }

}
