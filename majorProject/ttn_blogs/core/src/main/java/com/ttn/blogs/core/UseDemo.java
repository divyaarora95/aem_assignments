package com.ttn.blogs.core;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.scripting.sightly.pojo.Use;
import javax.script.Bindings;

public class UseDemo implements Use {
    ValueMap properties;
    @Override
    public void init(Bindings bindings) {
        properties = (ValueMap)bindings.get("properties");
    }
    
    public String getSample(){
        return properties.get("title").toString();
    }
    
    public ValueMap getProperties() {
        return properties;
    }
    
}