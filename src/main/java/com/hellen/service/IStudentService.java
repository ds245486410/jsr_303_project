package com.hellen.service;

import com.hellen.domain.Student;

/**
 * Created by DS on 2018/1/6.
 */
public interface IStudentService {
    Student selectOne(Long id);
    Integer insertOne(Student student);
}
