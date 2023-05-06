package starter.product;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.LoginForAuth;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateCommentProduct {
    public String ValidEndpointCreateCommentProduct = "https://altashop-api.fly.dev/api/products/2/comments";
    public String InvalidEndpointCreateCommentProduct = "https://altashop-api.fly.dev/api/products/2/comment";

    @Step("user set POST valid endpoint for create comment product")
    public String setPostValidEndpointForCreateCommentProduct(){
        return ValidEndpointCreateCommentProduct;
    }

    @Step("user send POST HTTP request with valid endpoint for create comment product")
    public void sendPOSTHTTPRequestForCreateCommentProduct(){
        String body = "{ \"content\":\"the games are great including Gran Turismo 7 but sadly GT4 is much better\"}";

        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + LoginForAuth.token).contentType("application/json").body(reqBody.toString()).post(setPostValidEndpointForCreateCommentProduct());
    }

    @Step("user received HTTP response code 200 for create comment product")
    public void validateHTTPResponseCode200ForCreateCommentProduct(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("user set POST endpoint with invalid endpoint for create comment product")
    public String setPostEndpointWithInvalidEndpointForCreateCommentProduct(){
        return InvalidEndpointCreateCommentProduct;
    }

    @Step("user send POST HTTP request with invalid endpoint for create comment product")
    public void sendPOSTHTTPRequestWithInvalidEndpointForCreateCommentProduct(){
        String body = "{ \"content\":\"the games are great including Gran Turismo 7 but sadly GT4 is much better\"}";

        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + LoginForAuth.token).contentType("application/json").body(reqBody.toString()).post(setPostEndpointWithInvalidEndpointForCreateCommentProduct());
    }

    @Step("user received HTTP response code 404 with invalid endpoint for create comment product")
    public void validateHTTPResponseCode404WithInvalidEndpointForCreateCommentProduct(){
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("user send POST HTTP request with empty request body for create comment product")
    public void sendPOSTHTTPRequestWithEmptyRequestBodyForCreateCommentProduct(){
        String body = "{ }";

        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + LoginForAuth.token).contentType("application/json").body(reqBody.toString()).post(setPostValidEndpointForCreateCommentProduct());
    }

    @Step("user received HTTP response code 500 Internal Server Error with empty request body for create comment product")
    public void validateHTTPResponseCode500InternalServerErrorWithEmptyRequestBodyForCreateCommentProduct(){
        restAssuredThat(response -> response.statusCode(500));
    }
}
