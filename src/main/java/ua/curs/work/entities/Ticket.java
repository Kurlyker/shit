package ua.curs.work.entities;

public class Ticket {
    private String id;
    private String user;
    private Route route;
    private int number;

    public Ticket() {
    }

    public Ticket(String id, String user, Route route, int number) {
        this.id = id;
        this.user = user;
        this.route = route;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", user='" + user + '\'' +
                ", route=" + route +
                ", number=" + number +
                '}';
    }
}
