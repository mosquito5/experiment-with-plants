package pl.jakub.moskal.plants.db.experiment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;


public class ExperimentForm {
    @NotBlank(message = "The start date must not be empty")
    private String startDate;
    @NotBlank(message = "The end date must not be empty")
    private String endDate;

    @NotBlank(message = "The fertilizer must not be empty")
    private String fertilizer1 = "Brak";
    @NotBlank(message = "The fertilizer must not be empty")
    private String fertilizer2 = "Brak";
    @NotBlank(message = "The fertilizer must not be empty")
    private String fertilizer3 = "Brak";

    @NotNull(message = "The seeding cannot be null")
    private int seeding;

    @NotNull(message = "The size cannot be null")
    private int size;

    @NotBlank(message = "The plant name must be not empty")
    private String plantName1;
    @NotBlank(message = "The plant name must be not empty")
    private String plantName2;
    @NotBlank(message = "The plant name must be not empty")
    private String plantName3;

    @NotBlank(message = "The fertilizer must not be empty")
    private ArrayList<String> fertilizers;

    @NotBlank(message = "The plant name must be not empty")
    private ArrayList<String> plantNames;

    @NotBlank(message = "The expeeriment name must not be empty")
    private String experimentName;

    public ExperimentForm(){}

    public ExperimentForm(@NotBlank(message = "The start date must not be empty") String startDate, @NotBlank(message = "The end date must not be empty") String endDate, @NotBlank(message = "The fertilizer must not be empty") String fertilizer1, @NotBlank(message = "The fertilizer must not be empty") String fertilizer2, @NotBlank(message = "The fertilizer must not be empty") String fertilizer3, @NotNull(message = "The seeding cannot be null") int seeding, @NotNull(message = "The size cannot be null") int size, @NotBlank(message = "The plant name must be not empty") String plantName1, @NotBlank(message = "The plant name must be not empty") String plantName2, @NotBlank(message = "The plant name must be not empty") String plantName3, @NotBlank(message = "The expeeriment name must not be empty") String experimentName) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.fertilizer1 = fertilizer1;
        this.fertilizer2 = fertilizer2;
        this.fertilizer3 = fertilizer3;
        this.seeding = seeding;
        this.size = size;
        this.plantName1 = plantName1;
        this.plantName2 = plantName2;
        this.plantName3 = plantName3;
        this.experimentName = experimentName;
    }

    public ArrayList<String> getPlantNames() {
        return plantNames;
    }

    public void setPlantNames(ArrayList<String> plantNames) {
        this.plantNames = plantNames;
    }

    public ArrayList<String> getFertilizers() {
        return fertilizers;
    }

    public void setFertilizers(ArrayList<String> fertilizers) {
        this.fertilizers = fertilizers;
    }

    public String getPlantName1() {
        return plantName1;
    }

    public void setPlantName1(String plantName1) {
        this.plantName1 = plantName1;
    }

    public String getPlantName2() {
        return plantName2;
    }

    public void setPlantName2(String plantName2) {
        this.plantName2 = plantName2;
    }

    public String getPlantName3() {
        return plantName3;
    }

    public void setPlantName3(String plantName3) {
        this.plantName3 = plantName3;
    }

    public String getExperimentName() {
        return experimentName;
    }

    public void setExperimentName(String experimentName) {
        this.experimentName = experimentName;
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
}
