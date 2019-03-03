package pl.jakub.moskal.plants.db.experiment.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "surface")
public class Surface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private long id;

    private String fertilizer1;
    private String fertilizer2;
    private String fertilizer3;

    @NotNull(message = "The seeding cannot be null")
    private int seeding;

    @NotNull(message = "The size cannot be null")
    private int size;

    @OneToMany(mappedBy = "surface", cascade = CascadeType.PERSIST)
    private Set<Areas> areas;

    @ManyToOne
    @JoinColumn(name = "Experiment_id")
    private Experiment experiment;

    public Surface() {

    }

    public Surface(String fertilizer1, String fertilizer2, String fertilizer3, @NotNull(message = "The seeding cannot be null") int seeding, @NotNull(message = "The size cannot be null") int size, Set<Areas> areas, Experiment experiment) {
        this.fertilizer1 = fertilizer1;
        this.fertilizer2 = fertilizer2;
        this.fertilizer3 = fertilizer3;
        this.seeding = seeding;
        this.size = size;
        this.areas = areas;
        this.experiment = experiment;
    }

    public Surface(String fertilizer1, String fertilizer2, String fertilizer3, @NotNull(message = "The seeding cannot be null") int seeding, @NotNull(message = "The size cannot be null") int size, Experiment experiment) {
        this.fertilizer1 = fertilizer1;
        this.fertilizer2 = fertilizer2;
        this.fertilizer3 = fertilizer3;
        this.seeding = seeding;
        this.size = size;
        this.experiment = experiment;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFertilizer1() {
        return fertilizer1;
    }

    public void setFertilizer1(String fertilizer1) {
        this.fertilizer1 = fertilizer1;
    }

    public String getFertilizer2() {
        return fertilizer2;
    }

    public void setFertilizer2(String fertilizer2) {
        this.fertilizer2 = fertilizer2;
    }

    public String getFertilizer3() {
        return fertilizer3;
    }

    public void setFertilizer3(String fertilizer3) {
        this.fertilizer3 = fertilizer3;
    }

    public int getSeeding() {
        return seeding;
    }

    public void setSeeding(int seeding) {
        this.seeding = seeding;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Experiment getExperiment() {
        return experiment;
    }

    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    public Set<Areas> getAreas() {
        return areas;
    }

    public void setAreas(Set<Areas> areas) {
        this.areas = areas;
    }
}
