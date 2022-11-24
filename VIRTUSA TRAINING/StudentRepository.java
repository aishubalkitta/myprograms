package com.example.demoproject.repository;  
import org.springframework.data.jpa.repository.JpaRepository;  
import com.example.demoproject.model.Student;  
public interface StudentRepository extends JpaRepository<Student, Integer>  
{  
	
}
