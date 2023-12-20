package cucumber;

import enums.Context;
import testData.DataManager;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    // scenario data test saved here
    private Map<String, Object> scenarioContext;
    private DataManager dataManager;

    public ScenarioContext(){
        scenarioContext = new HashMap<>();
        dataManager = new DataManager();
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

    public DataManager getDataManager() {
        return dataManager;
    }
}
