package fakhredinne.king_chapati.repository;

import fakhredinne.king_chapati.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRespository extends JpaRepository<Order, Long> {

}
