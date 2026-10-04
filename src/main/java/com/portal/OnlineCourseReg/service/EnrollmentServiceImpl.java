package com.portal.OnlineCourseReg.service;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portal.OnlineCourseReg.model.Course;
import com.portal.OnlineCourseReg.model.Enrollment;
import com.portal.OnlineCourseReg.model.Student;
import com.portal.OnlineCourseReg.repository.CourseRepository;
import com.portal.OnlineCourseReg.repository.EnrollmentRepository;
import com.portal.OnlineCourseReg.repository.StudentRepository;
@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepo;
    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private CourseRepository courseRepo;
    @Override
    public Enrollment enrollStudent(int studentId, int courseId) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        if (enrollmentRepo.existsByStudent_IdAndCourse_Id(studentId, courseId)) {
            throw new RuntimeException("Already enrolled");
        }
        Enrollment e = new Enrollment();
        e.setStudent(student);
        e.setCourse(course);
        e.setEnrollmentDate(LocalDate.now());
        return enrollmentRepo.save(e);
    }
    @Override
    public List<Enrollment> getByStudentId(int studentId) {
        return enrollmentRepo.findByStudent_Id(studentId);
    }
}