package in.codersage.securitydemo.Entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Course {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String courseTitle;
    String courseDescription;
    String courseObjectives;
    String courseSubTitle;
    @CreatedDate
    Date courseCreatedOn;
    Date courseUpdatedOn;
    boolean isApproved;
    boolean isPublished;
    int semester;

    public Course() {
    }

    public Course(String courseTitle, String courseDescription, String courseObjectives, String courseSubTitle, Date courseCreatedOn, Date courseUpdatedOn, boolean isApproved, boolean isPublished, int semester) {
        this.courseTitle = courseTitle;
        this.courseDescription = courseDescription;
        this.courseObjectives = courseObjectives;
        this.courseSubTitle = courseSubTitle;
        this.courseCreatedOn = courseCreatedOn;
        this.courseUpdatedOn = courseUpdatedOn;
        this.isApproved = isApproved;
        this.isPublished = isPublished;
        this.semester = semester;
    }

    public long getId() {
        return id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCourseObjectives() {
        return courseObjectives;
    }

    public void setCourseObjectives(String courseObjectives) {
        this.courseObjectives = courseObjectives;
    }

    public String getCourseSubTitle() {
        return courseSubTitle;
    }

    public void setCourseSubTitle(String courseSubTitle) {
        this.courseSubTitle = courseSubTitle;
    }

    public Date getCourseCreatedOn() {
        return courseCreatedOn;
    }

    public void setCourseCreatedOn(Date courseCreatedOn) {
        this.courseCreatedOn = courseCreatedOn;
    }

    public Date getCourseUpdatedOn() {
        return courseUpdatedOn;
    }

    public void setCourseUpdatedOn(Date courseUpdatedOn) {
        this.courseUpdatedOn = courseUpdatedOn;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseTitle='" + courseTitle + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", courseObjectives='" + courseObjectives + '\'' +
                ", courseSubTitle='" + courseSubTitle + '\'' +
                ", courseCreatedOn=" + courseCreatedOn +
                ", courseUpdatedOn=" + courseUpdatedOn +
                ", isApproved=" + isApproved +
                ", isPublished=" + isPublished +
                ", semester=" + semester +
                '}';
    }
}
