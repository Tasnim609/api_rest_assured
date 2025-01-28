package unit;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import dataTableObject.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class POSTTest {
	/*
	 * 1. Test Data Creation (User)
	 * 2. Request Building 
	 * 3. Response Object Mapping(User)
	 * 4.Assertion
	 */
	String baseUrl="https://reqres.in/";
	String basePath="api/users";
	String bodyString ="{\"name\": \"Tasnim\", \"job\": \"Teacher\"}";
	
	
	@Test
	@Disabled
	public void postTestOneGo() {
		
		Response respose = RestAssured.given()
		.baseUri(baseUrl)
		.basePath(basePath)
		.body(bodyString)
		.contentType(ContentType.JSON)
		//.auth().preemptive() //if we have access
		.when()
		.log().all()
		.post();
		
		//.statusCode(201)
		Assertions.assertEquals(201, respose.getStatusCode());
		
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
	@Disabled
	public void putTestOneGo_json_body() {
		File file =new File("src/test/resources/user.json");
		//same like above
		RestAssured.given()
		.baseUri(baseUrl)
		.basePath(basePath)
		.body(file)
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
	
	Map<  String , Object> userMap = new HashMap<String,Object>();
@Test
@Disabled
public void postTestOneGo_map_body() {
	
	userMap.put("first_name", "jean");
	userMap.put("job", "lead");
	
	RestAssured.given()
	.baseUri(baseUrl)
	.basePath(basePath)
	.body(userMap)
	.contentType(ContentType.JSON)
	//.auth().preemptive() //if we have access
	.when()
	.log().all()
	.post()
	.then()
	.log().all()
	.statusCode(201)
	//.body("first_name", Matchers.equalTo("jean"));
	.body("first_name", Matchers.equalTo(userMap.get("first_name")));//same
	
}
private String jsonBuilder() {
	JSONObject json =new JSONObject();
	json.put("first_name", "darimee");
	json.put("job", "student");
	
	return json.toString();
}

@Test
@Disabled
public void postTestOneGo_json_builder() {
	
	RestAssured.given()
	.baseUri(baseUrl)
	.basePath(basePath)
	.body(jsonBuilder())
	.contentType(ContentType.JSON)
	//.auth().preemptive() //if we have access
	.when()
	.log().all()
	.post()
	.then()
	.log().all()
	.statusCode(201)
	//.body("first_name", Matchers.equalTo("jean"));
	.body("first_name", Matchers.equalTo("darimee"));//same
	
}
@Test
//@Disabled
public void postTestOneGo_UserClass() {
	
	User user = new User();
	user.setFirst_name("Marnia");
	user.setLast_name("Qurashy");
	user.setJob("student");
	
	Response response =RestAssured.given()
	.baseUri(baseUrl)
	.basePath(basePath)
	.body(user)
	.contentType(ContentType.JSON)
	//.auth().preemptive() //if we have access
	.when()
	.log().all()
	.post();
	response.then().log().all();//we can use or not 
	Assertions.assertEquals(201, response.getStatusCode());
	User actualUser = response.as(User.class);
	Assertions.assertEquals(user.getFirst_name(), actualUser.getFirst_name(),"Name did not match");
	Assertions.assertEquals(user.getLast_name(), actualUser.getLast_name(),"Name did not match");
	Assertions.assertEquals(user.getJob(), actualUser.getJob(),"Job did not match");
}
}