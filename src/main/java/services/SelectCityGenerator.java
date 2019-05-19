package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SelectCityGenerator {

    private String filePath;

    public SelectCityGenerator(String filePath) {

        this.filePath=filePath;
    }


    public StringBuilder make () throws IOException{

        FileReader in = new FileReader(filePath);
        BufferedReader br = new BufferedReader(in);
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while ((line=br.readLine()) != null) {
            stringBuilder.append("<option value="+"\""+line+"\">"+line.replace("+", " ")+"</option>");
        }
        in.close();
        return stringBuilder;
    }

}
