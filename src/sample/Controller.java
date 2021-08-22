package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public Button add;
    public Button subtract;
    @FXML
    TextField amount = new TextField();
    @FXML
    DatePicker date = new DatePicker();
    @FXML
    TextArea total = new TextArea();
    @FXML
    ListView list;
    TxtWriter newWrite = new TxtWriter();

    public void addition(){

        double totalDouble;
        double amountDouble;

        if (amount.getText() == null) {
            amountDouble = 0;
        } else {
            amountDouble = Double.parseDouble(amount.getText());
        }

        if (getTotal() != null){
            totalDouble = Double.parseDouble(getTotal());
        } else{
            totalDouble = 0;
        }

        double newTotal = totalDouble + amountDouble;

        if(date == null || amount.getText() == null){
            newWrite.fileWrite(LocalDate.now(), "0", String.valueOf(newTotal), "+");
        } else{
            newWrite.fileWrite(date.getValue(), amount.getText(), String.valueOf(newTotal), "+");
        }

        total.clear();
        total.setText(total.getText() + newTotal);
        amount.clear();
        listDisplay();
    }

    public void subtraction(){

        double totalDouble;
        double amountDouble;

        if (amount.getText() != null) {
            amountDouble = Double.parseDouble(amount.getText());
        } else {
            amountDouble = 0;
        }

        if (getTotal() != null){
            totalDouble = Double.parseDouble(getTotal());
        } else{
            totalDouble = 0;
        }

        double newTotal = totalDouble - amountDouble;

        if(date == null|| amount.getText() == null){
            newWrite.fileWrite(LocalDate.now(), "0", String.valueOf(newTotal), "-");
        } else{
            newWrite.fileWrite(date.getValue(), amount.getText(), String.valueOf(newTotal), "-");
        }

        total.clear();
        total.setText(total.getText() + newTotal);
        amount.clear();
        listDisplay();

    }

    public String getTotal(){

        String[] split;
        TxtReader txt = new TxtReader();
        ArrayList<String> last = txt.getData();
        int x = last.size();

        if (x > 0) {
            split = txt.getData().get(x - 1).split("~", -1);
        } else {
            return null;
        }
        return split[2];
    }

    public void listDisplay(){

        ArrayList<String> dataArray = new ArrayList<>();
        list.getItems().clear();
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
        for (String s : dataArray) {
            list.getItems().add(s);
        }
    }
}