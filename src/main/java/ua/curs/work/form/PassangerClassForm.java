package ua.curs.work.form;

public class PassangerClassForm {
    private String id;
    private String passangerClass;
    private String description;

    public PassangerClassForm() {
    }

    public PassangerClassForm(String id, String passangerClass, String description) {
        this.id = id;
        this.passangerClass = passangerClass;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassangerClass() {
        return passangerClass;
    }

    public void setPassangerClass(String passangerClass) {
        this.passangerClass = passangerClass;
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
                ", passangerClass='" + passangerClass + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
