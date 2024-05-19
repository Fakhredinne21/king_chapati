package fakhredinne.king_chapati.repository;

import fakhredinne.king_chapati.models.Cart;
import fakhredinne.king_chapati.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
      public Cart findCartByCustomer(Customer id);

}
