package ua.curs.work.entities;

public class Driver {
    private String id;
    private String name;
    private String surname;
    private String byFather;
    private String experience;

    public Driver() {
    }

    public Driver(String id, String name, String surname, String byFather, String experience) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.byFather = byFather;
        this.experience = experience;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getByFather() {
        return byFather;
    }

    public void setByFather(String byFather) {
        this.byFather = byFather;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }


    @Override
    public String toString() {
        return "Driver{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", byFather='" + byFather + '\'' +
                ", experience='" + experience + '\'' +
                '}';
    }
}
