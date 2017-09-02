package help;

import java.sql.*;

public class Test {

	public static void main(String[] args) {
		
		int userID = 0;
		
		Datenbank db = new Datenbank();
		
		ResultSet rs = db.empfangen("SELECT COUNT(userID) FROM user");
		
		try {
			rs.next();
			userID = (Integer.parseInt(rs.getString("COUNT(UserID)")));
			System.out.println(userID);
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(userID);
		
		}
	}
	
