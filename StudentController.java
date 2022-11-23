package com.example.demowork.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demowork.model.Student;
import com.example.demowork.service.StudentService;
@Controller
public class StudentController {
private StudentService serv;
@GetMapping("/")
public String viewHome(Model m) {
	return findPaginated(1,"SNAME","asc",m);
}
@GetMapping("/showNewStudent")
public String showNewStudent(Model m) {
	Student stud=new Student();
	m.addAttribute("Student", stud);
	return "new_student";
}
@PostMapping("/saveStudent")
public String saveStudent(@ModelAttribute("Student") Student stud) {
	serv.saveStudent(stud);
	return "redirect:/";
}
@GetMapping("showUpdateForm/{ID}")
public String showUpdateForm(@PathVariable (value="ID") long ID, Model m) {
	Student stud=serv.getStudentByID(ID);
	m.addAttribute("Student", stud);
	return "update_student";
}
@GetMapping("deleteStudent/{ID}")
public String deleteStudent(@PathVariable (value="ID") long ID) {
	this.serv.deleteStudent(ID);
	return "redirect:/";
}
@GetMapping("/page/{pageNo}")
public String findPaginated(@PathVariable (value="pageNo") int pgno,@RequestParam("sortField") String sortf,@RequestParam("sortDir") String sortd,Model m) {
	int ps=5;
	Page<Student> pg=serv.findPaginated(pgno,ps,sortf,sortd);
	List<Student> ls=pg.getContent();
	m.addAttribute("currentPage",pgno);
	m.addAttribute("totalPages",pg.getTotalPages());
	m.addAttribute("totalItems",pg.getTotalElements());
	m.addAttribute("sortField",sortf);
	m.addAttribute("sortDir",sortd);
	m.addAttribute("reverseSortDir",sortd.equals("asc")?"desc":"asc");
	m.addAttribute("listStudents",ls);
	return "index";
}
}
