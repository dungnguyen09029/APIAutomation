package apiEngine.endPoints;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import utilities.Log;

public class RestResponse<T> implements IRestResponse<T> {

    private T data;
    private Response response;
    private Exception e;

    public RestResponse(Class<T> t, Response response) {
        this.response = response;
        try{
            this.data = t.getDeclaredConstructor().newInstance();
        }catch (Exception e){
            throw new RuntimeException("There should be a default constructor in the Response POJO");
        }
    }

    public String getContent() {
        String body = response.getBody().asString();
        Log.logInfo("Response Body: " + body);
        return body;
    }

    public int getStatusCode() {
        int statusCode = response.getStatusCode();
        Log.logInfo("Response Status Code is: " + statusCode);
        return statusCode;
    }

    public boolean isSuccessful() {
        int code = response.getStatusCode();
        if( code == 200 || code == 201 || code == 202 || code == 203 || code == 204 || code == 205) return true;
        return false;
    }

    public String getStatusDescription() {
        return response.getStatusLine();
    }

    public Response getResponse() {
        return response;
    }


    public T getBody() {
        try {
            data = (T) response.getBody().as(data.getClass());
        }catch (Exception e) {
            this.e=e;
        }
        String body = response.getBody().asString();
        Log.logInfo("Response Body: " + body);
        return data;
    }

    public Exception getException() {
        Log.logInfo("Exception is: " + e);
        return e;
    }


    /**
     * Return a value of specific header. For example: Accepted = application/json
     * If the headerName is Accepted. Then it's return the value application/json
     * @param headerName
     * */
    public String getSingleHeaderValue(String headerName) {
        return response.getHeader(headerName);
    }

    /**
     * Get all headers as an instance of Headers class. Loop through it by using for(Header header : allHeaders)
     * */
    public Headers getAllHeaders() {
        Headers allHeaders = response.headers();
        // Iterate over all the Headers
        for(Header header : allHeaders)
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        return allHeaders;
    }

    /**
     * Return the JSON body as a plain string
     * */
    public String getBodyAsString() {
        return response.getBody().asString();
    }

    /**
     * The node path should be in the format of JSON path. For example: $.store.book[0].title.
     * Specified by JsonPath: City (Note: You should not put $. in the Java code).
     * Thus, the correct path should be store.book[0].title
     * https://support.smartbear.com/alertsite/docs/monitors/api/endpoint/jsonpath.html
     * @param nodePath the node path of Json evaluation. Note that it should not contain the $. at the beginning
     * */
    public String getBodyNodeValue(String nodePath) {
        return response.jsonPath().get(nodePath);
    }

    /**
     * Return the status line of response. For example: HTTP 200 OK
     * OK is the status line
     * */
    public String getStatusLine() {
        String statusLine = response.getStatusLine();
        Log.logInfo("Response status line: " + statusLine);
        return statusLine;
    }

}