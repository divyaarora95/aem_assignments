package Service;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Student Configuration", description = "Configuration for student class")
public @interface MyConfiguration {

    @AttributeDefinition(name = "Maximum Students", description = "Number of students allowed")
    int maxStudentCount() default 20;

    @AttributeDefinition(name = "Passing Marks", description = "Marks required to pass")
    int passingMarks() default 75;
    
}
