package com.hellen.web.controller.base;

import com.hellen.vo.JsonResult;

/**
 * Created by DS on 2018/1/6.
 */
public class BaseController {
    protected JsonResult success(){
        return success("操作成功");
    }
    protected JsonResult success(String msg){
        return new JsonResult(msg, true);
    }
    protected JsonResult failed(){
        return failed("操作失败");
    }
    protected JsonResult failed(String msg){
        return new JsonResult(msg,false);
    }
}
