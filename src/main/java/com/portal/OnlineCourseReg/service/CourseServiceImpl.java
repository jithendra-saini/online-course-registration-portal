package com.portal.OnlineCourseReg.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portal.OnlineCourseReg.model.Course;
import com.portal.OnlineCourseReg.repository.CourseRepository;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository repo;
    public Course addCourse(Course course) {
        return repo.save(course);
    }
    public List<Course> getAllCourses() {
        return repo.findAll();
    }
}