package dk.kea.jpastudentdat22c.repository;

import dk.kea.jpastudentdat22c.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;

    @BeforeEach
    void init() {
        Student s1 = new Student(
                42,
                "Tim",
                LocalDate.of(1999, 12, 12),
                LocalTime.of(12, 12, 12)
        );
        Student s2 = new Student(
                43,
                "Poul",
                LocalDate.of(1999, 12, 12),
                LocalTime.of(12, 12, 12)
        );

        studentRepository.save(s2);
        studentRepository.save(s1);


    }

    @Test
    void testFindByName() {
        List<Student> studentList = studentRepository.findAllByName("Tim");
        assertEquals(1, studentList.size());
    }

    @Test
    void findAllByName() {
        //Act
        List<Student> studentList = studentRepository.findAll();
        //Assert
        assertEquals(2, studentList.size());
        assertThat(studentList, containsInAnyOrder(
                hasProperty("name", is("Poul")),
                hasProperty("name", is("Tim"))
        ));
    }
}