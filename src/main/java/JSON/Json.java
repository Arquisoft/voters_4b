package JSON;
import org.json.*;

public class Json {
	private JSONObject message;
	
	public Json(String user , String password){
		message = new JSONObject();
		message.put("user", user);
		message.put("password", password);
	}
	
	public  JSONObject getJson(){
		return message;
	}
	
	/*JSONObject json = new JSONObject();
	json.put("someKey", "someValue");    

	CloseableHttpClient httpClient = HttpClientBuilder.create().build();

	try {
	    HttpPost request = new HttpPost("http://yoururl");
	    StringEntity params = new StringEntity(json.toString());
	    request.addHeader("content-type", "application/json");
	    request.setEntity(params);
	    httpClient.execute(request);
	// handle response here...
	} catch (Exception ex) {
	    // handle exception here
	} finally {
	    httpClient.close();
	}*/
}
