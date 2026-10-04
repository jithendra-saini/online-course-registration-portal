package com.portal.OnlineCourseReg.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portal.OnlineCourseReg.model.Student;
import com.portal.OnlineCourseReg.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repo;
    @Override
    public Student addStudent(Student student) {
        return repo.save(student);
    }
    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }
    @Override
    public Student getStudentById(int id) {
        return repo.findById(id).orElse(null);
    }
    @Override
    public Student updateStudent(int id, Student student) {
        Student existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setBranch(student.getBranch());
        return repo.save(existing);
    }
    @Override
    public void deleteStudent(int id) {
        repo.deleteById(id);
    }
    @Override
    public Student findByEmail(String email) {
        return repo.findByEmail(email);
    }
}