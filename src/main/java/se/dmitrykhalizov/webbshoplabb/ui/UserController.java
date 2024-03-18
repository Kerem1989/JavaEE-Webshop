package se.dmitrykhalizov.webbshoplabb.ui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.dmitrykhalizov.webbshoplabb.database.EnumSelection;
import se.dmitrykhalizov.webbshoplabb.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("login")
    public String firstForm(){
        return "showloginpage";
    }
    @PostMapping("login")
    public String addertoForm(@RequestParam String username, @RequestParam String password, Model model){

        EnumSelection user = userService.login(username, password);
        if (user == EnumSelection.ok) {
            return "menupage";
        } else {
            return "showloginpage";
        }
    }
}

