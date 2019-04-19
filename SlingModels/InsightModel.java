package com.ttn.blogs.core.models;

import com.ttn.blogs.core.InsightBean;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

@Model(adaptables= Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class InsightModel {
//    protected static final String RESOURCE_TYPE = "ttn_blogs/components/content/Insights";
    
    @Inject
    private List<InsightBean> field;
    
    public List<InsightBean> getList() {
        return field;
    }
    
}