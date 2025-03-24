package anniversaire;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Nom {
    private String nom;

    public Nom(String nom) {
        this.nom = nom;
    }
}
