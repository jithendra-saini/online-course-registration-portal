package com.portal.OnlineCourseReg.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.portal.OnlineCourseReg.service.EnrollmentService;
@RestController
@RequestMapping("/enroll")
@CrossOrigin(origins = "http://localhost:5173")
public class EnrollmentController {
    @Autowired
    private EnrollmentService service;
    @GetMapping("/{studentId}")
    public Object getEnrollments(@PathVariable int studentId) {
        return service.getByStudentId(studentId);
    }
}