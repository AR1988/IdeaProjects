import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import utils.Utils;
import utils.jsonDtos.PhoneJSon;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPhone extends Utils {

    private static int contactId;

    @BeforeClass
    public static void init() throws IOException {
        token = createTestUserAndGetToken(USER_NAME_1, USER_PASS_1);
    }

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

        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

}
