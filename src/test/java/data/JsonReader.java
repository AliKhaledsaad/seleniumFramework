package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {

	public String gender;
	public String fname;
	public String lname;
	public String email;
	public String password;
	public  void getJsonData() throws IOException, ParseException
	{
		String filePath = System.getProperty("user.dir")+"/src/test/java/data/userData.json";
		try {
		File srcFile = new File(filePath);
		JSONParser parser = new JSONParser();
		JSONArray array =(JSONArray)parser.parse(new FileReader(srcFile));
		
		for(Object jsonObject : array)
		{
			JSONObject obj =(JSONObject)jsonObject;
			 gender = (String) obj.get("gender");
			 fname=(String)obj.get("firstname");
			 lname=(String)obj.get("lastname");
			 email=(String)obj.get("email");
			 password=(String)obj.get("passwrod");
			
		}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Cant Find Json File : "+e.getMessage());
		}
		
		
	}
}
