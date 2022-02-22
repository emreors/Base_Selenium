package testAutomations.apiTests;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Emre ÖRS
 * Date 10.01.2022
 */

public class apiTestPost {
    @Test
    public void testGroceryPost200() throws IOException {
        String post200 = "http://localhost:8080/add";
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"id\":4,");
        json.append("\"name\":\"potato\",");
        json.append("\"price\":12.3,");
        json.append("\"stock\":3");
        json.append("}");

        CloseableHttpResponse response = HttpRequestMethodHelper.sendPostRequest(post200, json.toString());
        assertEquals(200, response.getStatusLine().getStatusCode());
        System.out.println("Response Status :" + response.getStatusLine().getStatusCode());   // 200 400 404 vb.
        System.out.println(json);
    }

    @Test
    public void testGroceryPost400() throws IOException {
        String post400 = "http://localhost:8080/add";
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"wrong\":4,");
        json.append("\"name\":\"potato\",");
        json.append("\"price\":12.3,");
        json.append("\"stock\":3");
        json.append("}");

        CloseableHttpResponse response = HttpRequestMethodHelper.sendPostRequest(post400, json.toString());
        assertEquals(400, response.getStatusLine().getStatusCode());
        System.out.println("Response Status :" + response.getStatusLine().getStatusCode());   // 200 400 404 vb.
        System.out.println(json);
    }

    @Test
    public void testGroceryPost404() throws IOException {
        String post404 = "http://localhost:8080/wrong";
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"id\":4,");
        json.append("\"name\":\"potato\",");
        json.append("\"price\":12.3,");
        json.append("\"stock\":3");
        json.append("}");

        CloseableHttpResponse response = HttpRequestMethodHelper.sendPostRequest(post404, json.toString());
        assertEquals(404, response.getStatusLine().getStatusCode());
        System.out.println("Response Status :" + response.getStatusLine().getStatusCode());   // 200 400 404 vb.
        System.out.println(json);

    }
}

