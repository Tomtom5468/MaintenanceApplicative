package src.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DureeMinutes {
    private int dureeMinutes;

    public DureeMinutes(int dureeMinutes) {
        this.dureeMinutes = dureeMinutes;
    }
}
