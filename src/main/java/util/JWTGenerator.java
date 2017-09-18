package util;

import com.thed.zephyr.cloud.rest.ZFJCloudRestClient;
import com.thed.zephyr.cloud.rest.client.JwtGenerator;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by test-user on 7/26/17.
 */
public class JWTGenerator {
    final static String accessKey = "amlyYTpjMWVmNDdlNC1iNjgxLTQzNWUtYWY5My1iYzRhNjQ3ZWZjN2Igc3VqaXQucGFsdWt1cnUgVVNFUl9ERUZBVUxUX05BTUU";
    //String accessKey = "amlyYTpjMWVmNDdlNC1iNjgxLTQzNWUtYWY5My1iYzRhNjQ3ZWZjN2IgZGlhc19wIFVTRVJfREVGQVVMVF9OQU1F";
    final static String zephyrBaseUrl = "https://prod-api.zephyr4jiracloud.com/connect";
    final static String secretKey = "oYEeTMpkO1666Kjr8FiQXUnJgR8935RkIUIk9W6LuB0";
    //String secretKey = "UmfONd4-1diPzns3VpcqGnA-aDAAyvaY8gTwA-su3uo";
    final static String userName = "sujit.palukuru";
    public static ZFJCloudRestClient client = ZFJCloudRestClient.restBuilder(zephyrBaseUrl, accessKey, secretKey, userName).build();


    public static HttpResponse GET(String url) throws URISyntaxException {
        URI uri = new URI(url);
        int expirationInSec = 300;
        JwtGenerator jwtGenerator = client.getJwtGenerator();
        String jwt = jwtGenerator.generateJWT("GET", uri, expirationInSec);
        // Print the URL and JWT token to be used for making the REST call
        System.out.println("FINAL API : " +uri.toString());
        System.out.println("JWT Token : " +jwt);

        HttpResponse response = null;
        HttpClient restClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(uri);
      //  httpGet.setHeader("Content-Type","application/json");
        httpGet.setHeader("Authorization", jwt);
        httpGet.setHeader("zapiAccessKey", accessKey);

        try {
            response = restClient.execute(httpGet);
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return response;
    }


    public static HttpResponse POST(String uriStr, StringEntity entityJSON) throws URISyntaxException {
        URI uri = new URI(uriStr);
        int expirationInSec = 300;
        JwtGenerator jwtGenerator = client.getJwtGenerator();
        String jwt = jwtGenerator.generateJWT("POST", uri, expirationInSec);
        System.out.println("FINAL API : " +uri.toString());
        System.out.println("JWT Token : " +jwt);

        HttpResponse response = null;
        HttpClient restClient = new DefaultHttpClient();

        HttpPost createCycleReq = new HttpPost(uri);
        createCycleReq.addHeader("Content-Type", "application/json");
        createCycleReq.addHeader("Authorization", jwt);
        createCycleReq.addHeader("zapiAccessKey", accessKey);
        createCycleReq.setEntity(entityJSON);

        try {
            response = restClient.execute(createCycleReq);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static HttpResponse PUT(String uriStr, StringEntity executionJSON) throws URISyntaxException {
        URI uri = new URI(uriStr);
        int expirationInSec = 300;
        JwtGenerator jwtGenerator = client.getJwtGenerator();
        String jwt = jwtGenerator.generateJWT("PUT", uri, expirationInSec);
        System.out.println(uri.toString());
        System.out.println(jwt);

        HttpResponse response = null;
        HttpClient restClient = new DefaultHttpClient();

        HttpPut executeTest = new HttpPut(uri);
        executeTest.addHeader("Content-Type", "application/json");
        executeTest.addHeader("Authorization", jwt);
        executeTest.addHeader("zapiAccessKey", accessKey);
        executeTest.setEntity(executionJSON);

        try {
            response = restClient.execute(executeTest);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static HttpResponse getLifeCycle(String url)throws URISyntaxException
    {
        URI uri = new URI(url);
        int expirationInSec = 300;
        JwtGenerator jwtGenerator = client.getJwtGenerator();
        String jwt = jwtGenerator.generateJWT("Get", uri, expirationInSec);
        System.out.println("FINAL API : " +uri.toString());
        System.out.println("JWT Token : " +jwt);

        HttpResponse response = null;
        HttpClient restClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(uri);
        httpGet.addHeader("Content-Type", "application/json");
        httpGet.setHeader("Authorization", jwt);
        httpGet.setHeader("zapiAccessKey", accessKey);


        try {
            response = restClient.execute(httpGet);
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return response;

    }

}
