package ua.curs.work.entities;

import java.time.LocalDateTime;

public class Support {
    private String id;
    private String email;
    private LocalDateTime dateSend;
    private String text;
    private String answer;
    private boolean active;

    public Support() {
    }

    public Support(String id, String email, LocalDateTime dateSend, String text, String answer, boolean active) {
        this.id = id;
        this.email = email;
        this.dateSend = dateSend;
        this.text = text;
        this.answer = answer;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDateSend() {
        return dateSend;
    }

    public void setDateSend(LocalDateTime dateSend) {
        this.dateSend = dateSend;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Support{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", dateSend=" + dateSend +
                ", text='" + text + '\'' +
                ", answer='" + answer + '\'' +
                ", active=" + active +
                '}';
    }
}
