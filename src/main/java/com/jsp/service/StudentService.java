package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

@Component
public class StudentService {
	@Autowired //ye bas dao service me hi likhneka
	StudentDao studentDao;
	public Student saveStudent(Student student) {  //copy kr dao pese save wala
		return studentDao.saveStudent(student);
		
	}
	public List<Student> readAllStudent(){
		return studentDao.readAllStudent();
		
	}
	public boolean deleteStudent(int id) {
		return studentDao.deleteStudent(id);
		
	}
	public void updateStudentById(Student student, int id) {
		studentDao.updateStudentById(student, id);
		
	}
	
}
