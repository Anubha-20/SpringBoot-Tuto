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
//here we have used row mapper that is an functional interface used to map rows of the
//ResultSet to object  -> smapRow(ResultSet rs, int rowNum): ● This method is executed for each row in the ResultSet. ● It contains two parameters: ○ ResultSet rs: The result of the SQL query containing the data. ○ int rowNum: The current row number in the ResultSet. ● It returns a Java object representing the current row, populated with data from the ResultSet. jdbcTemplate.query(): ● This method is used to perform SELECT operations in Spring JDBC. ● It requires two parameters: 1. SQL Query: The SQL query that need to be executed. 2. RowMapper: The object responsible for mapping each row of the ResultSet to a Java object.
	public List<Student> findAll() {
String sql="select * from student";
return jdbc.query(sql,(rs,rowno)->{
  Student s = new Student();
  s.setRollNo(rs.getInt("rollno"));
  s.setName(rs.getString("name"));
  s.setMarks(rs.getInt("marks"));
  return s;
});

	
	}
}
