package com.portal.OnlineCourseReg.service;
import java.util.List;
import com.portal.OnlineCourseReg.model.Enrollment;
public interface EnrollmentService {
    Enrollment enrollStudent(int studentId, int courseId);
    List<Enrollment> getByStudentId(int studentId);
}