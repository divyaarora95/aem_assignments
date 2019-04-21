package com.ttn.blogs.core;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true, service = MySimpleService.class)
@Designate(ocd = ServiceConfiguration.class)
public class SimpleServiceImplementation implements MySimpleService{
    String configUrl;
    private Logger logger = LoggerFactory.getLogger("implementation of My service");
    
    @Activate
    @Modified
    public void activate(ServiceConfiguration myServiceConfiguration){
        configUrl = myServiceConfiguration.urlConfig();
    }
    
    @Override
    public String myServiceMethod() {
        return configUrl;
    }
}
