package unit;


import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
//First Class
public class GETTest {
	/*
	 * https://api.escuelajs.co/api/v1/products
	 * https=protocol
	 * api.escuelajs.co=host name /server name / Domain / context body
	 * api/v1/products = end point / resource locator /base path
	 * rest-assured=
	 * base URL=protocol +server name=https://api.escuelajs.co/
	 * base path =end point =api/v1/products
	 */

	String baseUrl ="https://api.escuelajs.co/";
	String getAllProductsEndPoint= "api/v1/products";
	@Test
	@Disabled
	public void getTestWithResponse() {
		
		Response response = RestAssured.given().get("https://api.escuelajs.co/api/v1/products");
		response.prettyPrint();
	//	System.out.println(String.format("Status Code : [%s]" , response.getStatusCode()));
	//	System.out.println("Status Code : [" + response.getStatusCode() + "]");
	//	System.out.println( response.getStatusCode() );
	//	System.out.println(String.format("Status Code : [%s] -%s" , response.getStatusCode(), "Success"));
	}
	@Test
@Disabled
	public void getTest01() {
	RestAssured.given().baseUri(baseUrl)//Pre-condition
	.basePath(getAllProductsEndPoint)
	//.header
	.when()// Action
	.log().all() // (Request Log) Log is very important
	.get()
	.then() //Validation
	.log().all() //(Response Log ) It will response the whole body in the Console
	.statusCode(200)
	.body("category.id[0]", Matchers.equalTo(1));//Validation
	
	
	
}
	@Test
	@Disabled
	public void getTest02() {
		//Not important
	Response response = RestAssured.given().baseUri(baseUrl)//Pre-condition
	.basePath(getAllProductsEndPoint)
	.when()// Action
	.log().all() // (Request Log) Log is very important
	.get();
	//Validation
	int actualStatusCode= response.getStatusCode();
Assertions.assertEquals(200, actualStatusCode);

	}
	@Test
	@Disabled
	public void getTest03() {
		
		//Not important
	Response response = RestAssured.given().baseUri(baseUrl)//Pre-condition
	.basePath(getAllProductsEndPoint)
	.when()// Action
	.log().all() // (Request Log) Log is very important
	.get();
System.out.println(response.asPrettyString());
JsonPath jPath= JsonPath.from(response.asString());
//System.out.println(jPath.getInt("page"));
//System.out.println(jPath.getInt("category.id[0]"));
System.out.println(jPath.getString("category.id[2].name"));
}
	@Test
	@Disabled
	public void SingleGetTestPathParam() {
		//How do we add [ Path parameter ]
		String baseUrl ="https://api.escuelajs.co/";
		String endPoint= "api/v1/products/{id}";
		
		int productId = 4;
		
		 RestAssured.given().baseUri(baseUrl)
		.basePath(endPoint)
		
		.pathParam("id", productId)
		.when()
		.log().all()
		//.delete() If we want to delete ,then no need [ get() ]
		.get()
		 .then()
		 .log().all()
		 .statusCode(200);
		
		
		
}
	@Test
	@Disabled
	public void SingleGetTestQueryParam() {
		//How do we add [ Query parameter ]
		String baseUrl ="https://api.escuelajs.co/";
		String endPoint= "api/v1/products/{id}";
		
		int productId = 109;
		
		 RestAssured.given().baseUri(baseUrl)
		.basePath(endPoint)
		
		.pathParam("id", productId)
		.queryParam("category", "shirts")
		.when()
		.log().all()
		.get()
		 .then()
		 .log().all()
		 .statusCode(200);
		
		
		
}
	@Test
	@Disabled
	public void SingleGetTestHeader() {
		//How do we add [ Header ]
		Header header =new Header("X-SUB", "ehp");//add in console
		String baseUrl ="https://api.escuelajs.co/";
		String endPoint= "api/v1/products/{id}";//base Path
		
		int productId = 109;
		
		 RestAssured.given().baseUri(baseUrl)
		.basePath(endPoint)
		
		.pathParam("id", productId)
		.queryParam("category", "shirts")
		.header(header)
		//.headers(null)
		.auth().preemptive().basic("userName", "passWord")
		.when()
		.log().all()
		.get()
		 .then()
		 .log().all()
		 .statusCode(200);
		
		
		
}
	@Test
	//@Disabled
	public void SingleGetDataFindOut() {
		/*
		 * Find out the how many Test Data we have 
		 *  Then call the Data Base ,if we have access / Or API call
		 *  find List of this Data Structure
		 *  Then we will take [ Random / Specific ] data.
		 */
		Header header =new Header("X-SUB", "ehp");//add in console
		String baseUrl ="https://api.escuelajs.co/";
		String endPoint= "api/v1/products/{id}";
		
		int productId = 109; //At last we will find Specific Data
		
		 RestAssured.given().baseUri(baseUrl)
		.basePath(endPoint)
		
		.pathParam("id", productId)
		.queryParam("category", "shirts")
		.header(header)
		//.headers(null)
		.auth().preemptive().basic("userName", "passWord")
		.when()
		.log().all()
		.get()
		 .then()
		 .log().all()
		 .statusCode(200);
		
		/*
		 * make sure existing data matches
		 */
		
}
}



