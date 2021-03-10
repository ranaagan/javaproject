package studentRegistrationSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseRegistration {
	
public static void addCourse(Connection conn, Student x, int z)throws SQLException {
	
		String sql = "SELECT course_capacity, registered_students FROM Courses WHERE ID =?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, z);
		ResultSet resultSet = preparedStatement.executeQuery();
		int capacity = 0;
		int registered = 0;
		while(resultSet.next()){
			capacity = resultSet.getInt("course_capacity");
			registered = resultSet.getInt("registered_students");
		}

		if (capacity > registered) {

		sql = "INSERT INTO Registration (student_id, course_id) VALUES (?, ?)";
		
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, x.getID());
		preparedStatement.setInt(2, z);
		int row = preparedStatement.executeUpdate();
		
		registered++;
				
		sql = "UPDATE Courses set registered_students = ? WHERE ID = ?";
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, registered);
		preparedStatement.setInt(2, z);
		preparedStatement.executeUpdate();
		}
		  
		else 
			System.out.println("This course is at full capacity. Registration unsuccessful");
		
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
		
		String sql = "SELECT Courses.ID, Courses.course_name FROM Registration INNER JOIN Courses ON "
				+ "Registration.course_id=Courses.ID WHERE Registration.student_id='"+student.getID()+"'";
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()){
			System.out.println(resultSet.getString("ID")+ "," +resultSet.getString("course_name"));
			
		}
		
	}

public static void deleteCourse(Connection conn, Student student, int x) throws SQLException{
	
	String sql = "DELETE FROM Registration WHERE student_id = ? AND course_id=?";
	
	PreparedStatement preparedStatement = conn.prepareStatement(sql);
	preparedStatement.setInt(1, student.getID()); 
	preparedStatement.setInt(2, x);
	preparedStatement.executeUpdate();
	
	sql = "SELECT registered_students FROM Courses WHERE ID =?";
	preparedStatement = conn.prepareStatement(sql);
	preparedStatement.setInt(1, x);
	ResultSet resultSet = preparedStatement.executeQuery();
	int registered = 0;
	while(resultSet.next()){
		registered = resultSet.getInt("registered_students");
	}
	
	registered--;
	
	sql = "UPDATE Courses SET registered_students = ? WHERE ID = ?";
	preparedStatement = conn.prepareStatement(sql);
	preparedStatement.setInt(1, registered);
	preparedStatement.setInt(2, x);
	preparedStatement.executeUpdate();
	
	
}

}
