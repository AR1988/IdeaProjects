package com.company;

import java.io.IOException;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {

        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        String filename = "nefile1.txt";

        FileOperations fileOperations = new FileOperations();
        //write file
        fileOperations.outputList(list, filename);
        //read file without " "
        System.out.println(fileOperations.inputStream(filename).toString());
        //read file
        System.out.println(inputStream(filename));
    }

    public static void outputStream(String filename) throws IOException {
        java.io.FileOutputStream fos = new java.io.FileOutputStream(filename, true);
        String str = "Hello file!";
        byte[] output = str.getBytes();
        fos.write(output);
        fos.close();
    }

    public static String inputStream(String filename) throws IOException {
        java.io.FileInputStream fis = new java.io.FileInputStream(filename);
        int length = fis.available();
        byte[] input = new byte[length];
        fis.read(input);

        fis.close();

        return new String(input);
    }
}
