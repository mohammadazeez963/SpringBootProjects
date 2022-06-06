Htttp Status codes

200  OK

401  unauthoried


Steps for applying Spring Security

1) Add dependency in pom.xml
	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		
 By default user id is : user
 and password will generated in console
 
 This project will store the credentials in DATA BASE
 
 For every time when we restart the server the new password will be auto generated
 
 we want to have custom user name and password
 
 2) write configuration class
	
	spring security gives implicit for an attack known as -CSRF (Cross side request forgery)
	POST request doesn't work
	
	so we need do additional configuration as follows -
	
	JWT
	JWT stands for JSON web token
	JWT consists 3 parts
	Header.payload.signature
	Header consists of algorithm used to generate the token
	payload consists of claims (Claim - It is the additional data about user entity)
					ex:- username,expiration time etc.
					
	signature is a typically secret key (String which is only known to server to validate the token)
	
	eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9
	.eyJuYW1lIjoiYXplZXoiLCJleHAiOjE2NTM4OTU1MjR9
	.6Fsnp16YCCnjp9caAbZdSa9AOjxWyN7Z9_sIC3wYaN-0aAyVmyMZIyNMze5kPpz5uzeSwgYiuI4So9schqVp-A
	