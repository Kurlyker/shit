package ua.curs.work.form;

public class CityForm {
    private String id;
    private String name;


    public CityForm() {
    }

    public CityForm(String id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "CityForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
