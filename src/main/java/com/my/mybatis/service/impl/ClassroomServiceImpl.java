package com.my.mybatis.service.impl;

import com.my.mybatis.entity.Classroom;
import com.my.mybatis.mapper.ClassroomMapper;
import com.my.mybatis.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomMapper classroomMapper;

    @Override
    public Classroom queryByPrimaryKey(Integer id) {
        return classroomMapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    public List<Classroom> update(Classroom classroom) {
        classroomMapper.updateByPrimaryKey(classroom);
        return classroomMapper.selectAll();
    }

    @Transactional
    @Override
    public void exchange(Integer id1, Integer id2) {
        Classroom classroom1 = classroomMapper.selectByPrimaryKey(id1);
        Classroom classroom2 = classroomMapper.selectByPrimaryKey(id2);
        String className1 = classroom1.getName();
        String className2 = classroom2.getName();
        classroom1.setName(className2);
        classroom2.setName(className1);
        classroomMapper.updateByPrimaryKey(classroom1);
        classroomMapper.updateByPrimaryKey(classroom2);
    }
}
