package net.aimeizi.service.student;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import lombok.Setter;
import net.aimeizi.student.Student;
import net.aimeizi.student.StudentRestService;
import net.aimeizi.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Min;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Created by Administrator on 2016/5/6 0006.
 * 基于注解驱动的rest服务
 */

@Service(protocol = {"rest", "dubbo"}, group = "annotationConfig", validation = "true")
@Path("customers")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class AnnotationDrivenStudentRestServiceImpl implements StudentRestService {

    @Autowired
    @Setter
    private StudentService studentService;

    @Override
    @GET
    @Path("{id : \\d+}")
    public Student getStudent(@PathParam("id") @Min(value = 1L, message = "学生id必须大于0") Long id /*, @Context HttpServletRequest request, @Context HttpServletRequest request*/) {
//        System.out.println("Client address from @Context injection: " + (request != null ? request.getRemoteAddr() : ""));
//        System.out.println("Client address from RpcContext: " + RpcContext.getContext().getRemoteAddressString());
        return studentService.getStudent(id);
    }

    @Override
    @POST
    @Path("register")
    public Student registerStudent(@BeanParam Student student) {
        return studentService.registerStudent(student);
    }
}
