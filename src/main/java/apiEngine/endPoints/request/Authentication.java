package apiEngine.endPoints.request;

import apiEngine.endPoints.IRestResponse;
import apiEngine.endPoints.RestRequest;
import apiEngine.endPoints.RestResponse;
import apiEngine.endPoints.Routes;
import apiEngine.model.requests.Auth;
import apiEngine.model.responses.Token;
import io.restassured.http.Method;

public class Authentication extends RestRequest {

    public <T> IRestResponse<Token> sentAuthentication(Auth auth) {
        String endPoint = Routes.auth();
        initializeRequest(endPoint, Method.POST);
        buildBody(auth);
        return new RestResponse(Token.class, buildMethod());
    }
}
