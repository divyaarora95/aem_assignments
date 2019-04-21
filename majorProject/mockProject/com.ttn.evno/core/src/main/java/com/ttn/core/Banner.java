package com.ttn.core;

import com.adobe.cq.sightly.WCMUsePojo;

public class Banner extends WCMUsePojo {
    String link;
    
    
    @Override
    public void activate() throws Exception {
        link =getResource().getValueMap().get("link").toString();
    
    }
    public String getLink() {
        return linkValidate(link);
    }
    
    public String linkValidate(String loginLink){
        String correctLink="";
        
        //internal link
        if(loginLink.startsWith("/content")){
            if (loginLink.endsWith("html")){
                correctLink=loginLink;
                return correctLink;
            }
            else{
                correctLink=loginLink+".html";
            }
        }
        //external link
        else{
            if (loginLink.startsWith("https://") || loginLink.startsWith("http://")) {
                correctLink=loginLink;
                return correctLink;
            } else if (loginLink.startsWith("www")) {
                correctLink = "https://" + loginLink;
                return correctLink;
            }
        }
        return correctLink;
    }
}

