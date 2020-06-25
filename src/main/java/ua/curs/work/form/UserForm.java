package ua.curs.work.form;

import ua.curs.work.entities.Role;

public class UserForm {
    private String id;
    private String email;
    private String password;
    private String surname;
    private String name;
    private String byFather;
    private boolean enabled;
    private Role roles;


    public UserForm() {
    }

    public UserForm(String id, String email, String password, String surname, String name, String byFather, boolean enabled, Role roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.surname = surname;
        this.name = name;
        this.byFather = byFather;
        this.enabled = enabled;
        this.roles = roles;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getByFather() {
        return byFather;
    }

    public void setByFather(String byFather) {
        this.byFather = byFather;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", byFather='" + byFather + '\'' +
                ", enabled=" + enabled +
                ", roles=" + roles +
                '}';
    }
}
