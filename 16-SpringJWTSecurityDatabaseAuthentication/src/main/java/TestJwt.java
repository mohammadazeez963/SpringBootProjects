import java.util.Scanner;

import com.zensar.messageapi.security.jwt.util.JWTUtil;

public class TestJwt {
	public static void main(String[] args) {
		JWTUtil jwt = new JWTUtil();
		//System.out.println(jwt.generateToken("azeez"));
		String token  = jwt.generateToken("azeez");
		
		new Scanner(System.in).next(); // This is to make sure program haults
															// sO time expires and token become invalid
															// to test expiration time test
		
		
		
		try {
			jwt.validateToken(token);
			System.out.println("The token is valid");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("The token is invalid");
		}
	}
}
