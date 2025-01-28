package base;

import java.util.ArrayList;
import java.util.List;

import endPoint.IEndPoint;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Configuration;

/**
 * @author EnthrallIt
 */
public abstract class RestStep  implements IEndPoint{
	RequestSpecification request;
	Response response;
Configuration configuration=new Configuration();
	/**
	 * Initializing Rest_Assured RequestSpecification {@link #request}
	 */
	public void init() {
		request = RestAssured.given();
		setBaseUrl();
	}

	public Response getResponse() {
		
		return response;
	}
	
	public void setBaseUrl() {
		request.baseUri(configuration.getUrl());
	}

	/**
	 * Set Headers of Object
	 * 
	 * @param headers {@link #Header}
	 */
	public void setHeaders(Headers headers) {
		if (headers != null) {
			request.headers(headers);
		}
	}

	/**
	 * Set Header [] to the {@link #request}
	 * 
	 * @param headerArr Array Of {@link Header}
	 */
	public void setHeader(Header... headerArr) { // Multiple Header we can add

		for (Header header : headerArr) {
			setHeader(header);
		}
	}

	public void setEndPoint(String endpoint) {

		request.basePath(endpoint);
	}

	/**
	 * Set path Param
	 * 
	 * @param endpoint API End-point
	 * @param params   path params Array
	 * @throws Exception if path param do not have same size at end-point
	 */

	public void setParams(String endpoint, Object[] params) throws Exception {
		// api/users/{id}/accounts/{accountId}"; -- // 2 params is here
		// .pathParam("id", 300) -- we have to define this way
		// .pathParam("account", 3562563)
		if (params != null) { // ( }) 92 line

			List<String> paramsName = new ArrayList<String>();
			String[] paramArr = endpoint.split("/");

			// find out the expected params from the end point
			for (String s : paramArr) {
				if (s.startsWith("{") && s.endsWith("}")) {
					paramsName.add(s.replaceAll("^A-Za-z",s));
				}
			}

			// Validate if the expected params are equal to actual params
			if (params.length != paramsName.size()) {
				throw new Exception("Give params are not matching with endPoint expected params");
			}

			// Assign the params
			int index = 0;
			for (Object param : params) {
				request.pathParam(paramsName.get(0), param);
				index++;
			}     
		} // if () this } come from 69 line
	}

	/**
	 * Build a Get API Request
	 * 
	 * @param headers       {@link Headers}
	 * @param endpoint      API End Point
	 * @param params        path params
	 * @param statusCode    expected statusCode
	 * @param statusMassage expected statusMassage
	 * @return {@link #response}
	 * @throws Exception
	 */
	public Response apiGetStep(Headers headers, String endpoint, Object[] params, int statusCode, String statusMassage)
			throws Exception {
		/*
		 * Headers EndPoint Params statusCode statusMassage
		 */
		// response=RestAssured.given().get();
		
		setHeaders(headers);
		setEndPoint(endpoint);
		setParams(endpoint, params);

		response = request.log().all().get();
		response.then().log().all();

		validateStatusCode(statusCode);
		validateStatusLine(statusMassage);
		return response;
	}
	/**
	 * Build a Get API Request
	 * 
	 * @param headers       {@link Headers}
	 * @param endpoint      API End Point
	 * @param params        path params
	 * @param statusCode    expected statusCode
	 * @param statusMassage expected statusMassage
	 * @return {@link #response}
	 * @throws Exception
	 */
	public Response apiPostStep(Headers headers, String endpoint, Object body,  Object[] params, int statusCode, String statusMassage)
			throws Exception {
		/*
		 * Headers EndPoint Params statusCode statusMassage
		 */
		// response=RestAssured.given().get();
		
		setHeaders(headers);
		setEndPoint(endpoint);
		setParams(endpoint, params);

		response = request.log().all().get();
		response.then().log().all();

		validateStatusCode(statusCode);
		validateStatusLine(statusMassage);
		return response;
	}

	public void validateStatusCode(int expectedStatusCode) {

		response.then().statusCode(expectedStatusCode);
	}

	public void validateStatusLine(String expectedLine) {
		if (expectedLine != null) {
			response.then().statusLine(expectedLine);
		}

	}

}
