package lk.acpt.demofxafsd.tm;

/**
 * Created by IntelliJ IDEA.
 * User: John.Smith
 * Date: 23/12/2023
 * Time: 11:09
 * To change this template use File | Settings | File and Code Templates.
 */
public class PhoneTM {
    private String id;
    private String brand;
    private String model;
    private int ram;
    private double price;

    public PhoneTM(String id, String brand, String model, int ram, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PhoneTM{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                ", price=" + price +
                '}';
    }
}
