package net.aimeizi.user;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import net.aimeizi.DataResult;

import javax.validation.constraints.Min;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("user")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public interface UserRestService {

    @GET
    @Path("ping")
    String ping();

    @POST
    @Path("register")
    DataResult<User> registerUser(User u);

    @GET
    @Path("{id : \\d+}")
    DataResult<User> getUserById(@PathParam("id") @Min(value = 1, message = "userId必须>0") Long userId);

    @POST
    @Path("delete")
    DataResult<Boolean> deleteUserById(Long userId);

    @POST
    @Path("update/pwd")
    DataResult<Boolean> updatePassword(Long userId, String oldPwd, String newPwd);

    @GET
    @Path("get")
    DataResult<Boolean> get();

    @POST
    @Path("post")
    DataResult<Boolean> post();
}
