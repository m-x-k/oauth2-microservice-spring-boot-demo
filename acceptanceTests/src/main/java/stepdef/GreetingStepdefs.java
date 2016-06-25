package stepdef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GreetingStepdefs {

    private static String token = "";
    private static String greetingUrl = "http://localhost:8080/greeting";

    private HttpResponse response;

    @Given("^I am logged in$")
    public void login() throws Throwable {
        token = "PLEASE ADD GITHUB TOKEN";
    }

    @Given("^I am not logged in$")
    public void notLoggedIn() throws Throwable {
        token = "";
    }

    @And("^I call the greeting resource$")
    public void callGreetingResource() throws Throwable {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(greetingUrl);
        get.addHeader(new BasicHeader("Authorization", "Bearer " + token));
        response = client.execute(get);
    }

    public static void main(String[] args) throws Throwable {
        GreetingStepdefs greetingStepdefs = new GreetingStepdefs();
        greetingStepdefs.callGreetingResource();
    }

    @Then("^I am returned a successful greeting response$")
    public void checkSuccessfulGreetingResponse() throws Throwable {
        assertEquals(200, response.getStatusLine().getStatusCode());
        String json = EntityUtils.toString(response.getEntity(), "UTF-8");
        com.google.gson.Gson gson = new com.google.gson.Gson();
        Map greetingResponse = gson.fromJson(json, HashMap.class);
        assertEquals("hello", greetingResponse.get("first"));
        assertEquals("world", greetingResponse.get("second"));
    }

    @Then("^I am returned an unsuccessful response$")
    public void checkUnSuccessfulGreetingResponse() throws Throwable {
        assertEquals(401, response.getStatusLine().getStatusCode());
    }


}
