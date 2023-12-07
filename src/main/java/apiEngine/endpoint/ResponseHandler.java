package apiEngine.endpoint;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ResponseHandler {

    private final Response response;

    public ResponseHandler(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
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
     * return status code of response
     * */
    public int getStatusCode() {
        return response.getStatusCode();
    }

    /**
     * Return the status line of response. For example: HTTP 200 OK
     * OK is the status line
     * */
    public String getStatusLine() {
        return response.getStatusLine();
    }
}
