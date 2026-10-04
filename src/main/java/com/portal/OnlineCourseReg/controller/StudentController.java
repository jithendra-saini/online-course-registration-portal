package com.portal.OnlineCourseReg.controller;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.portal.OnlineCourseReg.model.Student;
import com.portal.OnlineCourseReg.service.EnrollmentService;
import com.portal.OnlineCourseReg.service.StudentService;
@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {
    @Autowired
    private StudentService service;
    @Autowired
    private EnrollmentService enrollmentService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, Object> payload) {
        try {
            Student s = new Student();
            s.setName((String) payload.get("name"));
            s.setEmail((String) payload.get("email"));
            s.setContact((String) payload.get("contact"));
            s.setBranch((String) payload.get("branch"));
            s.setPassword((String) payload.get("password"));
            Student saved = service.addStudent(s);
            Object cidObj = payload.get("courseId");
            if (cidObj == null || cidObj.toString().isEmpty()) {
                return ResponseEntity.badRequest().body("Course not selected");
            }
            int courseId = Integer.parseInt(cidObj.toString());
            System.out.println("Enrolling student " + saved.getId() + " to course " + courseId);
            enrollmentService.enrollStudent(saved.getId(), courseId);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Student student) {
        Student existing = service.findByEmail(student.getEmail());
        if (existing == null) {
            return ResponseEntity.status(404).body("Email not found");
        }
        if (!existing.getPassword().equals(student.getPassword())) {
            return ResponseEntity.status(401).body("Wrong password");
        }
        return ResponseEntity.ok(existing);
    }
    @GetMapping("/getstudents")
    public List<Student> getAll() {
        return service.getAllStudents();
    }
    @DeleteMapping("/deletestudent/{id}")
    public void delete(@PathVariable int id) {
        service.deleteStudent(id);
    }
    @PutMapping("/updatestudent/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        System.out.println("UPDATE HIT: " + student.getName()); // debug
        return service.updateStudent(id, student);
    }
}