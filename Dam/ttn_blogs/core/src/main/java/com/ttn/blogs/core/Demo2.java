package com.ttn.blogs.core;

import com.adobe.cq.sightly.WCMUsePojo;

public class Demo2 extends WCMUsePojo {
    String test;
    
    @Override
    public void activate() throws Exception {
        test = get("parameter", String.class);
    }
    
    public String getSample(){
        return test;
    }
    
}