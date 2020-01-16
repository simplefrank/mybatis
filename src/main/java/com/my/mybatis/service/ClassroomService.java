package com.my.mybatis.service;

import com.my.mybatis.entity.Classroom;

import java.util.List;

public interface ClassroomService {

    /**
     * 根据主键查询班级
     *
     * @param id 班级编号
     * @return  编号对应的班级信息
     */
    Classroom queryByPrimaryKey(Integer id);

    /**
     * 更新主键对应的班级并查询所有班级信息
     *
     * @param classroom 待更新的班级类
     * @return 更新完后的所有班级信息
     */
    List<Classroom> update(Classroom classroom);

    void exchange(Integer id1, Integer id2);
}
