package net.aimeizi;

import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import net.aimeizi.student.Student;
import net.aimeizi.user.User;


import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * 启用Kryo和FST序列化
 * <dubbo:protocol name="dubbo" serialization="kryo"/>
 * <dubbo:protocol name="dubbo" serialization="fst"/>
 * 在生产环境建议使用Kryo
 * 要让Kryo和FST完全发挥出高性能，最好将那些需要被序列化的类注册到dubbo系统中实现该回调接口，注册需要被序列化的类
 * <dubbo:protocol name="dubbo" serialization="kryo" optimizer="net.aimeizi.SerializationOptimizerImpl"/>
 */
public class SerializationOptimizerImpl implements SerializationOptimizer {

    @Override
    public Collection<Class> getSerializableClasses() {
        List<Class> classes = new LinkedList<Class>();
        classes.add(User.class);
        classes.add(DataResult.class);
        classes.add(Student.class);
        return classes;
    }
}
