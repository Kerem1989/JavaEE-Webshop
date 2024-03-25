package se.dmitrykhalizov.webbshoplabb.ui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.dmitrykhalizov.webbshoplabb.entity.EnumSelection;
import se.dmitrykhalizov.webbshoplabb.entity.User;
import se.dmitrykhalizov.webbshoplabb.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("login")
    public String firstForm(Model model) {
        model.addAttribute("resultlogin", "");
        return "showloginpage";
    }

    @PostMapping("login")
    public String addToLoginForm(@RequestParam String username, @RequestParam String password, Model model) {

        String user = userService.login(username, password);
        model.addAttribute("resultlogin", user);
        if (user.equals("ok") && userService.getUser().getStatus().equals(EnumSelection.admin)) {
            return "menupageadmin";
        } else if (user.equals("ok") && userService.getUser().getStatus().equals(EnumSelection.customer)) {
            return "menupagecustomer";
        }
        return "showloginpage";
    }
}


