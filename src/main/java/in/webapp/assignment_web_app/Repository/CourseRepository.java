package in.webapp.assignment_web_app.Repository;

import in.webapp.assignment_web_app.Entity.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, Long> {
}
