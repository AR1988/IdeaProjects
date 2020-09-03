import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import utils.Utils;
import utils.jsonDtos.ContactJson;

import java.io.IOException;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestContactController extends Utils {

    @BeforeClass
    public static void init() throws IOException {
        token = createTestUserAndGetToken(USER_NAME_1, USER_PASS_1);
    }

    @Test
    public void test001_createEmptyContact() throws IOException {
        postRequest = new HttpPost(contactEP);
        postRequest.setHeader("Authorization", "Bearer " + token);
        postRequest.setHeader("Content-type", "application/json");
        ContactJson contactJSon = new ContactJson("Ich",
                "Wiess",
                "Nicht");

        logger.info("Request body : " + contactJSon.toString());

        StringEntity entity = new StringEntity(contactJSon.toString());
        postRequest.setEntity(entity);
        response = client.execute(postRequest);

        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void test002_getContactById_contactNotFoundByUser() throws IOException {
        int contactId = 1;

        getRequest = new HttpGet(contactEP + "/" + contactId);
        getRequest.setHeader("Authorization", "Bearer " + token);
        getRequest.setHeader("Content-type", "application/json");
        response = client.execute(getRequest);

        JSONObject jsonObj = getJson(response);

        logger.info("Response body : " + jsonObj);

        if (!jsonObj.has("message") && jsonObj.has("id")) {
            ContactJson contactJson = new ContactJson();
            logger.info(contactJson.fromJson(jsonObj));
            logger.warning("Maybe this user exist this contact. Contact id: " + contactJson.getId());
            fail("Check this contact in DB. Contact id: " + contactJson.getId());
        } else {
            assertEquals("Error! This contact doesn't exist in our DB", jsonObj.get("message"));
        }

        assertEquals(response.getStatusLine().getStatusCode(), 400);
    }

    @Test
    public void test003_getContactByIdExtended_contactNotFoundByUser() throws IOException {
        int contactId = 1;

        getRequest = new HttpGet(contactEP + "/" + contactId);
        getRequest.setHeader("Authorization", "Bearer " + token);
        getRequest.setHeader("Content-type", "application/json");

        response = client.execute(getRequest);

        JSONObject jsonObj = getJson(response);

        logger.info("Response body : " + jsonObj);
        if (!jsonObj.has("message") && jsonObj.has("id")) {
            ContactJson contactJson = new ContactJson();
            logger.info(contactJson.toString());
            logger.warning("Maybe this user exist this contact. Contact id: " + contactJson.getId());
            fail("Check this contact in DB. Contact id: \"" + contactJson.getId() + "\" or start test again");
        } else {
            assertEquals("Error! This contact doesn't exist in our DB", jsonObj.get("message"));
        }
        assertEquals(response.getStatusLine().getStatusCode(), 400);
    }


    @Test
    public void test004_getLast() throws IOException {
        String contactName = "Das ist";
        String contactLastName = "Alte";
        String contactDescription = "Contact";

        createContact(contactName, contactLastName, contactDescription, token);

        getRequest = new HttpGet(getLastContactEP);
        getRequest.setHeader("Authorization", "Bearer " + token);
        getRequest.setHeader("Content-type", "application/json");

        response = client.execute(getRequest);

        JSONObject jsonObj = getJson(response);

        int contactId = jsonObj.getInt("id");
        logger.info("Response body : " + jsonObj
                + "\nContact id: " + contactId);

        assertTrue(contactId > 0);
        assertEquals(jsonObj.getString("firstName"), contactName);
        assertEquals(jsonObj.getString("lastName"), contactLastName);
        assertEquals(jsonObj.getString("description"), contactDescription);
        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void test005_editContact() throws IOException {

        String contactName = "Contact Name";
        String contactLastName = "Contact Last Name";
        String contactDescription = "Contact Description";
        // create new Contact
        createContact(contactName, contactLastName, contactDescription, token);
        //Get last created contact by Token
        JSONObject responseLastContactJSon = getLastContact(token);

        int contactId = responseLastContactJSon.getInt("id");

        logger.info("Contact before edit: " + responseLastContactJSon + "\nContact id: " + contactId);
        //check contact
        assertEquals(responseLastContactJSon.getString("firstName"), contactName);
        assertEquals(responseLastContactJSon.getInt("id"), contactId);
        assertEquals(responseLastContactJSon.getString("lastName"), contactLastName);
        assertEquals(responseLastContactJSon.getString("description"), contactDescription);
        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        //Update Contact
        String contactNewName = "Bin";
        String contactNewLastName = "wuerklich";
        String contactNewDescription = "aktualisiert";

        putRequest = new HttpPut(contactEP);
        putRequest.setHeader("Authorization", "Bearer " + token);
        putRequest.setHeader("Content-type", "application/json");
        //Update contact details
        ContactJson contactJSon = new ContactJson(contactId,
                contactNewName,
                contactNewLastName,
                contactNewDescription);
        StringEntity entity = new StringEntity(contactJSon.toString());
        putRequest.setEntity(entity);
        response = client.execute(putRequest);
        //Get response. Contact after edit
        JSONObject responseEditedJsonObj = getContactById(contactId, token);

        logger.info("Contact after update : " + responseEditedJsonObj);
        //check updated contact
        assertEquals(responseEditedJsonObj.getInt("id"), contactId);
        assertEquals(responseEditedJsonObj.getString("firstName"), contactNewName);
        assertEquals(responseEditedJsonObj.getString("lastName"), contactNewLastName);
        assertEquals(responseEditedJsonObj.getString("description"), contactNewDescription);
        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void test006_removeContact() throws IOException {
        createContact("is", "mir", "egal", token);
        JSONObject responseLastContactJSon = getLastContact(token);

        int contactId = responseLastContactJSon.getInt("id");

        logger.info("contact id: " + contactId);

        deleteRequest = new HttpDelete(contactEP + "/" + contactId);
        deleteRequest.setHeader("Authorization", "Bearer " + token);
        deleteRequest.setHeader("Content-type", "application/json");
        response = client.execute(deleteRequest);

        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

        JSONObject jsonGetById = getContactById(contactId, token);

        String message = "";
        try {
            message = jsonGetById.getString("message");

        } catch (JSONException ex) {
            logger.info("No expected error message found. Test fail!"
                    + "\nMessage : " + message);
            logger.info("Message : " + message);
            fail("contact not removed");
        }

        assertEquals("Error! This contact doesn't exist in our DB", message);
    }

    @Test
    public void test007_getAllContactByUser() throws IOException {

        getRequest = new HttpGet(contactEP + "/count");
        getRequest.setHeader("Authorization", "Bearer " + token);
        getRequest.setHeader("Content-type", "application/json");
        response = client.execute(getRequest);
        HttpEntity entityContacts = response.getEntity();
        String responseStringContactsSize = EntityUtils.toString(entityContacts, "UTF-8");
        int contactsSize = Integer.parseInt(responseStringContactsSize);

        assertTrue(contactsSize > 0);

        logger.info("Actual user id: " + USER_NAME_1);
        logger.info("Contacts by user : " + contactsSize);

        getRequest = new HttpGet(contactEP + "/all");
        getRequest.setHeader("Authorization", "Bearer " + token);
        getRequest.setHeader("Content-type", "application/json");
        response = client.execute(getRequest);

        JSONArray jsonArray = getJsonArray(response);

        logger.info("Response body : " + jsonArray);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Contacts:").append("\n");
        for (Object jsonObj : jsonArray)
            stringBuilder.append(jsonObj).append("\n");
        logger.info(stringBuilder.toString());

        assertEquals(contactsSize, jsonArray.length());
        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void test007_getContactByUserInvalidToken_() throws IOException {

        getRequest = new HttpGet(contactEP + "/count");
        getRequest.setHeader("Authorization", "Bearer " + token);
        getRequest.setHeader("Content-type", "application/json");
        response = client.execute(getRequest);
        HttpEntity entityContacts = response.getEntity();
        String responseStringContactsSize = EntityUtils.toString(entityContacts, "UTF-8");
        int contactsSize = Integer.parseInt(responseStringContactsSize);

        logger.info("Contacts by user : " + contactsSize);

        getRequest = new HttpGet(contactEP + "/all");
        getRequest.setHeader("Authorization", "Bearer " + token);
        getRequest.setHeader("Content-type", "application/json");
        response = client.execute(getRequest);

        JSONArray jsonArray = getJsonArray(response);

        logger.info("Response body : " + jsonArray);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Contacts:").append("\n");
        for (Object jsonObj : jsonArray)
            stringBuilder.append(jsonObj).append("\n");
        logger.info(stringBuilder.toString());

        assertEquals(contactsSize, jsonArray.length());
        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }
}

