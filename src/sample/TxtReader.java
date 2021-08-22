package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TxtReader {

    ArrayList<String> dataArray = new ArrayList<>();

    public ArrayList<String> getData() {

        try {
            FileReader reader = new FileReader("C:/Users/ncegl/Documents/ProjectMoneyDoc.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                dataArray.add(line);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataArray;
    }
}
