package com.portal.OnlineCourseReg.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.portal.OnlineCourseReg.model.Enrollment;
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    boolean existsByStudent_IdAndCourse_Id(int studentId, int courseId);
    List<Enrollment> findByStudent_Id(int studentId);
}