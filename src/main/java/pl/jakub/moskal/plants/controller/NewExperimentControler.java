package pl.jakub.moskal.plants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jakub.moskal.plants.db.experiment.ExperimentForm;
import pl.jakub.moskal.plants.db.experiment.model.Areas;
import pl.jakub.moskal.plants.db.experiment.model.Experiment;
import pl.jakub.moskal.plants.db.experiment.model.Surface;
import pl.jakub.moskal.plants.db.experiment.repository.ExperimentRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class NewExperimentControler {

    @Autowired
    private ExperimentRepository experimentRepository;

    private Set surfaces = new HashSet<Surface>();
    private Set areas = new HashSet<Areas>();

    @PostMapping("/newexperiment")
    public String newExperiment(@ModelAttribute ExperimentForm experimentForm) {

        Experiment  experiment;


        if(experimentRepository.getByExperimentName(experimentForm.getExperimentName()).isPresent()) {
            experiment = experimentRepository.getByExperimentName(experimentForm.getExperimentName()).get();
            surfaces.addAll(experiment.getSurfaces());

            setSurfacesAndAreas(experimentForm, experiment);

        }
        else {
            experiment = new Experiment();
            experiment.setExperimentName(experimentForm.getExperimentName());
            experiment.setStartDate(experimentForm.getStartDate());
            experiment.setEndDate(experimentForm.getEndDate());

            System.out.println(experimentForm.getFertilizer1());
            System.out.println(experimentForm.getFertilizer2());
            System.out.println(experimentForm.getFertilizer3());

            setSurfacesAndAreas(experimentForm, experiment);

        }

        experimentRepository.save(experiment);

        return "redirect:/";
    }

    private void setSurfacesAndAreas(@ModelAttribute ExperimentForm experimentForm, Experiment experiment) {
        Surface surface;
        surface = new Surface(experimentForm.getFertilizers().get(0), experimentForm.getFertilizers().get(1), experimentForm.getFertilizers().get(2),
                experimentForm.getSeeding(), experimentForm.getSize(), experiment);

        areas.add(new Areas(experimentForm.getPlantNames().get(0), growSim(), surface));
        areas.add(new Areas(experimentForm.getPlantNames().get(1), growSim(), surface));
        areas.add(new Areas(experimentForm.getPlantNames().get(2), growSim(), surface));

        surface.setAreas(areas);

        surfaces.add(surface);

        experiment.setSurfaces(surfaces);
    }

    private int growSim(){
        return ThreadLocalRandom.current().nextInt(0, 1+1);
    }


}
