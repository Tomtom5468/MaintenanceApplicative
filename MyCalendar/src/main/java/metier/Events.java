package metier;

import lombok.Setter;
import event.Event;

import java.util.ArrayList;
import java.util.List;

@Setter
public class Events {
    private List<Event> events;

    public Events() {
        this.events = new ArrayList<>();
    }

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

    public List<Event> getEvents() {
        return events == null ? new ArrayList<Event>() : events;
    }
}
