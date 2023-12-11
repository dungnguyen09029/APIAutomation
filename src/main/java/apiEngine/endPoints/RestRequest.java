package apiEngine.endPoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import enums.Header;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import utilities.Log;

import java.util.Map;

public class RestRequest extends BaseEndPoints {

    private String endPoint;
    private Method method; // GET, POST...
    private Map<String, String> header;

    private final RequestSpecification request;

    public RestRequest() {
        RestAssured.baseURI = baseUrl;
        request = RestAssured.given();
        Log.logInfo("Create rest assured request object");
        buildHeader(Header.CONTENT_TYPE.getHeaderName(), Header.CONTENT_TYPE.getHeaderValue());
    }

    public void initializeRequest(String endPoint, Method method) {
        this.endPoint = endPoint;
        this.method = method;
        Log.logInfo("Request End Point: " + endPoint);
        Log.logInfo("Request method: " + method);
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
        Log.logInfo("Request is sent............");
        return response;
    }

    public void buildHeaders(Map<String, String> headers) {
        request.queryParams(headers);
    }

    public void buildHeader(String headerName, String headerValue) {
        request.header(headerName, headerValue);
        Log.logInfo(String.format("New header - %s - %s", headerName, headerValue));
    }

    public void buildParam(String paramName, String paramValue) {
        request.queryParams(paramName, paramValue);
    }

    public void buildBody(JSONObject body) {
        Log.logInfo(body.toJSONString());
        request.body(body.toJSONString());
    }

    public void buildBody(Object tClass) {
        request.body(tClass);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = null;
        try {
            json = ow.writeValueAsString(tClass);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Log.logInfo("Request body: \n" + json);
    }
}
