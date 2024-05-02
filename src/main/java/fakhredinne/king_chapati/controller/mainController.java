package fakhredinne.king_chapati.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Controller
@RequestMapping("/")
public class mainController {
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String  index() {
        return "menu2";

    }
}
