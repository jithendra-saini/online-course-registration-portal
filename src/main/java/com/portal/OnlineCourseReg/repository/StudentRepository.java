package com.portal.OnlineCourseReg.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.portal.OnlineCourseReg.model.Student;
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByEmail(String email);
}