package fakhredinne.king_chapati.controller;

import fakhredinne.king_chapati.models.Conversation;
import fakhredinne.king_chapati.models.Meal;
import fakhredinne.king_chapati.models.Message;
import fakhredinne.king_chapati.services.ConversationService;
import fakhredinne.king_chapati.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequestMapping("/convers")
public class conversationController {
    @Autowired
    ConversationService conversationService;
    @GetMapping("/conver")
    public String getConvers(Model model) {
        List<Conversation> conversations = conversationService.findAll();
        model.addAttribute("msg", new Message()); //
        model.addAttribute("conversations", conversations);
        return "chat";
    }
    @PostMapping("/sendMessage")
    public String sendMessage(@ModelAttribute Message message, RedirectAttributes redirectAttributesd) {
        conversationService.sendMessage(message);
        return "redirect:/convers/conver";
    }

}

