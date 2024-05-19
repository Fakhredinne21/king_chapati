package fakhredinne.king_chapati.controller;


import fakhredinne.king_chapati.models.Meal;
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

    @PreAuthorize("hasRole('3')")
    @GetMapping("/addmealform/")
    public String showAddMealForm( Model model){
        model.addAttribute("meal",new Meal());
        return ("DashboardCA/formAddMeal");
    }
    @PostMapping("/addMeal")
    public String addMeal(@ModelAttribute("meal") Meal meal, @AuthenticationPrincipal String username){
        meal.setRestaurant(restaurantService.findByUsername(username));
        restaurantService.addMeal(meal);
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
        return ("DashboardCA/plans");
    }
    }
