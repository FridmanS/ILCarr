package models;

public class User {
    String email;
    String password;
    String fName;
    String sName;
    String phone;

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    public User withFName(String fName) {
        this.fName = fName;
        return this;
    }

    public User withLName(String sName) {
        this.sName = sName;
        return this;
    }

    public User withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFName() {
        return fName;
    }

    public String getLName() {
        return sName;
    }

    public String getPhone() {
        return phone;
    }
}
