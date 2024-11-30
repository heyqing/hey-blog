package top.heyqing.heyblog.handler;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.heyqing.heyblog.exception.BizException;
import top.heyqing.heyblog.model.enums.StatusCodeEnum;
import top.heyqing.heyblog.model.vo.R;

import java.util.Objects;

/**
 * ClassName:ControllerAdviceHandler
 * Package:top.heyqing.heyblog.handler
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Log4j2
@RestControllerAdvice
public class ControllerAdviceHandler {

    @ExceptionHandler(value = BizException.class)
    public R<?> errorHandler(BizException e) {
        return R.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R<?> errorHandler(MethodArgumentNotValidException e) {
        return R.fail(StatusCodeEnum.VALID_ERROR.getCode(), Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public R<?> errorHandler(Exception e) {
        e.printStackTrace();
        return R.fail(StatusCodeEnum.SYSTEM_ERROR.getCode(), StatusCodeEnum.SYSTEM_ERROR.getDesc());
    }

}

