package com.ttn.blogs.core;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Service for External LInks", description = "this config will work for external links")
public @interface ServiceConfiguration {
    @AttributeDefinition(name = "url value", description = "valid url path", type = AttributeType.STRING)
    String urlConfig() default "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js";
}
