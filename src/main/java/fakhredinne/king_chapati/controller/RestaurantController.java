package fakhredinne.king_chapati.controller;


import fakhredinne.king_chapati.models.Meal;
import fakhredinne.king_chapati.models.Restaurant;
import fakhredinne.king_chapati.services.RestaurantService;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    @GetMapping("/showAddMealForm/{restaurantId}")
    public String showAddMealForm(@PathVariable Long restaurantId, Model model){
        Restaurant resto=restaurantService.findRestaurant(restaurantId);
        Meal meal=new Meal();
        meal.setRestaurant(resto);
        model.addAttribute("meal",meal);
        return ("formAddMeal");
    }
    @PostMapping("/addMeal")
    public String addMeal( @ModelAttribute("meal") Meal meal){
        restaurantService.addMeal(meal);
        return "redirect:/meal/menu";
    }
    @GetMapping("/showMeals/{restaurantId}")
    public String showmeals(@PathVariable Long restaurantId, Model model){
        model.addAttribute("listMeals",restaurantService.getMeal(restaurantId));
        return ("menu2");
    }
    }
