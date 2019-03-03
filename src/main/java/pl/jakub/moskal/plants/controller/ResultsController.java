package pl.jakub.moskal.plants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jakub.moskal.plants.db.Results.model.Results;
import pl.jakub.moskal.plants.db.Results.repository.ResultsRepository;

import java.security.Principal;

@Controller
public class ResultsController {

    @Autowired
    private ResultsRepository resultsRepository;

    @PostMapping("/saveresults")
    public String saveRes(@ModelAttribute Results results, Principal principal) {

        results.setUserName(principal.getName());

        resultsRepository.save(results);

        return "redirect:/resultsSaved";

    }

    @GetMapping("/results")
    public String getResults(Model model){

        model.addAttribute("results", resultsRepository.findAll());

        return "results";
    }


}
