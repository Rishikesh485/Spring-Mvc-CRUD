package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dto.Student;

@Component
public class StudentDao {
	@Autowired			//ye bas dao service me hi likhneka
	EntityManagerFactory entityManagerFactory;
	public Student saveStudent(Student student) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();	//yaha pe create kiya jayega apna commands & informations
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();	//start
		entityManager.persist(student);		//feeka database me
		entityTransaction.commit();			//fix krke daal diya 
		return student;
		
		 
	}
	public List<Student> readAllStudent(){
		EntityManager entityManager=entityManagerFactory.createEntityManager();	
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		String sql = "Select s From Student s";
		Query query = entityManager.createQuery(sql);
		List<Student> students  = query.getResultList();
		return students;
		
	}
	public boolean deleteStudent(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();	
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.remove(entityManager.find(Student.class, id));
		entityTransaction.commit();
		return true;
		
	}
	  public void updateStudentById(Student student,int id) {
	    	EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			
			Student student2 = entityManager.find(Student.class, id);
			if(student2 !=null) {
				entityTransaction.begin();
				if (student.getName() != null) {
					student2.setName(student.getName());
					}
				if (student.getEmail() != null) {
					student2.setEmail(student.getEmail());
					
				} 
				entityManager.merge(student2);
				entityTransaction.commit();
			}
	    }
	
}
