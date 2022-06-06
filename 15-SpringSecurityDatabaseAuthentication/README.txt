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
	