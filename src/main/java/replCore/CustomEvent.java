package replCore;

/**
 * Created by paulo on 21/10/16.
 */
import java.util.*;

// An interface to be implemented by everyone interested in "Hello" events
interface CustomEvent {
    void someoneSaidHello();
}

// Someone who says "Hello"
class Initiater {
    private List<CustomEvent> listeners = new ArrayList<CustomEvent>();

    public void addListener(CustomEvent toAdd) {
        listeners.add(toAdd);
    }

    public void sayHello() {
        System.out.println("Hello!!");

        // Notify everybody that may be interested.
        for (CustomEvent hl : listeners)
            hl.someoneSaidHello();
    }
}

// Someone interested in "Hello" events
class Responder implements CustomEvent {
    @Override
    public void someoneSaidHello() {
        System.out.println("Hello there...");
    }
}