package com.company;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            // открываем поток для чтения
            BufferedReader br = new BufferedReader(new InputStreamReader() );
            String str;
            // читаем содержимое
            List list = new ArrayList();
            while ((str = br.readLine()) != null)
                list.add(str);
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");

        } catch (
                IOException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
