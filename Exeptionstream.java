import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Exeptionstream {
    public static AppData getReading() {
        AppData data = new AppData();
        List<String> v = new ArrayList<>();

        try (FileReader fr = new FileReader("AppData.csv")) {
            try (Scanner sc = new Scanner(fr)) {
                int i = 0;
                while (sc.hasNext()) {
                    String str = sc.nextLine();
                    if (str.length() > 0) {
                        String[] arr = str.split(";");
                        if (i == 0) {
                            Collections.addAll(v, arr);
                            i++;
                        } else {
                            int j = 0;
                            for (String el : v) {
                                int tmp = Integer.parseInt(arr[j]);
                                data.addData(el, tmp);
                                j++;
                            }
                        }
                    }
                }
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (IOException ex) {
            System.out.println("File not found");
        }

        return data;
    }

    // C:/Users/FedorNic/Desktop/Education/Java/home_tasks/HT_6/AppData.csv
    public static void getWriting(AppData data) {
        try (FileWriter fw = new FileWriter("AppData.csv", false)) {
            Map<String, List<Integer>> db = data.getMap();
            List<String> keys = db.keySet().stream().toList();
            String tmp = new String();
            tmp = String.join(";", keys);
            tmp += "\n";
            fw.append(tmp);
            int length = db.get(keys.get(0)).size();
            for (int i = 0; i < length; i++) {
                tmp = "";
                for (int j = 0; j < keys.size(); j++) {
                    if (j + 1 == keys.size()) {
                        tmp += db.get(keys.get(j)).get(i) + "\n";
                    } else {
                        tmp += db.get(keys.get(j)).get(i) + ";";
                    }
                }
                fw.append(tmp);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}