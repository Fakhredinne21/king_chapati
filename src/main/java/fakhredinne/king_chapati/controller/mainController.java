package fakhredinne.king_chapati.controller;

import fakhredinne.king_chapati.models.Cart;
import fakhredinne.king_chapati.models.Customer;
import fakhredinne.king_chapati.models.Meal;
import fakhredinne.king_chapati.models.Role;
import fakhredinne.king_chapati.services.CartService;
import fakhredinne.king_chapati.services.CustomerService;
import fakhredinne.king_chapati.services.MealService;
import jdk.swing.interop.SwingInterOpUtils;
import org.apache.coyote.Response;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/")
public class mainController {

    @Autowired
    MealService mealService;
    @Autowired
    CustomerService customerService;
    @Autowired
    CartService cartService;
    @GetMapping("/mealdetail/{mealId}")
    public String showmeal(@PathVariable Long mealId,Model model)
    {
        Meal meal = mealService.findById(mealId);
        model.addAttribute("meal",meal);
        return "ClientSide/mealdetails";
    }
    @GetMapping("/login" )
    public String login(Model model) {
        return "login";
    }
    @GetMapping("/register_customer")
    public String register(Model model) {
        model.addAttribute("customer",new Customer());
        return "registration";
    }
    @PostMapping("/register_customer")
    public String registerUser(@ModelAttribute("customer") Customer customer) {
        customer.setCreatedAt(java.time.LocalDateTime.now());
        customer.setRole(Role.Customer);
        customerService.save(customer);
        Cart cart =new Cart();
        cart.setCustomer(customer);
        cartService.save(cart);
        customer.setCart(cart);

        return "redirect:/login";
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)

    public String main(Model model)
    {
        List<Meal> listMeals = mealService.findAll();
        model.addAttribute("listMeals",listMeals);
        return "menu";
    }

    /*
   form -> demandTo_add_meal

               ___   ___
              ||-^-|-^-||
               || -&- ||
             \\___---___//

   table_admin -> approv lel demand
   */

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String menu(Model model)
    {
        List<Meal> listMeals = mealService.findAll();
        model.addAttribute("listMeals",listMeals);
        return "menu";
    }






}
