package in.codersage.securitydemo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class assignment1 {
    @Id
    String id;

    String randomString;

    public assignment1() {
    }

    public assignment1(String ID, String randomString) {
        this.id = ID;
        this.randomString = randomString;
    }

    public String getID() {
        return id;
    }

    public void setID(String ID) {
        this.id = ID;
    }

    public String getRandomString() {
        return randomString;
    }

    public void setRandomString(String randomString) {
        this.randomString = randomString;
    }
}
