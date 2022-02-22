package testAutomations.apiTests;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Emre ÖRS
 * Date 10.01.2022
 */

public class apiTestGetByName {
    @Test
    public void testGroceryByName200() throws IOException {
        String get200 = "http://localhost:8080/allGrocery/apple";
        String expectedResult = "{\"data\":[{" +
                "\"id\":1," +
                "\"name\":\"apple\"," +
                "\"price\":3," +
                "\"stock\":100" +
                "}]}";

        CloseableHttpResponse response = HttpRequestMethodHelper.sendGetRequest(get200);

        //HttpResponse Durum
        assertEquals(200, response.getStatusLine().getStatusCode());

        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String result = EntityUtils.toString(entity);
            assertEquals(expectedResult, result);
            System.out.println("Response Status :" + response.getStatusLine().getStatusCode());   // 200 400 404 vb.
            System.out.println(result);
        }
    }

    @Test
    public void testGroceryByName404() throws IOException {
        String get404 = "http://localhost:8080/allGrocery/appele";
        String expectedResult = "{\"data\":null," +
                "\"error\":\"Parameter name should be given as valid grocery name\"" + "}";

        CloseableHttpResponse response = HttpRequestMethodHelper.sendGetRequest(get404);

        //HttpResponse Durum
        assertEquals(404, response.getStatusLine().getStatusCode());

        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String result = EntityUtils.toString(entity);
            assertEquals(expectedResult, result);
            System.out.println("Response Status :" + response.getStatusLine().getStatusCode());   // 200 400 404 vb.
            System.out.println(result);
        }
    }
}
