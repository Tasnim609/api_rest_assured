package productTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import base.RestStep;
import dataTableObject.Product;

import io.restassured.path.json.JsonPath;

public class GetProductTest  extends RestStep{
	//String endPoint = " /api/v1/products";// this call hard code 
	

	@BeforeEach
	public void testDataSetUp() {
		init();
	}
	@Test
	public void getProducts_happyPath() throws Exception {
		
		apiGetStep(null, GET_PRODUCTS, null, 200, null);//Also we can say direct response here
		
		Product[]  products = getResponse().as(Product[].class);
		//System.out.println(products[0]);
		System.out.println(products[0].getDescription());
		
		//we need deserializer found in classPath.
		//so we need Jackson or Gson in classPath
		JsonPath jPath =JsonPath.from(getResponse().asString());
		System.out.println(jPath.getString("[0].description"));
	}
}
