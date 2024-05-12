package fakhredinne.king_chapati.controller;

import fakhredinne.king_chapati.models.Meal;
import fakhredinne.king_chapati.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/")
public class mainController {
    @Autowired
    MealService mealService;
    @RequestMapping(value = "/", method = RequestMethod.GET)

    public String main(Model model)
    {
        List<Meal> listMeals = mealService.findAll();
        model.addAttribute("listMeals",listMeals);
        return "index";
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
