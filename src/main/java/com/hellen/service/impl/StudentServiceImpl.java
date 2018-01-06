package com.hellen.service.impl;

import com.alibaba.fastjson.JSON;
import com.hellen.domain.Student;
import com.hellen.mapper.StudentMapper;
import com.hellen.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by DS on 2018/1/6.
 */
@Slf4j
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student selectOne(Long id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer insertOne(Student student) {
        log.info(JSON.toJSONString(student));
        return studentMapper.insert(student);
    }


}
