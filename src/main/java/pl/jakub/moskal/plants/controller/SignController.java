package pl.jakub.moskal.plants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import pl.jakub.moskal.plants.email.Email;
import pl.jakub.moskal.plants.service.UserService;
import pl.jakub.moskal.plants.db.users.model.User;
import pl.jakub.moskal.plants.db.users.repository.UserRepository;

@Controller
public class SignController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private Email sendEmail;

    @PostMapping("/signup")
    public String signUp(@ModelAttribute User user) {

        Context emailContext = new Context();
        emailContext.setVariable("header","Twoje konto zostało zarejestrowane");
        emailContext.setVariable("title","Drogi/Droga " + user.getUsername() +
                " twoje konto zostało zarejestrowane");

        try{
            userService.addWithDefaultRole(user);

        } catch (org.springframework.dao.DataIntegrityViolationException none) {

            return "redirect:/signup";
        }

        String body = templateEngine.process("email/EmailTemplate", emailContext);
        sendEmail.email(user.getEmail(), body, "Twoje konto zostało zarejestrowane");

        return "redirect:/";
    }
}
