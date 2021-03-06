package utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.AfterClass;
import org.junit.runner.notification.RunListener;
import utils.jsonDtos.ContactJson;
import utils.jsonDtos.UserJSon;

import java.io.IOException;
import java.util.logging.Logger;

public class Utils extends RunListener {
    public static Logger logger = Logger.getLogger(Utils.class.getName());

    public static final String HOST_URL = "http://localhost:8080/";

    public static final String login = HOST_URL + "api/user/login";
    public String contactEP = HOST_URL + "api/contact/";
    public String getLastContactEP = HOST_URL + "api/contact/last";

    public static String userBaseEP = HOST_URL + "api/user";
    public String userGetEp = HOST_URL + "api/get-user";

    public String phoneBaseUrl = HOST_URL + "/api/phone";

    public static String USER_NAME_1 = "newUser1@gmail.com";
    public static String USER_PASS_1 = "user1_password";

    public String USER_NAME_2 = "newUser2@gmail.com";
    public String USER_PASS_2 = "user2_password";

    public String USER_NAME_3 = "newUser3@gmail.com";
    public String USER_PASS_3 = "user3_password";

    public static CloseableHttpClient client = HttpClientBuilder.create().build();
    ;
    public static HttpResponse response;
    public static HttpPost postRequest;
    public HttpPut putRequest;
    public HttpGet getRequest;
    public HttpDelete deleteRequest;

    public static String token = "";

    @AfterClass
    public static void clear() throws IOException {
        logger.info("\n..........................................................................\n"
                + Colors.ANSI_BG_GREEN
                + "user token: " + token
                + "\nuser removed: " + removeUser(token)
                + Colors.ANSI_RED + Colors.ANSI_BRIGHT_BG_WHITE
                + "\n..........................................................................\n");

    }

    public static String getToken(String userName, String userPassword) throws IOException {
        postRequest = new HttpPost(login);
        UserJSon userJSon = new UserJSon(userName, userPassword);

        HttpClientContext context = HttpClientContext.create();
        StringEntity entity = new StringEntity(userJSon.toString());
        postRequest.setHeader("Content-type", "application/json");
        postRequest.setEntity(entity);
        response = client.execute(postRequest, context);
        String token = context.getCookieStore().getCookies().get(0).getValue();
        logger.info("\n..........................................................................\n"
                + Colors.ANSI_BG_GREEN
                + "User : \"" + userName + "\""
                + "\nToken : " + token
                + Colors.ANSI_RED + Colors.ANSI_BRIGHT_BG_WHITE
                + "\n..........................................................................\n"
        );
        return token;
    }

    public static String createTestUserAndGetToken(String userName, String password) throws IOException {
        postRequest = new HttpPost(userBaseEP);
        UserJSon userJSon = new UserJSon(userName, password);

        StringEntity entity = new StringEntity(userJSon.toString());
        postRequest.setHeader("Content-type", "application/json");
        postRequest.setEntity(entity);
        response = client.execute(postRequest);
        return getToken(userName, password);
    }

    public JSONObject getJson(HttpResponse response) throws IOException {
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");
        return new JSONObject(responseString);
    }

    public JSONArray getJsonArray(HttpResponse response) throws IOException {
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");
        return new JSONArray(responseString);
    }

    public void createContact(String name, String lastName, String desc, String token) throws IOException {
        postRequest = new HttpPost("http://localhost:8080/api/contact/");
        postRequest.setHeader("Authorization", "Bearer " + token);
        postRequest.setHeader("Content-type", "application/json");
        ContactJson contactJSon = new ContactJson(name,
                lastName,
                desc);
        StringEntity entity = new StringEntity(contactJSon.toString());
        postRequest.setEntity(entity);
        response = client.execute(postRequest);
    }

    public JSONObject getLastContact(String token) throws IOException {
        getRequest = new HttpGet("http://localhost:8080/api/contact/last");
        getRequest.setHeader("Authorization", "Bearer " + token);
        getRequest.setHeader("Content-type", "application/json");
        response = client.execute(getRequest);
        //Read response
        HttpEntity responseEntity = response.getEntity();
        String responseString = EntityUtils.toString(responseEntity, "UTF-8");
        return new JSONObject(responseString);
    }

    public JSONObject getContactById(int id, String token) throws IOException {
        String getUrl = "http://localhost:8080/api/contact/" + id + "/extended";
        getRequest = new HttpGet(getUrl);
        getRequest.setHeader("Authorization", "Bearer " + token);
        getRequest.setHeader("Content-type", "application/json");
        response = client.execute(getRequest);
        HttpEntity responseEntity = response.getEntity();
        String responseString = EntityUtils.toString(responseEntity, "UTF-8");
        return new JSONObject(responseString);
    }

    public void getAllContactByUserName(String token) throws IOException {
        int contactsSize = getTotalContactsNumberByUser(token);

        logger.info("User : \"" + USER_NAME_1 + "\" has " + contactsSize);
        logger.info("Contacts by user : " + contactsSize);

        getRequest = new HttpGet(contactEP + "/all");
        getRequest.setHeader("Authorization", "Bearer " + token);
        getRequest.setHeader("Content-type", "application/json");
        response = client.execute(getRequest);

        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");
        JSONArray jsonArray = new JSONArray(responseString);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Contacts:").append("\n");
        for (Object jsonObj : jsonArray)
            stringBuilder.append(jsonObj).append("\n");
        logger.info(stringBuilder.toString());
    }

    public int getTotalContactsNumberByUser(String token) throws IOException {
        getRequest = new HttpGet(contactEP + "/count");
        getRequest.setHeader("Authorization", "Bearer " + token);
        getRequest.setHeader("Content-type", "application/json");
        response = client.execute(getRequest);
        HttpEntity entityContacts = response.getEntity();
        String responseStringContactsSize = EntityUtils.toString(entityContacts, "UTF-8");
        return Integer.parseInt(responseStringContactsSize);
    }

    public static boolean removeUser(String token) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpDelete deleteRequest = new HttpDelete("http://localhost:8080/api/user");
        deleteRequest.setHeader("Authorization", "Bearer " + token);
        deleteRequest.setHeader("Content-type", "application/json");

        HttpResponse response = client.execute(deleteRequest);

        return response.getStatusLine().getStatusCode() == HttpStatus.SC_OK;
    }

}
