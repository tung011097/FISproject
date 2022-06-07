package core;

import core.AbstractEmtity;

import java.time.LocalDateTime;

public class Person extends AbstractEmtity {
    private  String userName;
    private  String fistName;
    private  String lastName;
    private  String password;
    private LocalDateTime hiringDate;

    public Person(long id, int version, String userName, String fistName, String lastName,
                  String password, LocalDateTime hiringDate, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.userName = userName;
        this.fistName = fistName;
        this.lastName = lastName;
        this.password = password;
        this.hiringDate = hiringDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDateTime hiringDate) {
        this.hiringDate = hiringDate;
    }
}
