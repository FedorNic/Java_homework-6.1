import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AppData {
    private Map<String, List<Integer>> data = new TreeMap<>();

    public Map<String, List<Integer>> getMap() {
        return data;
    }

    public void addData(String key, Integer toAdd) {
        if (data.containsKey(key)) {
            data.get(key).add(toAdd);
        } else {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(toAdd);
            data.put(key, tmp);
        }
    }

    public void addAllData(String key, List<Integer> toAdd) {
        if (data.containsKey(key)) {
            data.get(key).addAll(toAdd);
        } else {
            data.put(key, toAdd);
        }
    }
}