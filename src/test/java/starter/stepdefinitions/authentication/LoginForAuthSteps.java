package starter.stepdefinitions.authentication;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.LoginForAuth;

public class LoginForAuthSteps {
    @Steps
    LoginForAuth loginForAuth;
    @Given("User set authentication endpoint")
    public void userSetAuthenticationEndpoint() {
        loginForAuth.userSetAuthenticationEndpoint();
    }

    @And("User send authentication endpoint")
    public void userSendAuthenticationEndpoint() {
        loginForAuth.sendAuthenticationEndpoint();
    }
}
