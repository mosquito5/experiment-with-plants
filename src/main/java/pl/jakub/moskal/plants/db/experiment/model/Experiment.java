package pl.jakub.moskal.plants.db.experiment.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "experiment")
public class Experiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private long id;
    @Column(nullable = false)
    @NotBlank(message = "The start date must not be empty")
    private String startDate;
    @Column(nullable = false)
    @NotBlank(message = "The end date must not be empty")
    private String endDate;
    @Column(nullable = false)
    @NotBlank(message = "The expeeriment name must not be empty")
    private String experimentName;
    @OneToMany(mappedBy = "experiment", cascade = CascadeType.ALL)
    private Set<Surface> surfaces;

    public Experiment(){

    }

    public Experiment(@NotBlank(message = "The start date must not be empty") String startDate,
                      @NotBlank(message = "The start date must not be empty") String endDate,
                      @NotBlank(message = "The expeeriment name must not be empty") String experimentName) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.experimentName = experimentName;

    }

    public String getExperimentName() {
        return experimentName;
    }

    public void setExperimentName(String experimentName) {
        this.experimentName = experimentName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Set<Surface> getSurfaces() {
        return surfaces;
    }

    public void setSurfaces(Set<Surface> surfaces) {
        this.surfaces = surfaces;
    }

}


