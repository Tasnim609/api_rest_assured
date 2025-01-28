package unit;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutTest {
	@Test
	@Disabled
	public void putTestOneGo01() {
		String baseUrl="https://reqres.in/";
		String basePath="api/users";
		String bodyString ="{\"name\": \"Tasnim\", \"job\": \"Teacher\"}";
		//same like above
		RestAssured.given()
		.baseUri(baseUrl)
		.basePath(basePath)
		.body(bodyString)
		.contentType(ContentType.JSON)  
		//.auth().preemptive() //if we have access
		.when()
		.log().all()
		.put()
		.then()
		.log().all()
		.statusCode(201)//if we create it will 201  
		.body("name", Matchers.equalTo("Tasnim"));
	}
	@Test
	//@Disabled
	public void putTestOneGo02() {
		String baseUrl="https://reqres.in/";
		String basePath="api/users";
		String bodyString ="{\"name\": \"Tasnim\", \"job\": \"Teacher\"}";
		//same like above
		RestAssured.given()
		.baseUri(baseUrl)
		.basePath(basePath)
		.body(bodyString)
		.contentType(ContentType.JSON)
		//.auth().preemptive() //if we have access
		.when()
		.log().all()
		.put()
		.then()
		.log().all()
		.statusCode(200)
		.body("name", Matchers.equalTo("Tasnim"));
	}
	@Test
	@Disabled
	public void putTestOneGo() {
		//Multiple base Path
	//	String basePath="api/users/{id}/accounts/{accountId}";

		String baseUrl="https://reqres.in/";
		String basePath="api/users/{id}";
		String bodyString ="{\"name\": \"Tasnim\", \"job\": \"Teacher\"}";
		//same like above
		RestAssured.given()
		.baseUri(baseUrl)
		.basePath(basePath)
		.body(bodyString)
		.pathParam("id", 300)
		.contentType(ContentType.JSON)
		//.auth().preemptive() //if we have access
		.when()
		.log().all()
		.put()
		.then()
		.log().all()
		.statusCode(200)
		.body("name", Matchers.equalTo("Tasnim"));
	}
	@Test
	@Disabled
	public void DeleteTestOneGo01() {
		String baseUrl="https://reqres.in/";
		String basePath="api/users";
		String bodyString ="{\"name\": \"Tasnim\", \"job\": \"Teacher\"}";
		//same like above
		RestAssured.given()
		.baseUri(baseUrl)
		.basePath(basePath)
		.body(bodyString)
		.contentType(ContentType.JSON)
		//.auth().preemptive() //if we have access
		.when()
		.log().all()
		.delete() //no need -- get()
		.then()
		.log().all()
		.statusCode(201)
		.body("name", Matchers.equalTo("Tasnim"));
	}
}
