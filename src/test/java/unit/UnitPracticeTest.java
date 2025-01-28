package unit;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import utils.Configuration;
import utils.ConstantKey;

public class UnitPracticeTest {   // extends Object
	//practice  for Java coding challenge
	@Test
	@Disabled
	public void constantKey() { // This  name() method come from (Super class)Object class
		ConstantKey.BASE_URL.name(); 
		System.out.println(ConstantKey.values() );
		System.out.println(ConstantKey.BASE_URL.name() );
		ConstantKey[] keys=ConstantKey.values();
		for(ConstantKey s :keys) {
		//	System.out.println(s);
		System.out.println(s.toString());
		}
		System.out.println(ConstantKey.BASE_URL.getKey());
	}
	@Test
	@Disabled
	
	
	public String fullNameOfTheDog() {
		String firstName ="Tasnim";
		String lastName ="Tasnim";
		// next line is example of local variable
		// Why it is called local variable
		// because this is inside a method
		String fullName = firstName + " " + lastName;
		System.out.println("The name of the dog is: " + fullName);
		return fullName;
	}
	@Test
	@Disabled
	public void configuration() {
		Configuration configuration = new Configuration();
	System.out.println(configuration.getUrl());
	
		
	}
@Test
@Disabled
public void stringSplitTest(){
	
	String endPoint = "api/users/{id}/accounts/{accountId}";

	String [] arr = endPoint.split("/");
	for(String s :arr) {
		System.out.println(s);
	}
	}
	@Test
	@Disabled
	public void stringSplitTest01(){
		String endPoint = "api/users/{id}/accounts/{accountId}";
		String [] arr = endPoint.split("/");
		for(String s :arr) {
			
				if (s.startsWith("{") && s.endsWith("}")) {
				System.out.println(s);
			}
		}
}
	@Test
	@Disabled
	public void stringSplitTest02(){
		String endPoint = "api/users/{id}/accounts/{accountId}/";
		String [] arr = endPoint.split("/");
		List<String> params = new ArrayList<String>();
		
		for(String s :arr) {
			
				if (s.startsWith("{") &&  s.endsWith("}")) {
					
					params.add(s.replaceAll("", ""));
					
			System.out.println(s.replaceAll("[^A-Za-z0-9]",""));
			}
		}
}
	@Test
	@Disabled
	public void RegTest() {
		String string = "abcdefg12345!@#$%$%";
		System.out.println(string.replaceAll("\\d", ""));
		System.out.println(string.replaceAll("\\D", ""));
		System.out.println(string.replaceAll("[^0-9]", ""));
		System.out.println(string.toUpperCase().replaceAll("[^A-Z]", ""));
		System.out.println(string.toLowerCase().replaceAll("[^a-z]", ""));
		
	}
	
	@Test
	@Disabled
	// High Level Of Java Coding Challenge
	public void stringRegTest() {
		String string = "abcdefg12345!@#$%$%";
		System.out.println(parseStringOnly(string));
		}
	/**
	 * Java Doc
	 * This parseStringOnly() parse string char from mixed string, number, whiteSpace 
	 * @param input String with any char
	 * @return only string char
	 */
	public  String parseStringOnly(String input) {
		
		return input.toUpperCase().replaceAll("[^A-Z]", "");
	}
}
