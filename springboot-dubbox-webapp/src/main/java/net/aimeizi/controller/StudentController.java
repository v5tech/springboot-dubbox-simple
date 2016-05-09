package net.aimeizi.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import lombok.Setter;
import net.aimeizi.student.Student;
import net.aimeizi.student.StudentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016/5/6 0006.
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    @Reference(group = "xmlConfig")
    @Setter
    private StudentService studentService;

    @RequestMapping("/get/{id}")
    public Student student(@PathVariable("id") Long id){
        return studentService.getStudent(id);
    }

}
