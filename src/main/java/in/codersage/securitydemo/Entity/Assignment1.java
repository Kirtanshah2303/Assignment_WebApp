package in.codersage.securitydemo.Entity;

import javax.persistence.*;

@Entity
public class Assignment1 {

    @Id
    String studentID;

    String randomString;

    public Assignment1() {
    }

    public Assignment1(String studentID, String randomString) {
        this.studentID = studentID;
        this.randomString = randomString;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getRandomString() {
        return randomString;
    }

    public void setRandomString(String randomString) {
        this.randomString = randomString;
    }
}
