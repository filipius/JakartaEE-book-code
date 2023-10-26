package book;

import java.util.List;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import pojo.Person;

public class App {
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target("http://localhost:8080/restws/rest/myservice/person1");
		Response response = target.request().get();
		String value = response.readEntity(String.class);
		System.out.println("RESPONSE1: " + value);
		response.close();

		target = client.target("http://localhost:8080/restws/rest/myservice/person2");
		target = target.queryParam("name", "xpto");
		response = target.request().get();
		value = response.readEntity(String.class);
		System.out.println("RESPONSE2: " + value);
		response.close();

		target = client.target("http://localhost:8080/restws/rest/myservice/person3/xpto");
		response = target.request().get();
		value = response.readEntity(String.class);
		System.out.println("RESPONSE3: " + value);
		response.close();		

		target = client.target("http://localhost:8080/restws/rest/myservice/person4");
		Person p = new Person("Peter", 40);
		Entity<Person> input = Entity.entity(p, MediaType.APPLICATION_JSON);
		response = target.request().post(input);
		value = response.readEntity(String.class);
		System.out.println("RESPONSE4: " + value);
		response.close();

		target = client.target("http://localhost:8080/restws/rest/myservice/person5");
		response = target.request().post(input);
		p = response.readEntity(Person.class);
		System.out.println("RESPONSE5: " + p.getName() + " " + p.getAge());
		response.close();
		
		target = client.target("http://localhost:8080/restws/rest/myservice/person6");
		response = target.request().get();		
		List<Person> personList = response.readEntity(new GenericType<List<Person>>(){});
		System.out.println("RESPONSE6: " + personList);
		response.close();
	}
}
