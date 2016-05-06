package net.aimeizi.service.student;

import net.aimeizi.student.Student;
import net.aimeizi.student.StudentService;

import javax.validation.constraints.Min;

/**
 * Created by Administrator on 2016/5/6 0006.
 * 普通的service实现类，非rest服务
 */
public class StudentServiceImpl implements StudentService {

    @Override
    public Student getStudent(@Min(value = 0L, message = "学生id必须大于0") Long id) {
        Student student = new Student();
        student.setId(id);
        return student;
    }

    @Override
    public Student registerStudent(Student student) {
        return student;
    }

}
