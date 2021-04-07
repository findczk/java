import java.util.HashMap;
import java.util.Map;

/**
 * @author dsx
 */
public class MapUtil<K,V> {
    private Map<K,V> map;

    public MapUtil() {
        map = new HashMap<>();
    }

    public MapUtil(Map<K,V> map) {
        this.map = map;
    }

    public MapUtil put(K key,V value) {
        map.put(key, value);
        return this;
    }

    public Map<K, V> getMap() {
        return map;
    }
}
