package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

public class APIJsonUtils {

    /**
     * build the request param with only 1 left node
     * */
    public JSONObject buildJSONParam(String name, String value) {
        JSONObject requestParams = new JSONObject();
        requestParams.put(name, value);
        return requestParams;
    }

    /**
     * build the request param with multiple value but all is only left node or only 1 layer
     * */
    public JSONObject buildJSONParam(Map<String, String> pairKeyValue) {
        JSONObject requestParams = new JSONObject();
        requestParams.putAll(pairKeyValue);
        return requestParams;
    }

    /**
     * Deserialize the response to a specific class. The response must contain only left node.
     * It will deserialize all the body response start from root node. Suppose that the response contain
     * only left node.
     * For example of response body with only left node
     *  {
     *       "isbn": "9781449337711",
     *       "title": "Designing Evolvable Web APIs with ASP.NET",
     *       "subtitle": "Harnessing the Power of the Web",
     *  }
     * */
    public <T> T deserializeClass(Response response, Class<T> tClass) {
        return response.getBody().as(tClass);
    }

    /**
     * Deserialize the response with specific json path to a class.
     * @param jsonPath the jsonPath expression
     * @param tClass the model class
     * @return T return a model class represent for object that specific by json path
     * */
    public <T> T deserializeClassWithJsonPath(String jsonPath, Response response, Class<T> tClass) {
        JsonPath jsonPathEvaluator = response.jsonPath();
        // Read all the books as a List of String. Each item in the list
        // represent a book node in the REST service Response
        return jsonPathEvaluator.getObject(jsonPath, tClass);
    }

    /**
     * Deserialize the response with specific json path to a class.
     * @param jsonPath the jsonPath expression
     * @param tClass the model class
     * @return List</T> return a list of model class
     * */
    public <T> List<T> deserializeClassesWithJsonPath(String jsonPath, Response response, Class<T> tClass) {
        JsonPath jsonPathEvaluator = response.jsonPath();
        // Read all the books as a List of String. Each item in the list
        // represent a book node in the REST service Response
        return jsonPathEvaluator.getList(jsonPath, tClass);
    }

    /**
     * Deserialize the response with specific json path and return a list of object
     * @param jsonPath the jsonPath expression
     * @return List</T> return a list of model class
     * */
    public <T> List<T> deserializeDataWithJsonPath(String jsonPath, Response response) {
        JsonPath jsonPathEvaluator = response.jsonPath();
        return jsonPathEvaluator.getList(jsonPath);
    }

    /**
     * Convert class object to Json string object. This method is for logging only
     * @param obj class object
     * */
    public <T> String fromClassToString(Object obj) {
        // for logging only

        // this will print json string with pretty format, like below
//        {
//            "lastname" :"Brown",
//            "totalprice" :111,
//        }
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String json = null;
//        try {
//            json = ow.writeValueAsString(obj);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }

        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            // Convert the object to JSON string
            json = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * Change data of json field at 1st level
     * @param json json string
     * @param field field name
     * @param value value of field
     * */
    public <T> String changeJsonFields(Object json, String field, T value) {
        ObjectMapper objectMapper = new ObjectMapper();
        String modifiedJson = null;

        try {
            // Convert the object to JSON string
            String parseJson = objectMapper.writeValueAsString(json);

            // Parse the JSON string into a JsonNode
            JsonNode rootNode = objectMapper.readTree(parseJson);

            // check if the node has field has same name, only 1st level
            if (rootNode.has(field)) {
                if (value instanceof String)
                    ((ObjectNode) rootNode).put(field, (String) value);
                else if (value instanceof Integer)
                    ((ObjectNode) rootNode).put(field, (Integer) value);
                else if (value instanceof Boolean)
                    ((ObjectNode) rootNode).put(field, (Boolean) value);
            }

            // Convert the modified JsonNode back to JSON string
            modifiedJson = objectMapper.writeValueAsString(rootNode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return modifiedJson;
    }

}
