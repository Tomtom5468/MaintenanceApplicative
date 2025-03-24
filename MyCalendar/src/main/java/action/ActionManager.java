package action;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ActionManager {
    private final Map<String, Supplier<Action>> actions = new HashMap<>();

    public void enregistrer(String choix, Supplier<Action> action) {
        actions.put(choix, action);
    }

    public Action getAction(String choix) {
        return actions.get(choix) != null ? actions.get(choix).get() : null;
    }
}
