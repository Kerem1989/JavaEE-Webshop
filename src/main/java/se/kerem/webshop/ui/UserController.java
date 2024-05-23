package se.kerem.webshop.ui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.kerem.webshop.entity.Category;
import se.kerem.webshop.entity.EnumSelection;
import se.kerem.webshop.entity.Order;
import se.kerem.webshop.entity.Orderline;
import se.kerem.webshop.repository.OrderRepo;
import se.kerem.webshop.service.CategoryService;
import se.kerem.webshop.service.OrderLineService;
import se.kerem.webshop.service.OrderService;
import se.kerem.webshop.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderLineService orderLineService;

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
            List<Category> listCategories = categoryService.listEnabled();
            model.addAttribute("listCategories", listCategories);
            return "menupagecustomer";
        } else if (user.equals("ok") && userService.getUser().getStatus().equals(EnumSelection.formercustomer)) {
            List<Order> orderList = orderRepo.findOrderByUserid(userService.getUser().getUserid());
            List<Orderline> orderlineList = orderLineService.listOrderline(orderList.get(0));
            model.addAttribute("orderList", orderList);
            model.addAttribute("orderlineList", orderlineList);
            return "menupageformercustomer";
        }
        return "showloginpage";
    }

    @GetMapping("register")
    public String registerForm(Model model) {
        model.addAttribute("resultregister", "");
        return "registeruser";
    }

    @PostMapping("register")
    public String addToRegisterForm(@RequestParam String firstname, @RequestParam String surname,
                                    @RequestParam String email, @RequestParam String address, @RequestParam String telephone,
                                    @RequestParam String username, @RequestParam String password, EnumSelection status, Model model) {
        String resultRegister = userService.register(firstname, surname, email, address, telephone, username, password, status);
        model.addAttribute("resultregister", resultRegister);
        return "registeruser";
    }

    @GetMapping("logout")
    public String logout() {
        userService.logout();
        return "showloginpage";
    }
}


