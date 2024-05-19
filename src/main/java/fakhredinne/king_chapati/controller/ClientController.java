package fakhredinne.king_chapati.controller;

import fakhredinne.king_chapati.models.Cart;
import fakhredinne.king_chapati.models.Customer;
import fakhredinne.king_chapati.models.Meal;
import fakhredinne.king_chapati.services.CartService;
import fakhredinne.king_chapati.services.CustomerService;
import fakhredinne.king_chapati.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
@PreAuthorize("hasRole('ROLE_CUSTOMER')")
public class ClientController {
    @Autowired
    MealService mealService;
    @Autowired
    CartService cartService;
    @Autowired
    CustomerService customerService;
    Customer customer;

    @GetMapping("" )
    public String main(Model model) {
        List<Meal> listMeals = mealService.findAll();
        model.addAttribute("listMeals",listMeals);
        return "ClientSide/index";
    }

    @GetMapping("/cart")
    public String showcart(Model model,@AuthenticationPrincipal UserDetails userDetails)

    {
        customer = customerService.findByUsername(userDetails.getUsername());
        Cart cart = cartService.findByCustomerId(customer);
        model.addAttribute("cart",cart);
        return "ClientSide/cart";
    }
    @GetMapping("/addtocart/{mealId}")
    public String addtocart(@PathVariable Long mealId,@AuthenticationPrincipal UserDetails userDetails)
    {
        customer = customerService.findByUsername(userDetails.getUsername());
        Cart cart = cartService.findByCustomerId(customer);
        cart.getMeals().add(mealService.findById(mealId));
        cart.addPrice(mealService.findById(mealId).getPrice());
        cartService.save(cart);
        return "redirect:/customer/cart";
    }
    @GetMapping("/removefromcart/{mealId}")
    public String removefromcart(@PathVariable Long mealId,@AuthenticationPrincipal UserDetails userDetails) {
        customer = customerService.findByUsername(userDetails.getUsername());
        Cart cart = cartService.findByCustomerId(customer);
        cart.getMeals().remove(mealService.findById(mealId));
        cart.removePrice(mealService.findById(mealId).getPrice());
        cartService.save(cart);
        return "redirect:/customer/cart";
    }

}
