package src.reunion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lieu {
    private String lieu;
    public Lieu(String lieu) {
        this.lieu = lieu;
    }
}
