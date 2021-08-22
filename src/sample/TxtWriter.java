package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class TxtWriter {

    public void fileWrite(LocalDate date, String amount, String total, String sign) {

        try {

            FileWriter writer = new FileWriter("C:/Users/ncegl/Documents/ProjectMoneyDoc.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(date + "~" + sign + amount + "~" + total);
            bufferedWriter.newLine();

            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
