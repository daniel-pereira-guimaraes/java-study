/* Setup environment variables on system or 
 * Eclipse > Run > Run Configurations... > Environment.
 */
package java_study;

import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SmtpStudy {
	
	static final String MSG_SUBJECT = "Message subject";
	static final String MSG_BODY = "Body message example.";
	static final String SENDING_MAIL = "Sending mail...";
	static final String SENT_SUCCESS = "Sent with success!";
	static final String FILE_PATH = "C:\\temp\\text.txt";
	
	public static void main(String[] args) {
		sendSimpleEmail();
	}
	
	private static Session setupMailServer() {
		
		// Get config from envionment.
		final Map<String, String> env = System.getenv();
		String host = env.get("SMTP_HOST"); // smtp.mailserver.com
		String port = env.get("SMTP_PORT"); // 25, 587, 465, ... 
		String user = env.get("SMTP_USER"); // user@mailserver.com
		String password = env.get("SMTP_PASSWORD");
		String auth = env.get("SMTP_AUTH"); // true or false
		String ssl = env.get("SMTP_SSL");  // true or false
		
		// Setup mail server
		final Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", auth);
		properties.put("mail.smtp.ssl.enable", ssl);

		// Get session object with authentication.
		final Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});		
		session.setDebug(true);

		return session; 
	}

	private static void sendEmail(final Message message) {
		System.out.println(SENDING_MAIL);
		try {
			Transport.send(message);
			System.out.println(SENT_SUCCESS);
		} 
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void sendSimpleEmail() {
		MiscStudy.printMethodName();
		final Session session = setupMailServer();
		try {
			final String fromMail = System.getenv("FROM_MAIL"); // sender@mailserver.com
			final String toMail = System.getenv("TO_MAIL"); // recipient@mailserver.com

			final MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromMail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
			message.setSubject(MSG_SUBJECT);
			message.setText(MSG_BODY);
			
			sendEmail(message);
		} 
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
