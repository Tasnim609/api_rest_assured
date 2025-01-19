package unit;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class POSTTest {
	String baseUrl="https://reqres.in/";
	String basePath="api/users";
	String bodyString ="{\"name\": \"Tasnim\", \"job\": \"Teacher\"}";
@Test
@Disabled
public void postTestOneGo() {
	RestAssured.given()
	.baseUri(baseUrl)
	.basePath(basePath)
	.body(bodyString)
	.contentType(ContentType.JSON)
	//.auth().preemptive() //if we have access
	.when()
	.log().all()
	.post()
	.then()
	.log().all()
	.statusCode(201)
	.body("name", Matchers.equalTo("Tasnim"));
}
@Test
@Disabled
public void postTestOneGo01() {
	//same like above
	RestAssured.given()
	.body(bodyString)
	.contentType(ContentType.JSON)
	.when()
	.post(baseUrl+basePath)
	.then()
	.log().all()
	.statusCode(201)
	.body("name", Matchers.equalTo("Tasnim"));
}

@Test
//@Disabled
public void putTestOneGo01() {
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
	.statusCode(201)
	.body("name", Matchers.equalTo("Tasnim"));
}
}