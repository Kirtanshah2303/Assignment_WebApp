package in.codersage.securitydemo.Controller;

import in.codersage.securitydemo.Service.SecurityService;
import in.codersage.securitydemo.Entity.User;
import in.codersage.securitydemo.Service.UserService;
import in.codersage.securitydemo.Config.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WelcomeController {
    @Autowired
    UserValidator userValidator;
    @Autowired
    UserService userService;
    @Autowired
    SecurityService securityService;

    // inject via application.properties
    @Value("${welcome.message}")
    private String message;

    @RequestMapping(value ={"/", "/home"})
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "home";
    }

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        return "fancy-login";
    }
    @RequestMapping("/guest")
    public String guest(Map<String, Object> model) {
        return "guest";
    }
    @RequestMapping("/access-denied")
    public String accessdenied(Map<String, Object> model) {
        return "access-denied";
    }
    @RequestMapping("/admin")
    public String admin(Map<String, Object> model) {
        return "admin";
    }

    @GetMapping("/registration")
    public String showRegistration(Model model){
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String doRegistration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult){
        userValidator.validate(userForm, bindingResult);

        if(bindingResult.hasErrors()){
            return "registration";
        }
        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(),userForm.getPassword());
        return "redirect:/registration";
    }


}
