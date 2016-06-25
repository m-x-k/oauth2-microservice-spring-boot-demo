package stepdef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GreetingStepdefs {

    private String loginUrl = "https://github.com/login/oauth/authorize";
    private String tokenUrl = "https://github.com/login/oauth/access_token";
    private String username = "username";
    private String password = "password";

    @Given("^I am logged in$")
    public void login() throws Throwable {
        loginRequest();
    }

    private void loginRequest() throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(loginUrl);
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
        nameValuePairs.add(new BasicNameValuePair("username", username));
        nameValuePairs.add(new BasicNameValuePair("password", password));

        post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

        // TODO enable cookies on header
        HttpResponse response = client.execute(post);
        BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

        String output;
        while((output = br.readLine()) != null) {
            // TODO complete
            System.out.println(output);
        }

        client.getConnectionManager().shutdown();
    }

    public static void main(String[] args) throws Throwable {
        GreetingStepdefs greetingStepdefs = new GreetingStepdefs();
        greetingStepdefs.login();
    }

    @Given("^I am not logged in$")
    public void notLoggedIn() throws Throwable {

    }

    @And("^I call the greeting resource$")
    public void callGreetingResource() throws Throwable {

    }

    @Then("^I am returned a successful greeting response$")
    public void checkSuccessfulGreetingResponse() throws Throwable {

    }

    @Then("^I am returned an unsuccessful response$")
    public void checkUnSuccessfulGreetingResponse() throws Throwable {

    }


}
