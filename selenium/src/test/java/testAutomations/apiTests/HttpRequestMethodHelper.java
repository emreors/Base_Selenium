package testAutomations.apiTests;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * Created by Emre ÖRS
 * Date 10.01.2022
 */

public class HttpRequestMethodHelper {
    public static CloseableHttpResponse sendGetRequest(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        return httpClient.execute(request);
    }

    public static CloseableHttpResponse sendPostRequest(String url, String body) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        post.addHeader("content-type", "application/json");
        post.setEntity(new StringEntity(body));
        return httpClient.execute(post);
    }

}

