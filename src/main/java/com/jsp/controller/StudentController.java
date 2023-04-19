package com.jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.dto.Student;
import com.jsp.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired   ////ye bas dao ,service & controller me hi likhneka
	StudentService studentService;
	@RequestMapping("/studentload")
	public ModelAndView loadme() {			//important uster se yaha aaeyga and load krega
		System.out.println("Reaching 1");
		ModelAndView modelAndView = new ModelAndView("createstudent.jsp");
		modelAndView.addObject("student1", new Student());
		return modelAndView;
		
	}
	
	@RequestMapping("/studentsave")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		System.out.println("Reaching 2");
		studentService.saveStudent(student);
		ModelAndView modelAndView = new ModelAndView("home.jsp");
		modelAndView.addObject("save", student.getName()+"saved successfully nigga");
		return modelAndView;
	}
	
	@RequestMapping("/viewAllStudents")
		public ModelAndView viewAll() {
		List<Student> students= studentService.readAllStudent();
			ModelAndView modelAndView=new ModelAndView("viewstudent.jsp");
			modelAndView.addObject("students", students);
			return modelAndView;
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteById(@RequestParam(name="id") int id) {
		ModelAndView  modelAndView = new ModelAndView("deleted.jsp");
		studentService.deleteStudent(id);
		modelAndView.addObject("deleted", "student with " + id + " deleted");
		return modelAndView;
	}
	 @RequestMapping("/update")
	   public ModelAndView updateNameById(@RequestParam(name="id")int id) {
		   ModelAndView modelAndView =new ModelAndView("updated.jsp");
		   modelAndView.addObject("student", new Student());
		   return modelAndView;
	   }
	   @RequestMapping("/studentupdated")
	   public ModelAndView updatedFinally(@ModelAttribute Student student) {
		   studentService.updateStudentById(student,student.getId());
		   ModelAndView modelAndView =new ModelAndView("updateDone.jsp");
		   modelAndView.addObject("updatedone", "student "+student.getId()+" updated");
		   return modelAndView;
	   }
}
