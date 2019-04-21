package com.ttn.core;

import com.adobe.cq.sightly.WCMUsePojo;
import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Header extends WCMUsePojo {
    protected final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    private List<HeaderBean> desendantList = new ArrayList<>();
    private List<HeaderBean> headerlist = new ArrayList<>();
    
    @Override
    public void activate() throws Exception {
        for (Resource resource : getResource().getChild("field").getChildren()) {
            headerlist.add(new HeaderBean(resource.getValueMap().get("menuText", String.class), resource.getValueMap().get("menuLink", String.class)));
        }
    }
    
    public List<HeaderBean> getBeanItems() {
        return headerlist;
    }
    
}