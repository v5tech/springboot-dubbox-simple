package net.aimeizi.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement
public class User implements Serializable {

    private static final long serialVersionUID = -2027325652889623251L;

    /**
     * 用户ID
     */
    @Range(min = 1, max = Long.MAX_VALUE, message = "userId必须大于0")
    private Long userId;

    /**
     * 用户名
     */
    @NotNull(message = "名称不能为空")
    @Length(min = 2, max = 20, message = "名称长度范围为2-20位字符")
    private String name;

    /**
     * 密码
     */
    @Length(min = 8, message = "密码长度不能低于8位")
    private String password;

    /**
     * 年龄
     */
    @Range(min = 0, max = 150, message = "年龄只能在0-150岁之间")
    private Integer age;

}
