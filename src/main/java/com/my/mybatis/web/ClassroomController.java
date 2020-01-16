package com.my.mybatis.web;

import com.my.mybatis.entity.Classroom;
import com.my.mybatis.service.ClassroomService;
import com.my.mybatis.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/classroom")
@Validated
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @RequestMapping("/update")
    public Object update(@NotNull(message = "班级编号不能为空") Integer id, @NotBlank(message = "班级名称不能为空") String name, HttpServletRequest request){
        Classroom classroom = classroomService.queryByPrimaryKey(id);
        classroom.setName(name);
        List<Classroom> classrooms = classroomService.update(classroom);
        return ResponseUtil.outputSuccess(classrooms);
    }

    @RequestMapping("/change")
    public Object change(){
        classroomService.exchange(1, 5);
        return "成功";
    }
}
