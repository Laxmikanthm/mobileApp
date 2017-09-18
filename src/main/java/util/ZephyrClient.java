package util;
import com.thed.zephyr.cloud.rest.client.JwtGenerator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.ITestResult;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static util.JWTGenerator.GET;
import static util.JWTGenerator.POST;
import static util.JWTGenerator.PUT;

/**
 * Created by test-user on 8/21/17.
 */
public class ZephyrClient {

    private static String API_CREATE_CYCLE = JWTGenerator.zephyrBaseUrl+"/public/rest/api/1.0/cycle?expand=&clonedCycleId=";
    private static String API_ADD_TESTS = JWTGenerator.zephyrBaseUrl+"/public/rest/api/1.0/executions/add/cycle/";
    private static String API_GET_EXECUTIONS = JWTGenerator.zephyrBaseUrl+"/public/rest/api/1.0/executions/search/cycle/";
    private static String API_UPDATE_EXECUTION = JWTGenerator.zephyrBaseUrl+"/public/rest/api/1.0/execution/";
    private static String API_GETALLCycles_CYCLE=JWTGenerator.zephyrBaseUrl+"/public/rest/api/1.0/cycles/search?";
    static String projectId, versionId;

    public ZephyrClient(String projectId, String versioId){
        this.projectId = projectId;
        this.versionId = versioId;
    }

    public static String createCycle(String name) throws URISyntaxException, JSONException {

        JSONObject createCycleObj = new JSONObject();
        createCycleObj.put("name", name);
        createCycleObj.put("description", "automation");
        createCycleObj.put("startDate", System.currentTimeMillis());
        createCycleObj.put("projectId", projectId);
        createCycleObj.put("versionId", versionId);

        StringEntity cycleJSON = null;
        try {
            cycleJSON = new StringEntity(createCycleObj.toString());
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }

        HttpResponse response = POST(API_CREATE_CYCLE, cycleJSON);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        String cycleId = "-1";
        if (statusCode >= 200 && statusCode < 300) {
            HttpEntity entity = response.getEntity();
            try {
                JSONObject cycleObj = new JSONObject(EntityUtils.toString(entity));
                cycleId = cycleObj.getString("id");
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {
                throw new ClientProtocolException("Unexpected response status: " + statusCode);
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            }
        }
        return cycleId;
    }


    public static void addTestsToCycle(String cycleId,String cloneCycleId) throws URISyntaxException, JSONException {

        final String addTestsUri = API_ADD_TESTS + cycleId;

        JSONObject addTestsObj = new JSONObject();
        addTestsObj.put("fromVersionId", versionId);
        addTestsObj.put("method", "3");
        addTestsObj.put("projectId", projectId);
        addTestsObj.put("versionId", versionId);
        addTestsObj.put("fromCycleId", cloneCycleId);

        StringEntity addTestsJSON = null;
        try {
            addTestsJSON = new StringEntity(addTestsObj.toString());
            addTestsJSON.setContentType("application/json");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }

        HttpResponse response = POST(addTestsUri, addTestsJSON);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        String temp = null;
        if (statusCode >= 200 && statusCode < 300) {
            HttpEntity entity = response.getEntity();
            try {
                temp = EntityUtils.toString(entity);
                System.out.println(temp);
                org.json.JSONObject cycleObj = new org.json.JSONObject(entity);
                System.out.println(cycleObj.toString());
                System.out.println("Tests added Successfully");

            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                throw new ClientProtocolException("Unexpected response status: " + statusCode);
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            }
        }
    }

    public static Map<String, List<String>> getExecutionsByCycleId(String cycleId) throws URISyntaxException, JSONException {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        final String getExecutionsUri = API_GET_EXECUTIONS + cycleId + "?projectId=" + projectId + "&versionId=" + versionId;
        HttpResponse response = GET(getExecutionsUri);
        int statusCode = response.getStatusLine().getStatusCode();

        if (statusCode >= 200 && statusCode < 300) {
            HttpEntity entity = response.getEntity();
            String obj = null;
            try {
                obj = EntityUtils.toString(entity);
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject allIssues = new JSONObject(obj);
            JSONArray IssuesArray = allIssues.getJSONArray("searchObjectList");
            if (IssuesArray.length() == 0) {
                return map;
            }
            for (int j = 0; j <= IssuesArray.length() - 1; j++) {
                JSONObject jobj1 = IssuesArray.getJSONObject(j);
                JSONObject jobj2 = jobj1.getJSONObject("execution");
                String executionId = jobj2.getString("id");
                long IssueId = jobj2.getLong("issueId");
                String testId = jobj1.getString("issueKey");
                List<String> valSet = new ArrayList<String>();
                valSet.add(executionId);
                valSet.add(String.valueOf(IssueId));
                map.put(testId, valSet);
                System.out.println("Execution id: "+executionId);
            }
        }
        return map;
    }

    public static String updateExecutions(List<String> ids, String cycleId, ITestResult result) throws URISyntaxException, JSONException, IOException {

        final String updateExecutionUri =  API_UPDATE_EXECUTION + ids.get(0);
        JSONObject statusObj = new JSONObject();
        if(result.getStatus()==1) {
            statusObj.put("id", "1");
        }
        else if (result.getStatus()==2)
        {
            statusObj.put("id",2);
        }
        else if(result.getStatus()==3)
        {
            statusObj.put("id",3);
        }

        JSONObject executeTestsObj = new JSONObject();
        executeTestsObj.put("status", statusObj);
        executeTestsObj.put("cycleId", cycleId);
        executeTestsObj.put("projectId", projectId);
        executeTestsObj.put("versionId", versionId);
        executeTestsObj.put("comment", "Executed by ZAPI Cloud");
        executeTestsObj.put("issueId", ids.get(1));
        // System.out.println(executeTestsObj.toString());
        StringEntity executeTestsJSON = null;
        try {
            executeTestsJSON = new StringEntity(executeTestsObj.toString());
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        HttpResponse response = PUT(updateExecutionUri, executeTestsJSON);
        int statusCode = response.getStatusLine().getStatusCode();
        // System.out.println(statusCode);
        String executionStatus = "No Test Executed";
        // System.out.println(response.toString());
        HttpEntity entity = response.getEntity();

        if (statusCode >= 200 && statusCode < 300) {
            String string = null;
            try {
                string = EntityUtils.toString(entity);
                JSONObject executionResponseObj = new JSONObject(string);
                JSONObject descriptionResponseObj = executionResponseObj.getJSONObject("execution");
                JSONObject statusResponseObj = descriptionResponseObj.getJSONObject("status");
                executionStatus = statusResponseObj.getString("description");
                System.out.println(executionResponseObj.get("issueKey") + "--" + executionStatus);
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {

            try {
                String string = null;
                string = EntityUtils.toString(entity);
                JSONObject executionResponseObj = new JSONObject(string);
                cycleId = executionResponseObj.getString("clientMessage");
                // System.out.println(executionResponseObj.toString());
                throw new ClientProtocolException("Unexpected response status: " + statusCode);

            } catch (ClientProtocolException e) {
                e.printStackTrace();
            }
        }
        return executionStatus;
    }

    public static String getAllCycle(String cycleName)throws URISyntaxException ,JSONException {
        String cycleId="null";
        final String ExecutionUri = API_GETALLCycles_CYCLE + "versionId=" + versionId + "&projectId=" + projectId;
        HttpResponse response = GET(ExecutionUri);
        int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode >= 200 && statusCode < 300) {
                HttpEntity entity = response.getEntity();
                String obj = null;
                try {
                    obj = EntityUtils.toString(entity);
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JSONArray allIssues = new JSONArray(obj);
                for (int j = 0; j <= allIssues.length() - 1; j++) {
                    JSONObject jobj1 = allIssues.getJSONObject(j);
                    String name=jobj1.getString("name");
                    if(name.equals(cycleName))
                    {
                         cycleId=jobj1.getString("cycleIndex");
                         j=allIssues.length()-1;
                    }

                }
        }
        return cycleId;
    }

    public static void main(String[] args) throws Exception {
        DateFormat dateFormatee = new SimpleDateFormat("yyyy-MMM-dd-HH_mm");
        Date date = new Date();
        ZephyrClient jwt = new ZephyrClient("10001", "10401");
        String cycleID = jwt.createCycle("Automation cycle - "+dateFormatee.format(date));
        //jwt.addTestsToCycle(cycleID);
        Map<String, List<String>> map = jwt.getExecutionsByCycleId(cycleID);
       /* jwt.updateExecutions(map.get("DFA-9188"), cycleID);
        jwt.updateExecutions(map.get("DFA-5306"), cycleID);*/
    }
}
