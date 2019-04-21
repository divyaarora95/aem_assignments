package com.ttn.core;

public class FollowUsComp {
    
    
    String followuspath;
    String logoimage;
    
    public FollowUsComp(String followuspath,String logoimage){
        
        this.logoimage=logoimage;
        this.followuspath=followuspath;
    }
    
    public String getFollowuspath() {
        return followuspath;
    }
    
    public void setFollowuspath(String followuspath) {
        this.followuspath = followuspath;
    }
    
    public String getLogoimage() {
        return logoimage;
    }
    
    public void setLogoimage(String logoimage) {
        this.logoimage = logoimage;
    }
}