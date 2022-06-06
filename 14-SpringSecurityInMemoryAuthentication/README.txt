Htttp Status codes

200  OK

401  unauthorized

403  Forbidden(Authenticated but not allowed to access)


Steps for applying Spring Security

1) Add dependency in pom.xml
	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		
 By default user id is : user
 and password will generated in console
 
 This project stores the credentials in Inmemory
 
 For every time when we restart the server the new password will be auto generated
 
 we want to have custom user name and password
 
 2) write configuration class
	