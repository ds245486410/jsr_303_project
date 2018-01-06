package com.hellen.web.controller.base;

import com.alibaba.fastjson.JSON;
import com.hellen.vo.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * Created by DS on 2018/1/6.
 */
@ControllerAdvice
@Slf4j
public class Advice extends BaseController{


    @ExceptionHandler({Exception.class})
    @ResponseBody
    public JsonResult exceptionHandle(Exception ex){
        String message = ex.getMessage();
        log.error(JSON.toJSONString(ex));
         /*if (ex instanceof UnauthorizedException) {
            message = "没有权限，请联系管理员";
        } else */
        if (ex instanceof BindException) {
            BindException bindException = (BindException) ex;
            message = getBindingErrors(bindException.getBindingResult());
        } else if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) ex;
            message = getBindingErrors(methodArgumentNotValidException.getBindingResult());
        } else if (ex instanceof ConstraintViolationException) {
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) ex;
            ConstraintViolation<?> next                         = constraintViolationException.getConstraintViolations().iterator().next();
            message = next.getMessage();
        }

        log.error("[出现异常-请尽快检查并处理！]" + message);
        return failed(message);
    }

    /**
     * 组装参数校验错误信息
     *
     * @param bindingResult
     *
     * @return
     */
    private String getBindingErrors(BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        StringBuilder    errorMsg    = new StringBuilder();
        for (FieldError fieldError : fieldErrors) {
            errorMsg.append(fieldError.getDefaultMessage()).append(";");
        }
        return errorMsg.deleteCharAt(errorMsg.length() - 1).toString();
    }
}
