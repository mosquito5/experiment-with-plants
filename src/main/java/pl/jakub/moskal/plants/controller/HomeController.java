package pl.jakub.moskal.plants.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jakub.moskal.plants.db.Results.model.Results;
import pl.jakub.moskal.plants.db.experiment.ExperimentForm;
import pl.jakub.moskal.plants.db.users.model.User;



@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/signup")
    public String SignUp(Model model) {
        model.addAttribute("NewUserForm", new User());

        return "signup";
    }

    @GetMapping("/newexperiment")
    public String Experiment(Model model) {
        model.addAttribute("NewExperimentForm", new ExperimentForm());

        return "newexperiment";
    }


    @GetMapping("/signin")
    public String SignIn(Model model) {
        model.addAttribute("SignInForm", new User());

        return "signin";
    }

    @GetMapping("/saveresults")
    public String SaveResults(Model model) {
        model.addAttribute("SaveForm", new Results());

        return "saveresults";
    }

    @GetMapping("/resultsSaved")
    public String SaveResults()  {

        return "resultsSaved";
    }
}
