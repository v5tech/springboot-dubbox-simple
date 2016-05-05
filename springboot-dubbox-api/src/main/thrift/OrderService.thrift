namespace java net.aimeizi.order

include "Order.thrift"

service OrderService{

    string ping();

    Order.Order getOrder(1:i32 orderId);

}