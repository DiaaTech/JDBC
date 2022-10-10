import java.sql.*;				// 1st Step

import com.mysql.cj.jdbc.PreparedStatementWrapper;

public class DataBase {
	
	// Connection Variable
	Connection con;
	Statement statement;
	
	// constructor
	public DataBase() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");		// 2nd Step | Register Driver
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/diastudent","root","851438");		// 3rd Step | Make Connection
		statement = con.createStatement();
	}
	
	
	// for displaying Data of Person DataBase
	public void showData(String query) throws Exception {

		ResultSet rs = statement.executeQuery(query);	
		while(rs.next()) {			
			System.out.println("Roll No: " + rs.getInt(1));
			System.out.println("Name: " + rs.getString(2));
			System.out.println("Address: " + rs.getString(3));
			System.out.println("Age: " + rs.getInt(4));
			System.out.println("=============================");
		}
	}
	
	// Deleting Person
	public void deletePerson(int rollNo) throws Exception{
		String queryString = "delete from person where rollNo = " + rollNo;
		statement.executeUpdate(queryString);
		System.out.println("Person is Deleted");
	}
	
	// Add new Person
	public void addPerson(String name, String address, int rollNo, int age) throws Exception{
		
		PreparedStatement pr = con.prepareStatement("insert into person (rollNo, name, address, age) values (?, ?, ?, ?)"); 
		
		pr.setInt(1, rollNo);
		pr.setString(2, name);
		pr.setString(3, address);
		pr.setInt(4, age);

		pr.executeUpdate();
		System.out.print("Person is Added");
	}
	// update 
	
	// search a person
	
	// search person with two A in his Name
	// search person living in US
}
