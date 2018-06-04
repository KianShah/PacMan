wd/*
package To_Add;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Singleton Design Pattern
public class GhostsManager implements Iterable<Ghost>{

    private static GhostsManager instance;
    private Map<String, Ghost> ghostMap;

    private GhostsManager() {
        ghostMap = new HashMap<>();
    }

    public static GhostsManager getInstance() {
        if (instance == null) {
            instance = new GhostsManager();
        }

        return instance;
    }

    @Override
    public Iterator<Ghost> iterator() {
        return ghostMap.values().iterator();
    }
}
*/
