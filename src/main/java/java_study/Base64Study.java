package java_study;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Study {

	public static void main(String[] args) throws Throwable {

		encodeDecodeBase64();
		
	}
	
	private static void encodeDecodeBase64() throws UnsupportedEncodingException {
		MiscStudy.printMethodName();
		
		final String input = "I like Java";
		final String encoded = Base64.getEncoder().encodeToString(input.getBytes("utf-8"));
		final String decoded = new String(Base64.getDecoder().decode(encoded.getBytes()), "utf-8");
		
		System.out.println("\tinput: " + input);
		System.out.println("\tencoded: " + encoded);
		System.out.println("\tdecoded: " + decoded);
		System.out.println();
	}
}
