package pl.jakub.moskal.plants.db.Results.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "results")
public class Results {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private long id;

    @NotBlank(message = "The experiment date must be not empty")
    private String expName;
    @NotBlank(message = "The user name must be not empty")
    private String userName;

    private int result;
    @NotBlank(message = "The date must be not empty")
    private String date;
    @NotBlank(message = "The plant name must be not empty")
    private String plantName;

    private String fertilizer1 = "Brak";
    private String fertilizer2 = "Brak";
    private String fertilizer3 = "Brak";

    public Results(){
    }

    public Results(@NotBlank(message = "The experiment date must be not empty") String expName,
                   @NotBlank(message = "The user name must be not empty") String userName, int result,
                   @NotBlank(message = "The date must be not empty") String date,
                   @NotBlank(message = "The plant name must be not empty") String plantName, String fertilizer1, String fertilizer2, String fertilizer3) {
        this.expName = expName;
        this.userName = userName;
        this.result = result;
        this.date = date;
        this.plantName = plantName;
        this.fertilizer1 = fertilizer1;
        this.fertilizer2 = fertilizer2;
        this.fertilizer3 = fertilizer3;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
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

    @Override
    public String toString() {
        return "Results{" +
                "id=" + id +
                ", expName='" + expName + '\'' +
                ", userName='" + userName + '\'' +
                ", result=" + result +
                ", date='" + date + '\'' +
                ", plantName='" + plantName + '\'' +
                ", fertilizer1=" + fertilizer1 +
                ", fertilizer2=" + fertilizer2 +
                ", fertilizer3=" + fertilizer3 +
                '}';
    }
}
