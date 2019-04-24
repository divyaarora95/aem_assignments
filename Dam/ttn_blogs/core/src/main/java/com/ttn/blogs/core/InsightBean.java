package com.ttn.blogs.core;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class InsightBean {
    @Inject
    private String title;
    @Inject
    private String subtitles;
    @Inject
    private String imageLink;
    @Inject
    private String pageLink;
    
    public String getTitle() {
        return title;
    }
    
    public String getSubtitles() {
        return subtitles;
    }
    
    public String getImageLink() {
        return imageLink;
    }
    
    public String getPageLink() {
        return pageLink;
    }
    
    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
    
}
