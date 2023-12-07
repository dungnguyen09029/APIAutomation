package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;
    private static ConfigReader configReader;

    private ConfigReader() {
        BufferedReader reader;
        String propertyFilePath = "configs//Configuration.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public static ConfigReader getInstance( ) {
        if(configReader == null) {
            configReader = new ConfigReader();
        }
        return configReader;
    }

    public String getBaseUrl() {
        String baseUrl = properties.getProperty("base_Url");
        if(baseUrl != null) return baseUrl;
        else throw new RuntimeException("base_Url not specified in the Configuration.properties file.");
    }

    public String getProtocol() {
        String protocol = properties.getProperty("protocol");
        if(protocol != null) return protocol;
        else throw new RuntimeException("protocol not specified in the Configuration.properties file.");
    }

    public String getUrlPrefix() {
        String urlPrefix = properties.getProperty("urlPrefix");
        if(urlPrefix != null) return urlPrefix;
        else throw new RuntimeException("url_prefix not specified in the Configuration.properties file.");
    }
}
