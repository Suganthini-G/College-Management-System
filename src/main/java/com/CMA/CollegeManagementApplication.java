package com.CMA;


import java.sql.Date;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.CMA.DAO.AdminRepository;
import com.CMA.DAO.CourseRepository;
import com.CMA.DAO.GradeRepository;
import com.CMA.DAO.StudentRepository;
import com.CMA.DAO.TeacherRepository;
import com.CMA.entities.AdminEntity;
import com.CMA.entities.CourseEntity;
import com.CMA.entities.StudentEntity;
import com.CMA.entities.TeacherEntity;

@SpringBootApplication
public class CollegeManagementApplication {

	@Autowired
	AdminRepository adRepo;
	
	@Autowired
	CourseRepository couRepo;
	
	@Autowired
	GradeRepository graRepo;
	
	@Autowired
	StudentRepository studRepo;
	
	@Autowired
	TeacherRepository teaRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CollegeManagementApplication.class, args);
	}
	

	@Bean
	CommandLineRunner runner() {
		
		return args -> {
			
			//USERS
			AdminEntity ad1 = new AdminEntity("Subhash", "Chandra", "admin@gmail.com", "admin");
			AdminEntity ad2 = new AdminEntity("Riyaash", "Wikrama", "admin2@gmail.com", "admin2");
			
			TeacherEntity teach1 = new TeacherEntity("Rajesh", "Menon", "teacher@gmail.com", "teacher");
			TeacherEntity teach2 = new TeacherEntity("Priya", "John", "97621@cma-teacher.com", "imateachers");
			TeacherEntity teach3 = new TeacherEntity("Ahammad", "Nazir", "92893@cma-teacher.com", "kjnjnhebfy!");
			
			StudentEntity stud1 = new StudentEntity("Aman", "Roy", "student@gmail.com", "student");
			StudentEntity stud2 = new StudentEntity("Jacky", "Roshan", "jacky@gmail.com", "jacky");
			StudentEntity stud3 = new StudentEntity("Prakash", "Kumar", "41312@cma-student.com", "tryme3!");
			StudentEntity stud4 = new StudentEntity("Olivia", "Jackson", "45562@cma-student.com", "vnjnvhb2");
			

			
			CourseEntity course1 = new CourseEntity("Programming", "NOTSTARTED", Date.valueOf("2022-04-10"), Date.valueOf("2022-06-10"), 8);
			CourseEntity course2 = new CourseEntity("Computer Science", "INPROGRESS", Date.valueOf("2022-01-01"), Date.valueOf("2022-05-01"), 8);
			CourseEntity course3 = new CourseEntity("Algorithms", "COMPLETED", Date.valueOf("2021-12-15"), Date.valueOf("2022-02-15"), 5);
			CourseEntity course4 = new CourseEntity("Data Structures", "NOTSTARTED", Date.valueOf("2022-03-28"), Date.valueOf("2022-05-28"), 5);
			
			//SAVE ALL ENTITIES
			
			adRepo.save(ad1);
			adRepo.save(ad2);
			
			teaRepo.save(teach1);
			teaRepo.save(teach2);
			teaRepo.save(teach3);
			
			studRepo.save(stud1);
			studRepo.save(stud2);
			studRepo.save(stud3);
			studRepo.save(stud4);
			
			couRepo.save(course1);
			couRepo.save(course2);
			couRepo.save(course3);
			couRepo.save(course4);
			

			
			course1.setTheTeacher(teach1);
			course2.setTheTeacher(teach1);
			course3.setTheTeacher(teach1);
			course4.setTheTeacher(teach1);
			
			teach1.setCourses(Arrays.asList(course1, course2, course3, course4));
			
			couRepo.save(course1);
			couRepo.save(course2);
			couRepo.save(course3);
			couRepo.save(course4);
			
			teaRepo.save(teach1);
			
		};
		
	}
}
