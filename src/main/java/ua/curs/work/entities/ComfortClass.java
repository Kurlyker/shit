package ua.curs.work.entities;

public class ComfortClass {
    private String id;
    private String comfortClass;
    private String description;

    public ComfortClass() {
    }

    public ComfortClass(String id, String comfortClass, String description) {
        this.id = id;
        this.comfortClass = comfortClass;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "BusClass{" +
                "id='" + id + '\'' +
                ", passangerClass='" + comfortClass + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
