import java.util.List;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) {
        AppData data = Exeptionstream.getReading();
        for (Entry<String, List<Integer>> el : data.getMap().entrySet()) {
            System.out.println(el);
        }

        data.addData("Value 1", 763);
        data.addData("Value 2", 124);
        data.addData("Value 3", 421);

        data.addData("Value 1", 13);
        data.addData("Value 2", 12);
        data.addData("Value 3", 41);

        Exeptionstream.getWriting(data);
    }
}