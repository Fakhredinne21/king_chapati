package fakhredinne.king_chapati.services;

import fakhredinne.king_chapati.models.Cart;
import fakhredinne.king_chapati.models.Customer;
import fakhredinne.king_chapati.models.Meal;
import fakhredinne.king_chapati.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
@Autowired
CartRepository cartRepository;
@Autowired
MealService mealService;
public void save(Cart cart)
{
     cartRepository.save(cart);
}
public Cart findByCustomerId(Customer id){
    return cartRepository.findCartByCustomer(id);
}



}
