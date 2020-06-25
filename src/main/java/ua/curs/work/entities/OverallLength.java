package ua.curs.work.entities;

public class OverallLength {
    private String id;
    private String name;
    private String description;

    public OverallLength() {
    }

    public OverallLength(String id, String comfortClass, String description) {
        this.id = id;
        this.name = comfortClass;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", passangerClass='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
