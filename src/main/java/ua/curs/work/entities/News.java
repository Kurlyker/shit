package ua.curs.work.entities;

public class News {
    private String id;
    private String photoUrl;
    private String name;
    private String minText;
    private String allText;

    public News() {
    }

    public News(String id, String photoUrl, String name, String minText, String allText) {
        this.id = id;
        this.photoUrl = photoUrl;
        this.name = name;
        this.minText = minText;
        this.allText = allText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMinText() {
        return minText;
    }

    public void setMinText(String minText) {
        this.minText = minText;
    }

    public String getAllText() {
        return allText;
    }

    public void setAllText(String allText) {
        this.allText = allText;
    }

    @Override
    public String toString() {
        return "News{" +
                "id='" + id + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", name='" + name + '\'' +
                ", minText='" + minText + '\'' +
                ", allText='" + allText + '\'' +
                '}';
    }
}
