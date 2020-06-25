package ua.curs.work.controllers.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.curs.work.entities.User;
import ua.curs.work.services.user.CustomUserDetailsService;
import ua.curs.work.services.user.impls.UserServiceImpl;

import javax.validation.Valid;


@Controller
@RequestMapping("/web/user/")
public class UserWebController {

    @Autowired
    private CustomUserDetailsService userService;

    private final UserServiceImpl service;
    public UserWebController(UserServiceImpl service) {
        this.service = service;
    }

    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("users", service.getAll());
        return "userList"; }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("users", service.getAll());
        return "redirect:/web/user/list";
    }


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("userAdd.html");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the username provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("signup");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("redirect:/web/user/list");
        }
        return modelAndView;
    }

}
