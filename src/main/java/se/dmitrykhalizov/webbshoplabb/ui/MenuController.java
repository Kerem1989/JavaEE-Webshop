package se.dmitrykhalizov.webbshoplabb.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuController {

    @PostMapping("/menu")
    public String userSelectionMenu( @RequestParam String selection, Model model) {
        model.addAttribute("selection", selection);
        if (selection.equals("1")) {
            return "showproductspage";
        } else {
            return "menupage";
        }

    }

}
