package fakhredinne.king_chapati.controller;


import fakhredinne.king_chapati.models.Meal;
import fakhredinne.king_chapati.models.Restaurant;
import fakhredinne.king_chapati.services.RestaurantService;
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
        model.addAttribute("meal",new Meal());
        model.addAttribute("restaurant",restaurantId);
        model.addAttribute("restaurant",restaurantService.findRestaurant(restaurantId));
        return ("formAddMeal");
    }
    @PostMapping("/addMeal")
    public String addMeal(@ModelAttribute("restaurant")Restaurant restaurant, @ModelAttribute("meal") Meal meal){
        restaurantService.addMeal(restaurant.getIdresturant(),meal);
        return "redirect:/meal/menu";
    }
    }
