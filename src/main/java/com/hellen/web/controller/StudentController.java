package com.hellen.web.controller;

import com.alibaba.fastjson.JSON;
import com.hellen.domain.Student;
import com.hellen.service.IStudentService;
import com.hellen.vo.JsonResult;
import com.hellen.web.controller.base.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by DS on 2018/1/6.
 */
@Controller
@Slf4j
public class StudentController extends BaseController{

    @Autowired
    private IStudentService studentService;

    @RequestMapping("/stu")
    public String index(Long id, Model model){
        id = id==null?1:id;
        Student student = studentService.selectOne(id);
        model.addAttribute("student", JSON.toJSON(student));
        return "student/student";
    }

    @RequestMapping("insert")
    @ResponseBody
    public JsonResult insert(@Valid Student stu){
        JsonResult  result= failed();
        try {
            log.info(JSON.toJSONString(stu));
            result = success();
        }catch (Exception e){
            log.info(e+"");
        }

        return result;
    }
}
