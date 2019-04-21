package com.ttn.core;

public class HeaderBean {
    private String navTitle;
    private String navLink;
    
    public HeaderBean(String navTitle, String navLink) {
        this.navTitle = navTitle;
        this.navLink = navLink;
    }
    
    public String getNavLink() {
        return navLink;
    }
    
    public String getNavTitle() {
        return navTitle;
    }
}
