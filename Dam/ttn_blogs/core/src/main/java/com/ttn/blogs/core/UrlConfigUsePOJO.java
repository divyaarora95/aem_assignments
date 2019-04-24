package com.ttn.blogs.core;

import com.adobe.cq.sightly.WCMUsePojo;

public class UrlConfigUsePOJO extends WCMUsePojo {
    public String url;
    @Override
    public void activate() throws Exception {
        MySimpleService mySimpleService = getSlingScriptHelper().getService(MySimpleService.class);
        url = mySimpleService.myServiceMethod();
    }
    
    public String getUrl(){
        return url;
    }
}
