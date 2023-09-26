package dk.kea.jpastudentdat22c.dto;

import dk.kea.jpastudentdat22c.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {
    public StudentDTO studentToDTO(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getBornDate(),
                student.getBornTime()
        );
    }
/*
    public static Student dtoToStudent(StudentDTO studentDTO) {
        return new Student(
                studentDTO.id(),
                studentDTO.name(),
                studentDTO.bornDate(),
                studentDTO.bornTime()
        );
    }

 */

    public Student toEntity(StudentDTO studentDTO) {
        return new Student(
                studentDTO.id(),
                studentDTO.name(),
                studentDTO.bornDate(),
                studentDTO.bornTime()
        );
    }
}
