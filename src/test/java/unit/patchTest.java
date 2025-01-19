package unit;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class patchTest {
	@Test
//	@Disabled
	public void patchTestOneGo() {
		String baseUrl="https://reqres.in/";
		String basePath="api/users/{id}";
		String bodyString ="{\"name\": \"Tasnim\", \"job\": \"Teacher\"}";
		//same like above
		RestAssured.given()
		.baseUri(baseUrl)
		.basePath(basePath)
		.body(bodyString)
		.pathParam("id", 200)
		.contentType(ContentType.JSON)
		//.auth().preemptive() //if we have access
		.when()
		.log().all()
		.patch()
		.then()
		.log().all()
		.statusCode(200)
		.body("name", Matchers.equalTo("Tasnim"));
	}
	@Test
@Disabled
	public void patchTestOneGo01() {
		String baseUrl="https://reqres.in/";
		String basePath="api/users/{id}";
		String bodyString ="{ \"job\": \"Teacher\"}";
		//same like above
		RestAssured.given()
		.baseUri(baseUrl)
		.basePath(basePath)
		.body(bodyString)
		.pathParam("id", 200)
		.contentType(ContentType.JSON)
		//.auth().preemptive() //if we have access
		.when()
		.log().all()
		.patch()
		.then()
		.log().all()
		.statusCode(200)
		.body("job", Matchers.equalTo("Teacher"));
	}
}
