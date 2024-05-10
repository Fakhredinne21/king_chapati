package fakhredinne.king_chapati.controller;

import fakhredinne.king_chapati.config.AuthenticationRequest;
import fakhredinne.king_chapati.config.AuthenticationResponse;
import fakhredinne.king_chapati.config.AuthenticationService;
import fakhredinne.king_chapati.config.RegisterRequest;
import fakhredinne.king_chapati.models.Meal;
import fakhredinne.king_chapati.services.MealService;
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
    private final AuthenticationService authenticationService=null;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){

        return ResponseEntity.ok(authenticationService.register(request));
    }
    @PostMapping("/Login")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request){
        //
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }





}
