package ua.curs.work.entities;

public class Route {
    private String id;
    private City fromCity;
    private City toCity;
    private Bus bus;
    private String dateDeparture;
    private String timeDeparture;
    private String dateOfArrival;
    private String timeOfArrival;
    private String price;
    private int seats;
    private String active;

    public Route() {
    }

    public Route(String id, City fromCity, City toCity, Bus bus, String dateDeparture, String timeDeparture, String dateOfArrival, String timeOfArrival, String price, int seats, String active) {
        this.id = id;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.bus = bus;
        this.dateDeparture = dateDeparture;
        this.timeDeparture = timeDeparture;
        this.dateOfArrival = dateOfArrival;
        this.timeOfArrival = timeOfArrival;
        this.price = price;
        this.seats = seats;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public City getFromCity() {
        return fromCity;
    }

    public void setFromCity(City fromCity) {
        this.fromCity = fromCity;
    }

    public City getToCity() {
        return toCity;
    }

    public void setToCity(City toCity) {
        this.toCity = toCity;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public String getDateDeparture() {
        return dateDeparture;
    }

    public void setDateDeparture(String dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    public String getTimeDeparture() {
        return timeDeparture;
    }

    public void setTimeDeparture(String timeDeparture) {
        this.timeDeparture = timeDeparture;
    }

    public String getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(String dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public String getTimeOfArrival() {
        return timeOfArrival;
    }

    public void setTimeOfArrival(String timeOfArrival) {
        this.timeOfArrival = timeOfArrival;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id='" + id + '\'' +
                ", fromCity=" + fromCity +
                ", toCity=" + toCity +
                ", bus=" + bus +
                ", dateDeparture='" + dateDeparture + '\'' +
                ", timeDeparture='" + timeDeparture + '\'' +
                ", dateOfArrival='" + dateOfArrival + '\'' +
                ", timeOfArrival='" + timeOfArrival + '\'' +
                ", price='" + price + '\'' +
                ", seats=" + seats +
                ", active='" + active + '\'' +
                '}';
    }
}
