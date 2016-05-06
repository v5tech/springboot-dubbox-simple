package net.aimeizi.student;

import javax.validation.constraints.Min;
import javax.ws.rs.BeanParam;

/**
 * Created by Administrator on 2016/5/6 0006.
 * 非rest接口
 */
public interface StudentService {

    Student getStudent(@Min(value=0L, message="学生id必须大于0") Long id/*, HttpServletRequest request*/);

    Student registerStudent(@BeanParam Student student);
}
