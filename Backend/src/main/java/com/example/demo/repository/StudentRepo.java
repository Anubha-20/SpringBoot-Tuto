package com.example.demo.repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
@Repository
public class StudentRepo {

  private JdbcTemplate jdbc;
  @Autowired
  public void setJdbc(JdbcTemplate jdbc){
    this.jdbc=jdbc;
  }

  public JdbcTemplate getJdbc(){
    return jdbc;
  }
	public void save(Student s) {
    //update returns integer value means no of rows affected
   String sql="insert into student(rollNo,name,marks) values(?,?,?)";
   int rows= jdbc.update(sql,s.getRollNo(),s.getName(),s.getMarks());

   System.out.println("No of rows affected:"+rows);
		// System.out.println("Student saved successfully");
	}

	public List<Student> findAll() {
		List<Student> l1 = new ArrayList<>();
		return l1;
	}
}
