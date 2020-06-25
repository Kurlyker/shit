package ua.curs.work.entities;

public class Bus{
    private String id;
    private String number;
    private String model;
    private String color;
    private Driver driver;
    private PassangerClass passangerClass;
    private ComfortClass comfortClass;
    private OverallLength overallLength;
    private int numberOfSeat;

    public Bus() {
    }

    public Bus(String id, String number, String model, String color, Driver driver, PassangerClass passangerClass, ComfortClass comfortClass, OverallLength overallLength, int numberOfSeat) {
        this.id = id;
        this.number = number;
        this.model = model;
        this.color = color;
        this.driver = driver;
        this.passangerClass = passangerClass;
        this.comfortClass = comfortClass;
        this.overallLength = overallLength;
        this.numberOfSeat = numberOfSeat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public PassangerClass getPassangerClass() {
        return passangerClass;
    }

    public void setPassangerClass(PassangerClass passangerClass) {
        this.passangerClass = passangerClass;
    }

    public ComfortClass getComfortClass() {
        return comfortClass;
    }

    public void setComfortClass(ComfortClass comfortClass) {
        this.comfortClass = comfortClass;
    }

    public OverallLength getOverallLength() {
        return overallLength;
    }

    public void setOverallLength(OverallLength overallLength) {
        this.overallLength = overallLength;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id='" + id + '\'' +
                ", number='" + number + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", driver=" + driver +
                ", passangerClass=" + passangerClass +
                ", comfortClass=" + comfortClass +
                ", overallLength=" + overallLength +
                ", numberOfSeat=" + numberOfSeat +
                '}';
    }
}
