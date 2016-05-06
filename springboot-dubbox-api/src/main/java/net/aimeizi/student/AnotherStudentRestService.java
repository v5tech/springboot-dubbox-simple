package net.aimeizi.student;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

import javax.validation.constraints.Min;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Administrator on 2016/5/6 0006.
 * 发布rest接口服务，注解添加在接口上
 */
@Path("s")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public interface AnotherStudentRestService {

    @GET
    @Path("{id : \\d+}")
    Student getStudent(@PathParam("id") @Min(value=1L, message="学生id必须大于0") Long id/*, HttpServletRequest request*/);

    @POST
    @Path("register")
    Student registerStudent(@BeanParam Student student);

}
