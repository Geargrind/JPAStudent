package dk.kea.jpastudentdat22c.controller;

import dk.kea.jpastudentdat22c.dto.StudentConverter;
import dk.kea.jpastudentdat22c.dto.StudentDTO;
import dk.kea.jpastudentdat22c.model.Student;
import dk.kea.jpastudentdat22c.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentConverter studentConverter;

    @GetMapping("/")
    public List<StudentDTO> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        studentList.forEach(s -> {
            studentDTOList.add(studentConverter.studentToDTO(s));
        });
        for (Student s : studentList) {
            studentDTOList.add(studentConverter.studentToDTO(s));
        }
        return studentDTOList;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody StudentDTO studentDTO) {
        Student student = studentConverter.toEntity(studentDTO);

        student.setId(0);
        System.out.println(student);
        return (studentRepository.save(student));
    }

    @GetMapping("/students/{name}")
    public List<Student> getAllStudentsByName(@PathVariable String name) {
        return studentRepository.findAllByName(name);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable int id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return ResponseEntity.ok(studentConverter.studentToDTO(optionalStudent.get()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
/*
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        Student s = studentRepository.findById(id).get();
        s.setName(student.getName());
        s.setBornDate(student.getBornDate());
        s.setBornTime(student.getBornTime());
        studentRepository.save(s);
        return s;
    }

 */

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDTO> putStudent(@PathVariable int id, @RequestBody StudentDTO studentDTO) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = studentConverter.toEntity(studentDTO);
            student.setId(id);
            studentRepository.save(student);
            return ResponseEntity.ok(studentConverter.studentToDTO(student));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            studentRepository.delete(optionalStudent.get());
            return ResponseEntity.status(HttpStatus.OK).body("Student with id " + id + " was deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with id " + id + " was not found");
        }
    }
}