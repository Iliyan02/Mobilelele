package softuni.lection2.lection2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import softuni.lection2.lection2.models.service.UserLoginServiceModel;
import softuni.lection2.lection2.security.CurrentUser;
import softuni.lection2.lection2.service.UserService;

@Controller
public class LoginController {
    private final CurrentUser currentUser;
    private final UserService userService;

    public LoginController(CurrentUser currentUser, UserService userService) {
        this.currentUser = currentUser;
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String showLogin(){

        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(UserLoginServiceModel model){
        if (userService.authenticate(model.getUsername(), model.getPassword())){

            userService.loginUser(model.getUsername());
            return "redirect:/";
        }
        return "redirect:/users/login";
    }

    @PostMapping("/users/logout")
    public String logout(){
        userService.logoutCurrentUser();
        return "redirect:/";
    }
}
