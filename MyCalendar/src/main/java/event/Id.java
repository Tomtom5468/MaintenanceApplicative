package event;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class Id {
    private UUID id;

    public Id(UUID id) {
        this.id = id;
    }
}
