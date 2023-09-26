package dk.kea.jpastudentdat22c.controller;

import dk.kea.jpastudentdat22c.dto.StudentDTO;
import dk.kea.jpastudentdat22c.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class StudentRestController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> studentDTOList = studentService.getAllStudents();
        return new ResponseEntity<>(studentDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO createdStudent = studentService.createStudent(studentDTO);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("id") int id) {
        StudentDTO studentDTO = studentService.getStudentById(id);
        return ResponseEntity.ok(studentDTO);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDTO> putStudent(@PathVariable int id, @RequestBody StudentDTO studentDTO) {
        StudentDTO updatedStudentDTO = studentService.updateStudent(id, studentDTO);
        return ResponseEntity.ok(updatedStudentDTO);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        studentService.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


    /*
    @GetMapping("/students/{name}")
    public List<Student> getAllStudentsByName(@PathVariable String name) {
        return studentRepository.findAllByName(name);
    }



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
}