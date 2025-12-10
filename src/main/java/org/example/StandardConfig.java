package org.example;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class StandardConfig {
    private static StandardConfig instance;
    private Configuration configuration;

    private StandardConfig(){
        Configurations configurations = new Configurations();
        try {
            configuration = configurations.properties("config.properties");
        } catch (ConfigurationException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }

    public static StandardConfig getInstance(){
        if(instance == null)
            instance = new StandardConfig();

        return instance;
    }

    public String getProps(String key){
        return configuration.getString(key);
    }
}
