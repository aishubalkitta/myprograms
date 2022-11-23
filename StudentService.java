package com.example.demowork.service;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demowork.model.Student;
public interface StudentService{
	List<Student> getAllStudents();
	void saveStudent(Student stud);
	Student getStudentByID(long ID);
	void deleteStudent(long ID);
	Page<Student> findPaginated(int pageNo,int ps, String sortf, String sortd);
}
