package fakhredinne.king_chapati.services;

import fakhredinne.king_chapati.models.OrderItem;
import fakhredinne.king_chapati.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    OrderItemRepository orderItemRepository;
    public void save(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }
    public void delete(OrderItem orderItem) {
        orderItemRepository.delete(orderItem);
    }
    public OrderItem findById(Long id) {
        return orderItemRepository.findById(id).get();
    }
    public Iterable<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }
    public void deleteById(Long id) {
        orderItemRepository.deleteById(id);
    }

}
