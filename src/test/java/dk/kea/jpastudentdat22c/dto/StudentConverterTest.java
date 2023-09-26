package dk.kea.jpastudentdat22c.dto;

import dk.kea.jpastudentdat22c.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StudentConverterTest {

    @Autowired
    StudentConverter studentConverter;

    //Arrange
    StudentDTO studentDTOTest = new StudentDTO(
            42,
            "Neia",
            LocalDate.of(1999, 12, 12),
            LocalTime.of(12, 12, 12)
    );

    Student studentTest = new Student(
            42,
            "Neia",
            LocalDate.of(1999, 12, 12),
            LocalTime.of(12, 12, 12)
    );

    @Test
    void toEntityTest() {
        //Act
        Student resultStudent = studentConverter.toEntity(studentDTOTest);

        //Assert
       assertEquals(studentDTOTest.id(), resultStudent.getId());

    }

    @Test
    void studentToDTO() {
        //Act
        StudentDTO resultStudentDTO = studentConverter.studentToDTO(studentTest);

        //Assert
        assertEquals(studentTest.getId(), resultStudentDTO.id() );

    }
/*
    @Test
    void dtoToStudent() {
    }

 */


}