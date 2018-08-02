package service;

import pojo.Order;
import pojo.OrderItem;

import java.util.List;

public interface OrderItemManager {
    public OrderItem addOrderItem(OrderItem orderItem,String mId);
    public void deleteOrderItemById(String id);
    public List<OrderItem> findOrderItemByOrder(String oId);
}