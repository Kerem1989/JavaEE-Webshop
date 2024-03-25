package se.dmitrykhalizov.webbshoplabb.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import se.dmitrykhalizov.webbshoplabb.entity.User;
import se.dmitrykhalizov.webbshoplabb.service.UserService;

@Controller
public class MenuController {

    @Autowired
    UserService userService;

    @PostMapping("/menu")
    public String userSelectionMenu(Model model) {
        User user = userService.getUser();
        model.addAttribute("user", user);
        if (user.getStatus().equals("admin")) {
            return "showproductspage";
        } else {
            return "menupagecustomer";
        }

    }

}
