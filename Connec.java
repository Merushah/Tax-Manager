import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connec {
	static Connection con;
	public static Connection createC() {
	String uname = "root";
	String pass = "Vithalkunj@2";
	String url = "jdbc:mysql://localhost:3306/tax" ;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e2) {
		e2.printStackTrace();
	}
	try {
		con = DriverManager.getConnection(url, uname, pass);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return con;
}
}
