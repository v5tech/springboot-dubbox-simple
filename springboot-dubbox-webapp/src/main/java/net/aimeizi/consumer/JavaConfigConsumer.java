package net.aimeizi.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import net.aimeizi.student.AnotherStudentRestService;
import net.aimeizi.student.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2016/5/6 0006.
 * java config consumer示例
 */
@Component
public class JavaConfigConsumer {

    @Reference
    private AnotherStudentRestService anotherStudentRestService;

    @PostConstruct
    public void start() throws Exception {
        Student student = new Student(1L, "dubbo");
        System.out.println("SUCESS: registered user with id " + anotherStudentRestService.registerStudent(student).getId());
        System.out.println("SUCESS: got user " + anotherStudentRestService.getStudent(1L));
    }
}
