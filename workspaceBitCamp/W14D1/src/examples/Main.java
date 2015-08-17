package examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Library loaded.");
			
			conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/Zaid/Desktop/SQLite/test.db");
			System.out.println("Connection established.");			
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC library is not loaded.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		} catch (SQLException e) {
			System.err.println("Could not connect to the database.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		}
		
		try {
			Employee e = new Employee(10, "Musa", 10000);
			Statement statement = conn.createStatement();
			
			String c = "INSERT INTO employee VALUES(" + e.getId() + ", '" + e.getName() + "', " + e.getSalary() + ")";
			
			statement.executeUpdate(c);
		} catch (SQLException e) {
			System.out.println("Bad SQL Command.");
			System.out.println("Continuing on.");
		}
		
		ArrayList<Employee> list = new ArrayList<>();
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from employee");
		
			while (result.next()) {				
				int id = result.getInt(1);
				String name = result.getString(2);
				int salary = result.getInt(3);
				
				Employee e = new Employee(id, name, salary);
				list.add(e);
			}
		} catch (SQLException e) {
			System.err.println("Bad SQL command.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		}
		
		
		
		System.out.println(list);
	}

}
