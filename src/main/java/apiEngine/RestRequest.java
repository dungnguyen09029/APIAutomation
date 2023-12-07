package apiEngine;

import data.GlobalHeader;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.util.Map;

public class RestRequest extends EndPoints {

    private String endPoint;
    private Method method; // GET, POST...
    private Map<String, String> header;

    private final RequestSpecification httpRequest;

    public RestRequest() {
        RestAssured.baseURI = baseUrl;
        httpRequest = RestAssured.given();
        buildHeader(GlobalHeader.HEADER.CONTENT_TYPE.getHeaderName(), GlobalHeader.HEADER.CONTENT_TYPE.getHeaderValue());
    }

    public void initializeRequest(String endPoint, Method method) {
        this.endPoint = endPoint;
        this.method = method;
    }

    public Response buildMethod() {
        Response response;
        switch (method) {
            case GET:
                response = httpRequest.get(endPoint);
                break;
            case POST:
                response = httpRequest.post(endPoint);
                break;
            default:
                throw new RuntimeException("The method is not defined");
        }
        return response;
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
