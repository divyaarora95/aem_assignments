package Service;

import java.util.List;

public interface StudentClassService {
    String addStudent(Student student);
    
    String deleteStudent(int id);
    
    boolean isStudentPassed(int id);
    
    Student getStudent(int id);
    
    List<Student> getAllStudents();
    
}
