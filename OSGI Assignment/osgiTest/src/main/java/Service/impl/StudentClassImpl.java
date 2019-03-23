package Service.impl;

import Service.MyConfiguration;
import Service.StudConfiguration;
import Service.Student;
import Service.StudentClassService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;


@Component(service = StudentClassService.class, immediate = true)
@Designate(ocd = StudConfiguration.class)
public class StudentClassImpl implements StudentClassService {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    ClassConfigImpl classConfigImpl = new ClassConfigImpl();
    List<Student> finalStudentList = new ArrayList<>();
    
    @Override
    public String addStudent(Student student) {
        if (classConfigImpl.isClassLimitReached(finalStudentList)) {
            finalStudentList.add(student);
            return "Student added::  " + student;
        } else
            return "Limit Reached, Student cannot be added";
    }
    
    @Override
    public String deleteStudent(int id) {
        if (finalStudentList.size() > 0) {
            finalStudentList.remove(finalStudentList.size() - 1);
            return "Student succesfully deleted";
        } else
            return "No student to delete";
    }
    
    @Override
    public boolean isStudentPassed(int id) {
        for (Student student : finalStudentList) {
            if (student.getId() == id) {
                if (student.getMarks() >= classConfigImpl.PASS_MARKS) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    
    @Override
    public Student getStudent(int id) {
        for (Student student : finalStudentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        
        return new Student();
    }
    
    @Override
    public List<Student> getAllStudents() {
        if (finalStudentList.size() > 0)
            return finalStudentList;
        return new ArrayList<>();
    }
    
    @Activate
    public void activateMethod(MyConfiguration myConfiguration) {
        logger.info("Student Configuration Service activated");
        
        Student student1, student2, student3, student4;
        student1 = new Student(1,"Shruti",24,85);
        student2 = new Student(2,"Himani", 22,95);
        student3 = new Student(3,"Drashti",22,35);
        student4 = new Student(4,"Vani", 23, 40);
        
        logger.info("\nStudent Implementation:\n" +
                "Adding Student 1: " + addStudent(student1) +
                "\nAdding Student 2: " + addStudent(student2) +
                "\nAdding Student 3: " + addStudent(student3) +
                "\nAdding Student 4: " + addStudent(student4) +
                "\nDeleting Last Student: " + deleteStudent(2) +
                "\nIs Student 3 Pass:" + isStudentPassed(4) +
                "\nGetting Student 1: " + getStudent(2) +
                "\nGetting All Students: " + getAllStudents() +
                "\n");
        
    }
}
