package pojo_and_others;

import io.restassured.path.json.JsonPath;

public class Utilities {
	
	public static JsonPath rawToJson(String response) {
		JsonPath js=new JsonPath(response);
		return js;

	}

}
