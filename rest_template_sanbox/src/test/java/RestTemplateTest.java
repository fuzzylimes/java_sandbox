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

}
