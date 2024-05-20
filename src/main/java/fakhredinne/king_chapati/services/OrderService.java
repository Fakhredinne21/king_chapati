package fakhredinne.king_chapati.services;

import fakhredinne.king_chapati.models.Cart;
import fakhredinne.king_chapati.models.Customer;
import fakhredinne.king_chapati.models.Order;
import fakhredinne.king_chapati.models.OrderItem;
import fakhredinne.king_chapati.repository.OrderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService  {
    @Autowired
    OrderRespository orderRespository;
    @Autowired
    OrderItemService orderItemService;
    public void checkout(Cart cart) {
        Order order = new Order();
        orderRespository.save(order);
        cart.getMeals().forEach(meal -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setMeal(meal);
            orderItem.setOrder(order);
            orderItem.setQuantity(1);
            orderItem.setStatus("Ordered");
            orderItem.setRestaurant(meal.getRestaurant());
            orderItemService.save(orderItem);
            order.getOrder_items().add(orderItem);
        });
        order.setCustomer(cart.getCustomer());
        order.setTotal_price(cart.getTotal_price());
        order.setOrderDate(java.time.LocalDateTime.now());
        order.setStatus("Ordered");
        order.setDestination(cart.getCustomer().getAddress());
        //order.setDelivAgent(delivAgent);
        order.setOrderDate(java.time.LocalDateTime.now());
        orderRespository.save(order);

    }
}
