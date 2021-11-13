package pojo_and_others;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class Basic {

	public static void main(String[] args) {
		String body = Payload.body;
		RestAssured.baseURI = "https://www.rahulshettyacademy.com/";
		String resp = given().body(body).queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).extract().asString();
		System.out.println(resp);
		JsonPath js=new JsonPath(resp);
		System.out.println(js.getString("status"));
//		
//		RequestSpecification req = new RequestSpecBuilder().setContentType(ContentType.JSON)
//				.setBaseUri("https://www.rahulshettyacademy.com/")
//				.addQueryParam("key", "qaclick123")
//				.build();
//		String resp=given().spec(req).body(Payload.body).when().post("/maps/api/place/add/json").then().assertThat().statusCode(200)
//		.extract().response().asString();
//		System.out.println(resp);
//		ResponseSpecification res2 = new ResponseSpecBuilder().build();
	}

}
