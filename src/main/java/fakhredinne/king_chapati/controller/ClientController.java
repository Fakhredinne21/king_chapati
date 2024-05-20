package fakhredinne.king_chapati.controller;

import fakhredinne.king_chapati.models.Cart;
import fakhredinne.king_chapati.models.Customer;
import fakhredinne.king_chapati.models.Meal;
import fakhredinne.king_chapati.services.CartService;
import fakhredinne.king_chapati.services.CustomerService;
import fakhredinne.king_chapati.services.MealService;
import fakhredinne.king_chapati.services.OrderService;
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
    @Autowired
    OrderService orderService;
    Customer customer;

    @GetMapping("" )
    public String main(Model model,@AuthenticationPrincipal UserDetails userDetails) {
        List<Meal> listMeals = mealService.findAll();
        model.addAttribute("listMeals",listMeals);
        model.addAttribute("customer",customerService.findByUsername(userDetails.getUsername()));
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
    @PostMapping("/checkout")
    public String checkout(@AuthenticationPrincipal UserDetails userDetails)
    {
        customer = customerService.findByUsername(userDetails.getUsername());
        Cart cart = cartService.findByCustomerId(customer);
        orderService.checkout(cart);
        cart.getMeals().clear();
        cart.setTotal_price(0);
        cartService.save(cart);
        return "redirect:/customer/cart";
    }
    @GetMapping("/orders")
    public String showOrders(Model model,@AuthenticationPrincipal UserDetails userDetails)
    {
        customer = customerService.findByUsername(userDetails.getUsername());
        model.addAttribute("orders",customer.getOrders());
        return "ClientSide/orders";
    }





}
