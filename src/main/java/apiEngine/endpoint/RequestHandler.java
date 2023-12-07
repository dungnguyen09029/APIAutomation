package apiEngine.endpoint;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.util.Map;

public class RequestHandler extends EndPoints {

    private String endPoint;
    private Method method; // GET, POST...
    private Map<String, String> header;

    private RequestSpecification httpRequest;

    public void initializeRequest(String endPoint, Method method) {
        this.endPoint = endPoint;
        // http or https
        this.method = method;
        RestAssured.baseURI = baseUrl;
        httpRequest = RestAssured.given();
    }

    public Response buildMethod() {
        switch (method) {
            case GET:
                return httpRequest.get(endPoint);
            case POST:
                return httpRequest.post(endPoint);
            default:
                throw new RuntimeException("The method is not defined");
        }
//        return httpRequest.request(Method.valueOf(method), path);
    }

    public void buildHeaders(Map<String, String> headers) {
        httpRequest.queryParams(headers);
    }

    public void buildHeader(String headerName, String headerValue) {
        httpRequest.header(headerName, headerValue);
    }

    public void buildParam(String paramName, String paramValue) {
        httpRequest.queryParams(paramName, paramValue);
    }

    public void buildBody(JSONObject body) {
        httpRequest.body(body.toJSONString());
    }

    public void buildBody(Object tClass) {
        httpRequest.body(tClass);
    }
}
