package com.my.mybatis.mapper;

import com.my.mybatis.entity.Classroom;

import java.util.List;

public interface ClassroomMapper {

    List<Classroom> selectAll();

    Classroom selectByPrimaryKey(Integer id);

    void insert(Classroom classroom);

    void updateByPrimaryKey(Classroom classroom);

    void deleteByPrimaryKey(Integer id);
}
