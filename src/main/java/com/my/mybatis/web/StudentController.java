package com.my.mybatis.web;

import com.my.mybatis.entity.Classroom;
import com.my.mybatis.entity.Student;
import com.my.mybatis.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/student")
@Validated
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("/queryAll")
    public List<Student> queryAllStudents(){
        return studentMapper.selectAll();
    }

    @RequestMapping("/query")
    public Student queryStudent(@NotNull(message = "学生编号不能为空") Integer id){
        return studentMapper.selectByPrimaryKey(id);
    }

    @RequestMapping("/addOne")
    public String addStudent(){
        Classroom classroom = new Classroom(4, null);
        Student student = new Student(null, "小王", "男", 15, classroom);
        int result = studentMapper.insertOne(student);
        Assert.isTrue(result != 0,"新增学生信息失败！");
        return "新增学生信息成功！";
    }

}
