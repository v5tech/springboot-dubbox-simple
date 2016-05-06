package net.aimeizi.student;

import javax.validation.constraints.Min;
import javax.ws.rs.BeanParam;

/**
 * Created by Administrator on 2016/5/6 0006.
 * 发布rest接口服务，注解添加在实现上
 */
public interface StudentRestService {

    Student getStudent(@Min(value=1L, message="学生id必须大于0") Long id/*, HttpServletRequest request*/);

    Student registerStudent(@BeanParam Student student);
}