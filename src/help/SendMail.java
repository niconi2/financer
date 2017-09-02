package help;

import java.util.Properties;
import java.sql.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	private String username = "";
	private String password = "";

	Properties props = new Properties();
	
		public SendMail() {
		super();
	}

		public void send(String emailadresse, String subject, String text){
			
			
			//Passwort und Email aus DB holen, damit das Passwort nicht öffentlich ist
			
			Datenbank db = new Datenbank();
			
			ResultSet rs = db.empfangen("SELECT * FROM email;");
			
			try {
				rs.next();
				
				this.setPassword(rs.getString("Passwort"));
				this.setUsername(rs.getString("EmailAdresse"));
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("from-email@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(emailadresse));
				message.setSubject(subject);
				message.setText(text);

				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
		}





		public void setUsername(String username) {
			this.username = username;
		}





		public void setPassword(String password) {
			this.password = password;
		}





		public String getUsername() {
			return username;
		}





		public String getPassword() {
			return password;
		}
	
}

