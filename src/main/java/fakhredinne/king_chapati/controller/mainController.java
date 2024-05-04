package fakhredinne.king_chapati.controller;

import fakhredinne.king_chapati.models.Meal;
import fakhredinne.king_chapati.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Controller
@RequestMapping("/")
public class mainController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "ClientSide/index";
    }
    /*
   form -> demandTo_add_meal

               ___   ___
              ||-^-|-^-||
               || -&- ||
             \\___---___//

   table_admin -> approv lel demand
   */

    @RequestMapping(value = "/meals", method = RequestMethod.GET)
    public String viewMealPage(Model model)
    {
        return "redirect:/meal/menu";

    }

    @RequestMapping(value = "/convers", method = RequestMethod.GET)
    public String viewConvers(Model model)
    {
        return "redirect:/convers/conver";

    }


}
