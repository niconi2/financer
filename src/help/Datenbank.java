package help;


import java.sql.*;


public class Datenbank {

	public String url 			= null;
	public String benutzername 	= null;
	public String passwort		= null;
	
	private Connection con = null;
	
	private Statement stmt = null;
	
	public ResultSet empfangen(String befehl){
		try {
			PreparedStatement ps = this.getCon().prepareStatement(befehl);
			
			ps.executeQuery();
			
			ResultSet rs = null;
			rs = ps.executeQuery();
			return rs;
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;

		

	}
	
	public void senden(String befehl){
		
		try {
			PreparedStatement ps = this.getCon().prepareStatement(befehl);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		}
		

	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public Connection getCon() {
		try {
			con = DriverManager.getConnection (
					this.getUrl(),
					this.getBenutzername(),
					this.getPasswort());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public Datenbank() {
		super();
		this.url = "jdbc:mysql://localhost:3306/financer";
		this.benutzername = "root";
		this.passwort = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		Connection con = null;
				
		try {
			con = DriverManager.getConnection (
					url,
					benutzername,
					passwort);
			
			
			stmt = con.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	

	
	
	}
	
		

	

	


