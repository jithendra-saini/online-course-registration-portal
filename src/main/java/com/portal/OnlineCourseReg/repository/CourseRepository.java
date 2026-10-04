package com.portal.OnlineCourseReg.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.portal.OnlineCourseReg.model.Course;
public interface CourseRepository extends JpaRepository<Course, Integer> {}