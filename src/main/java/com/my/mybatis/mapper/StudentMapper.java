package com.my.mybatis.mapper;

import com.my.mybatis.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface StudentMapper {

    @Select({"select * from student"})
    @Results(id = "studentMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "age", column = "age"),
            @Result(property = "classroom", column = "class_id", one = @One(
                    select = "com.my.mybatis.mapper.ClassroomMapper.selectByPrimaryKey", fetchType = FetchType.LAZY
            )),
    })
    List<Student> selectAll();

    @Select("select * from student where id = #{id}")
    @ResultMap("studentMap")
    Student selectByPrimaryKey(@Param("id") Integer id);

    @Insert("insert into student(name, sex, class_id, age) values(#{name}, #{sex}, #{classroom.id}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertOne(@Param("stu") Student stu);

    @Select("delete from student where id = #{id}")
    int deleteByPrimaryKey(@Param("id") Integer id);
}
