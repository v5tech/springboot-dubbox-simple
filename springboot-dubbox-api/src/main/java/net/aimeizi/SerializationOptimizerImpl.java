package net.aimeizi;

import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import net.aimeizi.user.User;


import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SerializationOptimizerImpl implements SerializationOptimizer {

    @Override
    public Collection<Class> getSerializableClasses() {
        List<Class> classes = new LinkedList<Class>();
        classes.add(User.class);
        classes.add(DataResult.class);

        return classes;
    }
}
