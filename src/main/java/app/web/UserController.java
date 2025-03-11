package app.web;

import app.User.model.User;
import app.User.service.UserService;
import app.web.dto.UserEditRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}/profile")
    public ModelAndView getProfileMenu(@PathVariable UUID id) {
        //@PathVariable указва, че променливата идва от /{id}/profile - {id}
        User user = userService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit-profile");
        modelAndView.addObject("user", user);
        modelAndView.addObject("userEditRequest", userService.mapUserToUserEditRequest(user));

        return modelAndView;

    }

    @PutMapping("/{id}/profile")
    public ModelAndView updateUserProfile(@PathVariable UUID id, @Valid UserEditRequest userEditRequest, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            User user = userService.getById(id);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("edit-profile");
            modelAndView.addObject("user", user);
            modelAndView.addObject("userEditRequest", userEditRequest);
            return modelAndView;
        }

        userService.editUserDetails(id, userEditRequest);

        return new ModelAndView("redirect:/home");
    }
}
