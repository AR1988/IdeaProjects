import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import utils.Utils;
import utils.jsonDtos.UserJSon;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUserController extends Utils {

    @Test
    public void test001_createUser1_returnOk() throws IOException {
        postRequest = new HttpPost(userBaseEP);
        UserJSon userJSon = new UserJSon(USER_NAME_1, USER_PASS_1);

        logger.info("Request body : " + userJSon.toString());

        StringEntity entity = new StringEntity(userJSon.toString());
        postRequest.setHeader("Content-type", "application/json");
        postRequest.setEntity(entity);

        response = client.execute(postRequest);

        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void test002_createUser2_returnOk() throws IOException {
        postRequest = new HttpPost(userBaseEP);
        UserJSon userJSon = new UserJSon(USER_NAME_2, USER_PASS_2);

        StringEntity entity = new StringEntity(userJSon.toString());
        postRequest.setHeader("Content-type", "application/json");
        postRequest.setEntity(entity);

        logger.info("Request body : " + userJSon.toString());

        response = client.execute(postRequest);

        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void test003_createUser3_returnOk() throws IOException {
        postRequest = new HttpPost(userBaseEP);
        UserJSon userJSon = new UserJSon(USER_NAME_3, USER_PASS_3);

        logger.info("Request body : " + userJSon.toString());

        StringEntity entity = new StringEntity(userJSon.toString());
        postRequest.setHeader("Content-type", "application/json");
        postRequest.setEntity(entity);

        logger.info("Request body : " + userJSon.toString());

        response = client.execute(postRequest);

        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void test004_createUserUser1Exist_return400() throws IOException {
        postRequest = new HttpPost(userBaseEP);
        UserJSon userJSon = new UserJSon(USER_NAME_1, USER_PASS_1);

        logger.info("Request body - user 1 : " + userJSon.toString());

        StringEntity entity = new StringEntity(userJSon.toString());
        postRequest.setHeader("Content-type", "application/json");
        postRequest.setEntity(entity);

        logger.info("Request body - try create user 1 : " + userJSon.toString());

        response = client.execute(postRequest);

        HttpEntity responseEntity = response.getEntity();
        String responseString = EntityUtils.toString(responseEntity, "UTF-8");

        logger.info("Response body : " + responseString);

        assertTrue(responseString.contains("Error! User already exists"));
        assertEquals(response.getStatusLine().getStatusCode(), 400);
    }

    @Test
    public void test005_getJWTokenLogin() throws IOException {
        postRequest = new HttpPost(login);
        UserJSon userJSon = new UserJSon(USER_NAME_1, USER_PASS_1);

        HttpClientContext context = HttpClientContext.create();
        StringEntity entity = new StringEntity(userJSon.toString());
        postRequest.setHeader("Content-type", "application/json");
        postRequest.setEntity(entity);

        response = client.execute(postRequest, context);

        assertEquals(getToken(USER_NAME_1, USER_PASS_1), context.getCookieStore().getCookies().get(0).getValue());
        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void test006_getUser1_returnOkAndUserEmail() throws IOException {
        getRequest = new HttpGet(userGetEp);
        getRequest.setHeader("Authorization", "Bearer " + getToken(USER_NAME_1, USER_PASS_1));
        getRequest.setHeader("Content-type", "application/json");

        response = client.execute(getRequest);

        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");

        logger.info("Response body : " + responseString);

        assertTrue(responseString.contains("email\":\"newUser1@gmail.com"));
        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void test007_deleteUser1_returnOk() throws IOException {
        deleteRequest = new HttpDelete(userBaseEP);
        deleteRequest.setHeader("Authorization", "Bearer " + getToken(USER_NAME_1, USER_PASS_1));
        deleteRequest.setHeader("Content-type", "application/json");

        response = client.execute(deleteRequest);

        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void test008_getUserWithoutToken_return401() throws IOException {
        getRequest = new HttpGet(userGetEp);
        getRequest.setHeader("Content-type", "application/json");

        response = client.execute(getRequest);
        HttpEntity responseEntity = response.getEntity();
        String responseString = EntityUtils.toString(responseEntity, "UTF-8");

        logger.info("Response body : " + responseString);

        assertTrue(responseString.contains("message\":\"Unauthorized"));
        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_UNAUTHORIZED);
    }

    @Test
    public void test009_getUser2_return200() throws IOException {
        getRequest = new HttpGet(userGetEp);
        getRequest.setHeader("Authorization", "Bearer " + getToken(USER_NAME_2, USER_PASS_2));
        getRequest.setHeader("Content-type", "application/json");

        response = client.execute(getRequest);

        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");

        logger.info("Response body : " + responseString);

        assertTrue(responseString.contains("email\":\"newUser2@gmail.com"));
        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void test010_getUser3_return200() throws IOException {
        getRequest = new HttpGet(userGetEp);
        getRequest.setHeader("Authorization", "Bearer " + getToken(USER_NAME_3, USER_PASS_3));
        getRequest.setHeader("Content-type", "application/json");

        response = client.execute(getRequest);

        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");

        logger.info("Response body : " + responseString);

        assertTrue(responseString.contains("email\":\"newUser3@gmail.com"));
        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void test011_deleteUser3AndTryGetUser3_returnOk() throws IOException {
        String token = getToken(USER_NAME_3, USER_PASS_3);

        deleteRequest = new HttpDelete(userBaseEP);
        deleteRequest.setHeader("Authorization", "Bearer " + token);
        deleteRequest.setHeader("Content-type", "application/json");

        response = client.execute(deleteRequest);

        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

        getRequest = new HttpGet(userGetEp);
        getRequest.setHeader("Authorization", "Bearer " + token);
        getRequest.setHeader("Content-type", "application/json");

        response = client.execute(getRequest);
        HttpEntity responseEntity = response.getEntity();
        String responseString = EntityUtils.toString(responseEntity, "UTF-8");

        logger.info("Response body : " + responseString);

        assertTrue(responseString.contains("message\":\"Unauthorized"));
        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_UNAUTHORIZED);
    }

    @Test
    public void test012_deleteUser2AndTryGetUser2_returnOk() throws IOException {
        String token = getToken(USER_NAME_2, USER_PASS_2);

        deleteRequest = new HttpDelete(userBaseEP);
        deleteRequest.setHeader("Authorization", "Bearer " + token);
        deleteRequest.setHeader("Content-type", "application/json");

        response = client.execute(deleteRequest);

        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

        getRequest = new HttpGet(userGetEp);
        getRequest.setHeader("Authorization", "Bearer " + token);
        getRequest.setHeader("Content-type", "application/json");

        response = client.execute(getRequest);
        HttpEntity responseEntity = response.getEntity();
        String responseString = EntityUtils.toString(responseEntity, "UTF-8");

        logger.info("Response body : " + responseString);

        assertTrue(responseString.contains("message\":\"Unauthorized"));
        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_UNAUTHORIZED);
    }
}
