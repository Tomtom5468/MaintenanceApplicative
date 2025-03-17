package src.periodique;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FrequenceJours {
    private int frequenceJours;

    public FrequenceJours(int frequenceJours) {
        this.frequenceJours = frequenceJours;
    }
}
