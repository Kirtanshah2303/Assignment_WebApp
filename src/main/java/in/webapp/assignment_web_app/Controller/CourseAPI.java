package in.webapp.assignment_web_app.Controller;

import in.webapp.assignment_web_app.Entity.Course;
import in.webapp.assignment_web_app.Repository.CourseRepository;
import in.webapp.assignment_web_app.Service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/course")
public class CourseAPI {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    // to get all courses
    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    // to get course by id
    @GetMapping("/courses/{id}")
    public Optional<Course> getCourseById(@PathVariable(value = "id") Long courseId)
    {
        return courseRepository.findById(courseId);
    }


    // to add new course object
    @PostMapping("/courses")
    public Course createEmployee(@Valid @RequestBody Course course) {
        course.setId(sequenceGeneratorService.generateSequence(Course.SEQUENCE_NAME));
        course.setLocalDate(new Date());
        return courseRepository.save(course);
    }
}
