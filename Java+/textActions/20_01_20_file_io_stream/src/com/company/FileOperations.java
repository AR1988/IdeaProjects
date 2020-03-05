package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileOperations {

    public void outputList(LinkedList list, String name) throws IOException {
        FileOutputStream fos = new FileOutputStream(name);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i));
            stringBuilder.append(" ");
        }

        fos.write(stringBuilder.toString().getBytes());
        fos.close();
    }

    public List<Integer> inputStream(String filename) throws IOException {
        FileInputStream fis = new FileInputStream(filename);

        int length = fis.available();
        byte[] input = new byte[length];
        fis.read(input);

        String inputStr = new String(input);
        String[] parts = inputStr.split(" ");

        List<Integer> res = new ArrayList<>();
        for (String part : parts) {
            res.add(Integer.valueOf(part));
        }
        fis.close();
        return res;
    }
}
