package metier;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import event.Event;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Events {
    private List<Event> events;

    public Events(List<Event> events) {
        this.events = events;
    }

    public void ajouterEvent(Event e) {
        events.add(e);
    }

    public void supprimerEvent(Event e) {
        events.remove(e);
    }

    public void supprimerEvent(int index) {
        events.remove(index);
    }

    public void getEvent(int index) {
        events.get(index);
    }
}
