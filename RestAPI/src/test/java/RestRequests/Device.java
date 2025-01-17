package RestRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    private String color;
    private String capacity;
    private Double price;
    private String generation;
    private int year;
    private String cpuModel;
    private String hardDiskSize;
    private String strapColour;
    private String caseSize;
    private String description;
    private String screenSize;

    // Custom constructors for different combinations of fields
    public Device(String color, String capacity) {
        this.color = color;
        this.capacity = capacity;
    }

    public Device(Double price, String color) {
        this.price = price;
        this.color = color;
    }

    public Device(Integer year, Double price, String cpuModel, String hardDiskSize) {
        this.year = year;
        this.price = price;
        this.cpuModel = cpuModel;
        this.hardDiskSize = hardDiskSize;
    }

    public Device(String generation, Double price) {
        this.generation = generation;
        this.price = price;
    }

}
