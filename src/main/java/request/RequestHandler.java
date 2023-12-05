package request;

import data.GlobalVariables;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.util.Map;

public class RequestHandler {

    private String baseUrl;
    private String path;
    private Method method; // GET, POST...
    private Map<String, String> header;

    private RequestSpecification httpRequest;

    public RequestHandler(String baseURl, String path, String protocol, Method method) {
        initializeRequest(baseURl, path, protocol, method);
    }

    private void initializeRequest(String baseURl, String path, String protocol, Method method) {
        this.path = path;
        // http or https
        this.method = method;
        this.baseUrl = protocol + GlobalVariables.BASE_URL_PREFIX + baseURl;
        RestAssured.baseURI = baseUrl;
        httpRequest = RestAssured.given();
    }

    public Response buildMethod() {
        switch (method) {
            case GET:
                return httpRequest.get(path);
            case POST:
                return httpRequest.post(path);
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
