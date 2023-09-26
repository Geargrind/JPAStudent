package dk.kea.jpastudentdat22c.dto;

import java.time.LocalDate;
import java.time.LocalTime;




public record StudentDTO(int id, String name, LocalDate bornDate, LocalTime bornTime) {
    @Override
    public int id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public LocalDate bornDate() {
        return bornDate;
    }

    @Override
    public LocalTime bornTime() {
        return bornTime;
    }
}
