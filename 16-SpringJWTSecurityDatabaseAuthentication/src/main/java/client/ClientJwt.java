package client;


import java.util.Scanner;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.zensar.messageapi.entity.ZensarUser;


public class ClientJwt {

	public static void main(String[] args) {
		
		
		
		// following the url on server we want to access
		
		String url = "http://localhost:8090/api/authenticate";
		
		// RestTemplate is a class given by spring to consume REST web service
		
		RestTemplate rt = new RestTemplate();

		
		
		ZensarUser request = new ZensarUser();
		request.setUsername("azeez");
		request.setPassword("azeez");
		
		String token = rt.postForObject(url, request, String.class);
		System.out.println(token);
	
String ourl = "http://localhost:8090/api/message";
		
		// RestTemplate is a class given by spring to consume REST web service
		
	
		
			
	
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer "+token);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		ResponseEntity<String> exchange = rt.exchange(ourl, HttpMethod.GET, entity, String.class);
		System.out.println(exchange.getBody());
	

	}

}
