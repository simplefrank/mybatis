package com.my.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(value = { "handler" }) //开启懒加载时需要该注解，使json序列化时忽略 bean 中的一些不需要转化的属性
public class Student implements Serializable {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private Classroom classroom;

    public Student() {
    }

    public Student(Integer id, String name, String sex, Integer age, Classroom classroom) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.classroom = classroom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", classroom=" + classroom +
                '}';
    }
}
