package Service;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Student Class Configuration", description = "Configuration for student class")
public @interface StudConfiguration {
    String configValue() default "default config Value";
}
