package com.shuhao.main.util;

import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.entity.ResultCode;

/**
 * @Description: 返回体构造工具
 * @author: XiaoShu
 * @date:
 */
public class ResultTool {

    public static JsonResult success(){
        return new JsonResult(true);
    }

    public static JsonResult success(ResultCode resultEnum) {
        return new JsonResult(true, resultEnum);
    }

    public static <T> JsonResult<T> success(T data){
        return new JsonResult<>(true,data);
    }

    public static <T> JsonResult<T> success(T data,ResultCode resultEnum){
        return new JsonResult<>(true,resultEnum,data);
    }

    public static JsonResult error(){
        return new JsonResult(false);
    }

    public static JsonResult error(ResultCode resultEnum) {
        return new JsonResult(false, resultEnum);
    }

    public static <T> JsonResult<T> error(T data){
        return new JsonResult<>(false,data);
    }

    public static <T> JsonResult<T> error(T data,ResultCode resultEnum){
        return new JsonResult<>(false,resultEnum,data);
    }

}
