package src.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Proprietaire {
    private String proprietaire;

    public Proprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }
}
