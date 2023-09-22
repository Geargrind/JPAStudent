package dk.kea.jpastudentdat22c.controller;

import dk.kea.jpastudentdat22c.model.Student;
import dk.kea.jpastudentdat22c.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/")
    public List<Student> getAllStudents() {
        List<Student> list = studentRepository.findAll();

        return list;

    }

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
}
