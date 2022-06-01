package Topic1.core;

import java.util.Date;

public class Student {
    private int code;
    private String name;
    private Date birthDate;

    public Student(int code, String name, Date birthDate) {
        this.code = code;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public  int comperTo(Student student){

        return 0;
    }
    @Override
    public String toString() {
        return "Student{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}

