package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;

public class ServerRequest implements Runnable {
    Utils utils; // пока без полезно, получаем адрес сервера. Сейчас возвращает "new Socket("localhost", 3033)";
    Socket socket;

    public ServerRequest(Socket socket) throws SocketException {
        this.socket = socket;
        utils = new Utils();
    }

    @Override
    public void run() {
        try {
            //новый сокет для отправки на сервер
            Socket socketOut = utils.bestServerLoad();
            //достаем данные из клиетского запроса
            PrintStream socketOutput = new PrintStream(socket.getOutputStream());
            //возвращаем обработанные данные клиенту
            BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintStream socketOutput2 = new PrintStream(socketOut.getOutputStream());
            BufferedReader socketInput2 = new BufferedReader(new InputStreamReader(socketOut.getInputStream()));

            while (true) {
                //клиенские данные
                String line = socketInput.readLine();
                //отпраляем через второй сокет на сервер для обработки
                socketOutput2.println(line);
                //получаем обработанные данные от сервера
                String newLine = socketInput2.readLine();
                //отправляем клиенту обработанные данные
                socketOutput.println(newLine);

                socket.close();
                socketInput.close();


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
