package net.aimeizi.service.student;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import lombok.Setter;
import net.aimeizi.student.Student;
import net.aimeizi.student.StudentRestService;
import net.aimeizi.student.StudentService;

import javax.validation.constraints.Min;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Administrator on 2016/5/6 0006.
 * 发布rest接口服务，注解添加在实现上
 */
@Path("students")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class StudentRestServiceImpl implements StudentRestService {

    @Setter
    private StudentService studentService;

    @GET
    @Path("{id : \\d+}")
    @Override
    public Student getStudent(@PathParam("id") @Min(value = 1L, message = "学生id必须大于0") Long id) {
        return studentService.getStudent(id);
    }

    @POST
    @Path("register")
    @Override
    public Student registerStudent(@BeanParam Student student) {
        return studentService.registerStudent(student);
    }

}
