package pl.jakub.moskal.plants.db.experiment.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "areas")
public class Areas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private long id;

    @NotBlank(message = "The plant name must be not empty")
    private String plantName;

    private int isGrow;

    @ManyToOne
    @JoinColumn(name = "Surface_id")
    private Surface surface;

    public Areas() {

    }

    public Areas(String plantName, int isGrow, Surface surface) {
        this.plantName = plantName;
        this.isGrow = isGrow;
        this.surface = surface;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public int isGrow() {
        return isGrow;
    }

    public void setGrow(int grow) {
        isGrow = grow;
    }

    @Override
    public String toString() {
        return "Areas{" +
                "id=" + id +
                ", plantName='" + plantName + '\'' +
                ", isGrow=" + isGrow +
                '}';
    }
}
