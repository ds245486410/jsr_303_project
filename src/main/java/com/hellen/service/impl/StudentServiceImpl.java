package com.hellen.service.impl;

import com.hellen.domain.Student;
import com.hellen.mapper.StudentMapper;
import com.hellen.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by DS on 2018/1/6.
 */

@Slf4j
@Service
public class StudentServiceImpl implements IStudentService {
    public static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student selectOne(Long id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer insertOne(Student student) {
        int insert = studentMapper.insert(student);
        insertTwo(student);
        //int i = 1/ 0;
        return insert;
    }

    @Transactional
    public Integer insertTwo(Student student) {
        student.setAge(11);
        student.setName("rollback");
        int insert = studentMapper.insert(student);
        return insert;
    }


}
