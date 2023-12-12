package cucumber;

import enums.Context;
import testData.TestDataManager;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    // scenario data test saved here
    private Map<String, Object> scenarioContext;
    private TestDataManager testDataManager;

    public ScenarioContext(){
        scenarioContext = new HashMap<String, Object>();
        testDataManager = new TestDataManager();
    }

    public void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(Context key){
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(Context key){
        return scenarioContext.containsKey(key.toString());
    }

    public TestDataManager getTestDataManager() {
        return testDataManager;
    }
}
