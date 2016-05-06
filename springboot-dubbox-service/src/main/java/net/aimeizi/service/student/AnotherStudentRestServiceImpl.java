package net.aimeizi.service.student;

import lombok.Setter;
import net.aimeizi.student.AnotherStudentRestService;
import net.aimeizi.student.Student;
import net.aimeizi.student.StudentService;

import javax.validation.constraints.Min;
import javax.ws.rs.BeanParam;

/**
 * Created by Administrator on 2016/5/6 0006.
 * 发布rest接口服务，注解添加在接口上
 */
public class AnotherStudentRestServiceImpl implements AnotherStudentRestService {

    @Setter
    private StudentService studentService;

    @Override
    public Student getStudent(@Min(value = 1L, message = "学生id必须大于0") Long id) {
        return studentService.getStudent(id);
    }

    @Override
    public Student registerStudent(@BeanParam Student student) {
        return studentService.registerStudent(student);
    }
}
