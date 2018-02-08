package com.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private static PropertyReader reader = new PropertyReader();
    private Properties properties;
    public PropertyReader(){
        try
        {
            properties = new Properties();
            InputStream stream = getClass().getClassLoader().getResourceAsStream(AutomationConstants.PROP_NAME);
            properties.load(stream);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Properties getProperties()
    {
        return this.properties;
    }

    public static PropertyReader getReader() {
        return reader;
    }
}
