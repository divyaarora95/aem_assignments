package com.ttn.core;

import com.adobe.cq.sightly.WCMUsePojo;
import org.apache.sling.api.resource.Resource;

import java.util.ArrayList;
import java.util.List;

public class FollowUsUsePojo extends WCMUsePojo {
    List<FollowUsComp> list=new ArrayList<>();
    @Override
    public void activate() throws Exception {
        for(Resource resource:getResource().getChild("followuscomp").getChildren()){
            list.add(new FollowUsComp(resource.getValueMap().get("followuspath",String.class),resource.getValueMap().get("logoimage",String.class)));
            
        }
    }
    public List<FollowUsComp> getFollowComponent(){
        return list;
    }
}