package src.reunion;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Participants {
    private String participants;

    public Participants(String participants) {
        this.participants = participants;
    }
}
