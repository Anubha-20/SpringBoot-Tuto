package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext cntxt=SpringApplication.run(DemoApplication.class, args);
    Student s=cntxt.getBean(Student.class);
		s.setRollNo(1);
		s.setName("John");
		s.setMarks(80);
		StudentService service = cntxt.getBean(StudentService.class);
    service.addStudent(s);

    List<Student> l1=service.getStudents();
    System.out.println(l1);
	}

}
