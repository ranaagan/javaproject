package studentRegistrationSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseRegistration {
	
public static void addCourse(Connection conn, Student x, int z)throws SQLException {
		
		String sql = "INSERT INTO Registration (student_id, course_id) VALUES (?, ?)";
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, x.getID());
		preparedStatement.setInt(2, z);
		int row = preparedStatement.executeUpdate();
		  
		if (row > 0) { System.out.println("A row has been inserted successfully."); }
		
	}

public static void viewAllCourses(Connection conn)throws SQLException {
	
	String sql = "SELECT * FROM Courses";
	
	PreparedStatement preparedStatement = conn.prepareStatement(sql);
	ResultSet resultSet = preparedStatement.executeQuery();
	while(resultSet.next()){
		System.out.println(resultSet.getInt("ID") + " , "
				+ resultSet.getString("course_name")+ " , "
				+ resultSet.getString("instructor")+" , "
				+ resultSet.getInt("course_credits")+" , "
				+ resultSet.getInt("course_capacity")+" , "
				+ resultSet.getInt("registered_students"));
	}
}
	
public static void viewMyCourses(Connection conn, Student student)throws SQLException {
		
		String sql = "SELECT Courses.course_name FROM Registration INNER JOIN Courses ON "
				+ "Registration.course_id=Courses.ID WHERE Registration.student_id='"+student.getID()+"'";
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()){
			System.out.println(resultSet.getString("course_name"));
					
		}
		
	}

}
