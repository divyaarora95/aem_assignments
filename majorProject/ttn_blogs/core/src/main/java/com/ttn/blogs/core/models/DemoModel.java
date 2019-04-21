package com.ttn.blogs.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables= Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DemoModel {
        
        @Inject @Default(values = "ab")
        private String linkPath;
        @Inject @Default(values = "xyz")
        private String linkText;
        @Inject @Default(values = "abx")
        private String link;
        
        @PostConstruct
        protected void init() {
            link = linkText+linkPath;
        }
        
        public String getLink() {
            return link;
        }
}