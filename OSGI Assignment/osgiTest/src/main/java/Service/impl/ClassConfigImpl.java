package Service.impl;

import Service.ClassConfgurationService;
import Service.MyConfiguration;
import Service.Student;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Component(service = ClassConfgurationService.class, immediate = true)
@Designate(ocd = MyConfiguration.class)
public class ClassConfigImpl implements ClassConfgurationService {
    int MAX_STUDENT;
    int PASS_MARKS;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public Boolean isClassLimitReached(List<Student> list) {
        // System.out.println("isClassLimitReached Called!!!");
        // System.out.println(list.size());
       /* if(myConfiguration.maxStudentCount() <= list.size())
            return true;
        else*/
        return MAX_STUDENT<=list.size();
    }
    
    @Override
    public int getPassingMarks(MyConfiguration myConfiguration) {
        return PASS_MARKS;
    }
    
    @Activate
    public void activate(MyConfiguration config) {
        logger.info("\n\nClass Configuration Service Activated.\n");
        PASS_MARKS =config.passingMarks();
        MAX_STUDENT=config.maxStudentCount();
        List<Student> studentList=new ArrayList<>();
        
        studentList.add(new Student(1,"Shruti",24,85));
        studentList.add(new Student(2,"Himani", 22,95));
        studentList.add(new Student(3,"Drashti",22,35));
        studentList.add(new Student(4,"Vani", 23, 40));
        
        
        boolean classLimitReached=isClassLimitReached(studentList);
        int passingMarks = getPassingMarks(config);
        
        
        logger.info("\n\nClass Implementation: isClassLimitReached:: "+classLimitReached+" getPassingMarks:: "+passingMarks+"\n\n");

    }
}
