package src;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Title {
    private String nom;

    public Title(String nom) {
        this.nom = nom;
    }
}
