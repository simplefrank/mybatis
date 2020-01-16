package com.my.mybatis.mapper;

import com.my.mybatis.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select * from student")
    List<Student> selectAll();

    @Select("select * from student where id = #{id}")
    Student selectByPrimaryKey(Integer id);

    @Insert("insert into student(name, sex, class_id, age) values(#{name}, #{sex}, #{classroom.id}, #{age})")
    int insertOne(Student stu);

    @Select("delete from student where id = #{id}")
    int deleteByPrimaryKey(Integer id);
}
