package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class ServerRequest implements Runnable {
    private Socket socket;
    private String loadBalanceIP;
    int loadBalancePort;

    private int datagramSize;

    public ServerRequest(Socket socket, String loadBalanceIP, int loadBalancePort, int datagramSize) {
        this.socket = socket;
        this.loadBalanceIP = loadBalanceIP;
        this.loadBalancePort = loadBalancePort;
        this.datagramSize = datagramSize;
    }

    @Override
    public void run() {
        try {
            //новый сокет для отправки на сервер
            Socket socketOut = requestFunc();
            //достаем данные из клиетского запроса
            PrintStream clientOutputStream = new PrintStream(socket.getOutputStream());
            //возвращаем обработанные данные клиенту
            BufferedReader clientInputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintStream serverOutputStream = new PrintStream(socketOut.getOutputStream());
            BufferedReader serverInputReader = new BufferedReader(new InputStreamReader(socketOut.getInputStream()));

            //клиенские данные
            String line = clientInputReader.readLine();
            //отпраляем через второй сокет на сервер для обработки
            serverOutputStream.println(line);
            //получаем обработанные данные от сервера
            String newLine = serverInputReader.readLine();
            //отправляем клиенту обработанные данные
            clientOutputStream.println(newLine);
            socket.close();
            clientInputReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Socket requestFunc() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverIP = InetAddress.getByName(loadBalanceIP);
        //send the data back
        byte[] dataOut = "request".getBytes();
        DatagramPacket packetOut = new DatagramPacket(
                dataOut,
                dataOut.length,
                serverIP,
                loadBalancePort
        );
        socket.send(packetOut);

        //receiving data
        byte[] dataReturn = new byte[datagramSize];
        DatagramPacket packetReturn = new DatagramPacket(dataReturn, datagramSize);
        socket.receive(packetReturn);
        String line = new String(dataReturn, 0, packetReturn.getLength());
        String[] strings = line.split("_");

        System.out.println("send to server: \tIP: " + strings[0] + "\tPort: " + strings[1]);

        return new Socket(strings[0], Integer.parseInt(strings[1]));
    }
}

