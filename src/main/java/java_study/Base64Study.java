package java_study;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Study {

	public static void main(String[] args) throws Throwable {

		base64EncodeDecode();
		mimeEncodeDecode();
		urlEncodeDecode();
		
	}
	
	private static void base64EncodeDecode() throws UnsupportedEncodingException {
		MiscStudy.printMethodName();
		
		final String input = "I like Java";
		final String encoded = Base64.getEncoder().encodeToString(input.getBytes(StandardCharsets.UTF_8));
		final String decoded = new String(Base64.getDecoder().decode(encoded.getBytes()), StandardCharsets.UTF_8);
		
		System.out.println("\tinput: " + input);
		System.out.println("\tencoded: " + encoded);
		System.out.println("\tdecoded: " + decoded);
		System.out.println();
	}
	
	private static void mimeEncodeDecode() {
		MiscStudy.printMethodName();
		
		final String input = "I like Java";
		final String encoded = Base64.getMimeEncoder().encodeToString(input.getBytes());
		final String decoded = new String(Base64.getMimeDecoder().decode(encoded));

		System.out.println("\tinput: " + input);
		System.out.println("\tencoded: " + encoded);
		System.out.println("\tdecoded: " + decoded);
		System.out.println();
	}
	
	private static void urlEncodeDecode() {
		MiscStudy.printMethodName();
		
		final String input = "https://www.google.com/search?q=I+like+Java";
		final String encoded = Base64.getUrlEncoder().encodeToString(input.getBytes());
		final String decoded = new String(Base64.getUrlDecoder().decode(encoded));

		System.out.println("\tinput: " + input);
		System.out.println("\tencoded: " + encoded);
		System.out.println("\tdecoded: " + decoded);
		System.out.println();
	}
	
}
