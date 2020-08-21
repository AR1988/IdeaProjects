import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;
import org.junit.Test;
import utils.Utils;
import utils.jsonDtos.PhoneJSon;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestPhone extends Utils {
    private int contactId;

    @Test
    public void test001_addPhone() throws IOException {
        createContact("no Money", "no", "Future", token);
        contactId = getLastContact(token).getInt("id");

        postRequest = new HttpPost(phoneBaseUrl);

        postRequest.setHeader("Authorization", "Bearer " + token);
        postRequest.setHeader("Content-type", "application/json");

        PhoneJSon phoneJSon = new PhoneJSon("0176", "789456", contactId);
        StringEntity entity = new StringEntity(phoneJSon.toString());
        System.out.println(phoneJSon.toString());
        postRequest.setHeader("Content-type", "application/json");
        postRequest.setEntity(entity);

        response = client.execute(postRequest);

        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void test002_getPhone() throws IOException {
        JSONObject jsonObject = getContactById(contactId, token);
        System.out.println(jsonObject);
    }

}
