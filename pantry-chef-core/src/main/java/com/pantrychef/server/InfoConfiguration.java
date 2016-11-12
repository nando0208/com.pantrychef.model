package com.pantrychef.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import java.time.ZoneId;
import java.util.Properties;

/**
 */
@Configuration
public class InfoConfiguration {


    @Autowired
    public void setInfoProperties(ConfigurableEnvironment env) {
    /* These properties will show up in the Spring Boot Actuator /info endpoint */
        Properties props = new Properties();

        props.put("info.version", getVersion());
        props.put("info.timezone", ZoneId.systemDefault().toString());

        env.getPropertySources().addFirst(new PropertiesPropertySource("extra-info-props", props));
    }

    private String getVersion(){
        String version = null;

        Package aPackage = getClass().getPackage();
        if (aPackage != null) {
            version = aPackage.getImplementationVersion();
            if (version == null) {
                version = aPackage.getSpecificationVersion();
            }
        }

        if (version == null) {
            version = "";
        }

        return version;
    }
}
