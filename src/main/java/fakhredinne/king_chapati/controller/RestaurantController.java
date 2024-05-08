package fakhredinne.king_chapati.controller;
import fakhredinne.king_chapati.models.Meal;
import fakhredinne.king_chapati.services.RestaurantService;
import fakhredinne.king_chapati.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/addmealform/{restaurantId}")
    public String showAddMealForm(@PathVariable Long restaurantId, Model model){
        System.out.println(restaurantId);
        model.addAttribute("meal",new Meal());
        return ("formAddMeal");
    }
    @PostMapping("/addMeal")
    public String addMeal( @ModelAttribute("meal") Meal meal){
        System.out.println(meal);
        restaurantService.addMeal(meal);
        return "redirect:/meal/menu";
    }
    @GetMapping("/showmeals/{restaurantId}")
    public String showmeals(@PathVariable Long restaurantId, Model model){
        model.addAttribute("listMeals",restaurantService.getMeal(restaurantId));
        return ("menu");
    }
    @GetMapping("/subscriptions")
    public String seeSubs(){

        return ("DashboardCA/plans");
    }
    }
