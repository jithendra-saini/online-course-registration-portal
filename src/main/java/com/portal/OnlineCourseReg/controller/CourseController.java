package com.portal.OnlineCourseReg.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.portal.OnlineCourseReg.model.Course;
import com.portal.OnlineCourseReg.service.CourseService;
@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "http://localhost:5173")
public class CourseController {
    @Autowired
    private CourseService service;
    @PostMapping("/add")
    public Course add(@RequestBody Course c) {
        return service.addCourse(c);
    }
    @GetMapping("/all")
    public List<Course> getAll() {
        return service.getAllCourses();
    }
}