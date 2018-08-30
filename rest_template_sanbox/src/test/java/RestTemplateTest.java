import org.json.JSONObject;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class RestTemplateTest {

    private String url = "http://gturnquist-quoters.cfapps.io/api/random";

    @Test
    public void basicGetString() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        assertNotNull(response);
    }

    @Test
    public void basicGetResponseEntity() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void ParseJSONResponse() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        JSONObject result = new JSONObject(response.getBody());
        String type = result.getString("type");
        JSONObject value = result.getJSONObject("value");
        int id = value.getInt("id");
        String quote = value.getString("quote");

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(type, "success");
        assertNotNull(id);
        assertNotNull(quote);
    }



}
