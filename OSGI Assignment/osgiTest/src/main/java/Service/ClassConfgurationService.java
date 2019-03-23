//Create service ClassConfigurationService that allows two configuration :
//
//No. of students allowed in the class
//
//marks required by the student to pass the class
//
//also it exposes two methods :
package Service;

import java.util.List;

public interface ClassConfgurationService {

    Boolean isClassLimitReached(List<Student> list);
    int getPassingMarks(MyConfiguration myConfiguration);
}
