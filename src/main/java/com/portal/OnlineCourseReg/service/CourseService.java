package com.portal.OnlineCourseReg.service;
import java.util.List;
import com.portal.OnlineCourseReg.model.Course;
public interface CourseService {
    Course addCourse(Course course);
    List<Course> getAllCourses();
}