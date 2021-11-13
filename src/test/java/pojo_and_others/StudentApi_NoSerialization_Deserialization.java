package pojo_and_others;

import java.util.ArrayList;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class StudentApi_NoSerialization_Deserialization {

	public HashMap map = new HashMap();

	@Test(priority = 1) // Post request for new record
	public void createNewStudent() {
		map.put("id", 101);
		map.put("firstName", "Pavan");
		map.put("lastName", "Kumar");
		map.put("email", "abc@gmail.com");
		map.put("programme", "Manager");

		ArrayList<String> coursesList = new ArrayList<String>();
		coursesList.add("Java");
		coursesList.add("Selenium");

		map.put("courses", coursesList);
		
		given().log().all().contentType(ContentType.JSON)
		.body(map)
		.when().post("http://localhost:8080/student")
		.then().assertThat().statusCode(201)
		.body("msg", equalTo("Student added"));
		
		
	}
	@Test(priority=2)
	public void getStudentRecord() {
		given().log().all().when().get("http://localhost:8080/student/101")
		.then().assertThat().statusCode(200)
		.assertThat().body("id", equalTo(101));
	}

}
