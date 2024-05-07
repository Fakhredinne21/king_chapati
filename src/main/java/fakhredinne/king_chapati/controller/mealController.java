package fakhredinne.king_chapati.controller;
import fakhredinne.king_chapati.models.Meal;
import fakhredinne.king_chapati.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/meal")
public class mealController {
    @Autowired
    MealService mealService;
    @GetMapping("/menu")
    public String getMeal(Model model) {
        List<Meal> listMeals = mealService.findAll();
        model.addAttribute("listMeals",listMeals);
        return "menu2";
    }

}
