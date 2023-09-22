package dk.kea.jpastudentdat22c.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
public record StudentDTO(int id, String name, LocalDate bornDate, LocalTime bornTime) {

}
