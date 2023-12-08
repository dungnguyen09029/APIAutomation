package apiEngine.endPoints;

import data.GlobalHeader;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.util.Map;

public class RestRequest extends BaseEndPoints {

    private String endPoint;
    private Method method; // GET, POST...
    private Map<String, String> header;

    private final RequestSpecification request;

    public RestRequest() {
        RestAssured.baseURI = baseUrl;
        request = RestAssured.given();
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
                response = request.get(endPoint);
                break;
            case POST:
                response = request.post(endPoint);
                break;
            default:
                throw new RuntimeException("The method is not defined");
        }
        return response;
    }

    public void buildHeaders(Map<String, String> headers) {
        request.queryParams(headers);
    }

    public void buildHeader(String headerName, String headerValue) {
        request.header(headerName, headerValue);
    }

    public void buildParam(String paramName, String paramValue) {
        request.queryParams(paramName, paramValue);
    }

    public void buildBody(JSONObject body) {
        request.body(body.toJSONString());
    }

    public void buildBody(Object tClass) {
        request.body(tClass);
    }
}
