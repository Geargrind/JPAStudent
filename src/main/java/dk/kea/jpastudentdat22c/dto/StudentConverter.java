package dk.kea.jpastudentdat22c.dto;

import dk.kea.jpastudentdat22c.model.Student;

public class StudentConverter {
    public static StudentDTO studentToDTO(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getBornDate(),
                student.getBornTime()
        );
    }

    public static Student dtoToStudent(StudentDTO studentDTO) {
        return new Student(
                studentDTO.getName(),
                studentDTO.getBornDate(),
                studentDTO.getBornTime()
        );
    }
}
