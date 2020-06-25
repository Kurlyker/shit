package ua.curs.work.form;

public class BusClassForm {
    private String id;
    private String weightClass;
    private String passangerClass;
    private String comfortClass;
    private String description;

    public BusClassForm() {
    }

    public BusClassForm(String id, String weightClass, String passangerClass, String comfortClass, String description) {
        this.id = id;
        this.weightClass = weightClass;
        this.passangerClass = passangerClass;
        this.comfortClass = comfortClass;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWeightClass() {
        return weightClass;
    }

    public void setWeightClass(String weightClass) {
        this.weightClass = weightClass;
    }

    public String getPassangerClass() {
        return passangerClass;
    }

    public void setPassangerClass(String passangerClass) {
        this.passangerClass = passangerClass;
    }

    public String getComfortClass() {
        return comfortClass;
    }

    public void setComfortClass(String comfortClass) {
        this.comfortClass = comfortClass;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BusClassForm{" +
                "id='" + id + '\'' +
                ", weightClass='" + weightClass + '\'' +
                ", passangerClass='" + passangerClass + '\'' +
                ", comfortClass='" + comfortClass + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
