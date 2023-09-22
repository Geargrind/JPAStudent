package dk.kea.jpastudentdat22c.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate bornDate;
    private LocalTime bornTime;


    public Student(String name, LocalDate bornDate, LocalTime bornTime) {
        this.name = name;
        this.bornDate = bornDate;
        this.bornTime = bornTime;
    }
}


