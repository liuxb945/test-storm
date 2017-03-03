package com.abcd.test.storm.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;  
  
public final class ResourceLoader {  
  
    private static ResourceLoader loader = new ResourceLoader();  
    private static Map<String, Properties> loaderMap = new HashMap<String, Properties>();  
  
    private ResourceLoader() {  
    }  
  
    public static ResourceLoader getInstance() {  
        return loader;  
    }  
      
    public Properties getPropFromProperties(String fileName) throws Exception {  
          
        Properties prop = loaderMap.get(fileName);  
        if (prop != null) {  
            return prop;  
        }
        else{
        	prop=new Properties();
        }
  
        InputStream ips = ResourceLoader.class.getResourceAsStream(fileName);  
        BufferedReader ipss = new BufferedReader(new InputStreamReader(ips));  
        prop.load(ipss); 
  
        loaderMap.put(fileName, prop);  
        return prop;  
    }  
}
