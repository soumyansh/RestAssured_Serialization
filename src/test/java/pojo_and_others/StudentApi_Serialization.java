package pojo_and_others;

import java.util.ArrayList;
import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class StudentApi_Serialization {

	@Test(priority = 1)
	public void createNewStudentSerialization() {
		ArrayList<String> coursesList = new ArrayList<String>();
		coursesList.add("Java");
		coursesList.add("Selenium");

		Student stu = new Student();
		stu.setId(101);
		stu.setCourses(coursesList);
		stu.setEmail("abc@gmail.com");
		stu.setFirstName("Pavan");
		stu.setLastName("Kumar");
		stu.setProgramme("Manager");

		given().contentType(ContentType.JSON).body(stu).when().post("http://localhost:8080/student").then().assertThat()
				.statusCode(201);

		

	}

	@Test(priority = 2)
	public void getStudentRecord_Deserialization() {
		Student stu = new Student();
		stu = given().get("http://localhost:8080/student/101").as(Student.class);
		System.out.println(stu.getStudentRecord());
	}

}
