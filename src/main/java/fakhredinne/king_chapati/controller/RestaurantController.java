package fakhredinne.king_chapati.controller;


import fakhredinne.king_chapati.models.Meal;
import fakhredinne.king_chapati.models.OrderItem;
import fakhredinne.king_chapati.services.MealService;
import fakhredinne.king_chapati.services.OrderItemService;
import fakhredinne.king_chapati.services.RestaurantService;
import fakhredinne.king_chapati.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private SubscriptionService subService;
    @Autowired
    private MealService mealService;

    @PreAuthorize("hasRole('3')")
    @GetMapping("/addmealform/{id_restaurant}")
    public String showAddMealForm( @PathVariable Long id_restaurant, Model model){
        Meal meal = new Meal();
        meal.setRestaurant(restaurantService.findRestaurant(id_restaurant));
        model.addAttribute("meal",meal);
        return ("RestaurantSide/formAddMeal");
    }
    @GetMapping("/{id_restaurant}")
    public String index(Model model , @PathVariable Long id_restaurant){
        model.addAttribute("customer",restaurantService.findRestaurant(id_restaurant));
        return ("RestaurantSide/index");
    }
    @PostMapping("/addMeal/")
    public String addMeal(@ModelAttribute("meal") Meal meal ){

       mealService.save(meal);
        return "redirect:/menu";
    }
    @GetMapping("/showmeals/")
    public String showmeals(Model model ,@AuthenticationPrincipal UserDetails userDetails){

        model.addAttribute("listMeals",restaurantService.getMeal(userDetails.getUsername()));
        return ("menu");
    }
    @GetMapping("/subscriptions")
    public String seeSubs(Model model){
        model.addAttribute("listSub", subService.findAllSubscription() );
        return ("RestaurantSide/plans");
    }
    @GetMapping("/orders/{id_restaurant}")
    public String seeorders(Model model, @PathVariable Long id_restaurant){
        model.addAttribute("customer",restaurantService.findRestaurant(id_restaurant));
        model.addAttribute("orders", restaurantService.findRestaurant(id_restaurant).getOrders()  );
        return ("RestaurantSide/orders");
    }

    }
