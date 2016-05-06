package net.aimeizi.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/6 0006.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Student implements Serializable {

    /**
     * 学生ID
     */
    @Range(min = 1, max = Long.MAX_VALUE, message = "Id必须大于0")
    private  Long id;

    /**
     * 用户名
     */
    @JsonProperty("username")
    @NotNull(message = "名称不能为空")
    @Length(min = 2, max = 20, message = "名称长度范围为2-20位字符")
    private String name;
}
