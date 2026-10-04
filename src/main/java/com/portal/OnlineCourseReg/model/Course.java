package com.portal.OnlineCourseReg.model;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String courseName;
    private int duration;
    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<Enrollment> enrollments;
    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
}