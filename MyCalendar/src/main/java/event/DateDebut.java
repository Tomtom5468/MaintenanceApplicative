package event;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DateDebut {
    private LocalDateTime dateDebut;

    public DateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }
}
