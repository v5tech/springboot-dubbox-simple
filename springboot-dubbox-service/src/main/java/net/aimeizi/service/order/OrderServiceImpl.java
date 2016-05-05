package net.aimeizi.service.order;

import net.aimeizi.order.Order;
import net.aimeizi.order.OrderService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService.Iface {


    @Override
    public String ping() throws TException {
        return "pong";
    }

    @Override
    public Order getOrder(int orderId) throws TException {
        return new Order(orderId).setOrderTitle("dubbo");
    }
}
