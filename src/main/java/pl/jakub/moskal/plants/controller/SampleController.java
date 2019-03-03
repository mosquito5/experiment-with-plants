package pl.jakub.moskal.plants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.jakub.moskal.plants.db.experiment.model.Experiment;
import pl.jakub.moskal.plants.db.experiment.repository.ExperimentRepository;

import java.util.List;

@Controller
public class SampleController {
    @Autowired
    private ExperimentRepository experimentRepository;

    @GetMapping("/sample")
    public String Sample(Model model) {

        List<Experiment> allExperiments = experimentRepository.findAll();

        model.addAttribute("allExperiments", allExperiments);
        return "sample";
    }
}
