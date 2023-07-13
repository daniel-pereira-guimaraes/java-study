/* Setup environment variables on system or 
 * Eclipse > Run > Run Configurations... > Environment.
 */
package java_study;

import java.io.File;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SmtpStudy {
	
	private static final String MIME_TEXT_HTML = "text/html";
	private static final String ENV_TO_MAIL = "TO_MAIL";
	private static final String ENV_FROM_MAIL = "FROM_MAIL";
	static final String MSG_SUBJECT = "Message subject";
	static final String TEXT_BODY = "Body message example.";
	static final String HTML_BODY = "<h1>Test message</h1><p>This is an example of an <b>HTML</b> message.</p>";
	static final String SENDING_MAIL = "Sending mail...";
	static final String SENT_SUCCESS = "Sent with success!";
	static final String FILE_PATH = "C:\\temp\\text.txt";
	
	public static void main(String[] args) {
		sendSimpleEmail();
		sendHtmlEmail();
		sendHtmlEmailWithAttachment();
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
			@Override
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
			final String fromMail = System.getenv(ENV_FROM_MAIL); // sender@mailserver.com
			final String toMail = System.getenv(ENV_TO_MAIL); // recipient@mailserver.com

			final MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromMail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
			message.setSubject(MSG_SUBJECT);
			message.setText(TEXT_BODY);
			
			sendEmail(message);
		} 
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void sendHtmlEmail() {
		MiscStudy.printMethodName();
		final Session session = setupMailServer();
		try {
			final String fromMail = System.getenv(ENV_FROM_MAIL); // sender@mailserver.com
			final String toMail = System.getenv(ENV_TO_MAIL); // recipient@mailserver.com

			final MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromMail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
			message.setSubject(MSG_SUBJECT);
			message.setContent(HTML_BODY, MIME_TEXT_HTML);
			
			sendEmail(message);
		} 
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void sendHtmlEmailWithAttachment() {
		MiscStudy.printMethodName();
		final Session session = setupMailServer();
		try {
			final String fromMail = System.getenv(ENV_FROM_MAIL); // sender@mailserver.com
			final String toMail = System.getenv(ENV_TO_MAIL); // recipient@mailserver.com

			final MimeBodyPart attachmentPart = new MimeBodyPart();
			attachmentPart.attachFile(new File(FILE_PATH));
			
			final MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(HTML_BODY, MIME_TEXT_HTML);
			
			final Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(htmlPart);
			multipart.addBodyPart(attachmentPart);
		     
			final MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromMail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
			message.setSubject(MSG_SUBJECT);
			message.setContent(multipart);
			
			sendEmail(message);
		} 
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
