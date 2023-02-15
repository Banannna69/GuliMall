package com.gulimall.product.exception;

import com.gulimall.common.exception.BizCodeEnum;
import com.gulimall.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 集中处理所有异常
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.gulimall.product.controller") //@ResponseBody + @ControllerAdvice
public class GulimallExceptionControllerAdvice {


    @ExceptionHandler(value= Exception.class)
    public R handleValidException(MethodArgumentNotValidException e){
        //log.error("数据校验出现问题：{},异常类型：{}",e.getMessage(),e.getClass());
        BindingResult result = e.getBindingResult();

        Map<String,String> errorMap = new HashMap<String,String>();
        result.getFieldErrors().forEach((fieldError)->{
            errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
        return R.error(BizCodeEnum.VALID_EXCEPTION.getCode(),BizCodeEnum.VALID_EXCEPTION.getMsg()).put("error",errorMap);
    }

    @ExceptionHandler(value= Throwable.class)
    public R handleException(Throwable e){
        return R.error(BizCodeEnum.UNKNOWN_EXCEPTION.getCode(),BizCodeEnum.UNKNOWN_EXCEPTION.getMsg());
    }
}
