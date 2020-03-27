package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.Arrays;

public class ServerRequest implements Runnable {
    Socket socket;

    public ServerRequest(Socket socket) throws SocketException {
        this.socket = socket;
    }

    private final static int SERVER_PORT = 2015;
    private final static String SERVER_HOST = "localhost";
    private static final int DATAGRAM_SIZE = 1024;

    @Override
    public void run() {
        try {
            //новый сокет для отправки на сервер
            Socket socketOut = requestFunc();
            //достаем данные из клиетского запроса
            PrintStream clientSocketOutput = new PrintStream(socket.getOutputStream());
            //возвращаем обработанные данные клиенту
            BufferedReader clientSocketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintStream socketOutput = new PrintStream(socketOut.getOutputStream());
            BufferedReader socketInput = new BufferedReader(new InputStreamReader(socketOut.getInputStream()));

            //клиенские данные
            String line = clientSocketInput.readLine();
            System.out.println("old line: " + line);
            //отпраляем через второй сокет на сервер для обработки
            socketOutput.println(line);
            //получаем обработанные данные от сервера
            String newLine = socketInput.readLine();
            System.out.println("new line from server: " + line);
            //отправляем клиенту обработанные данные
            clientSocketOutput.println(newLine);
            System.out.println("send line: " + newLine);
            socket.close();
            clientSocketInput.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Socket requestFunc() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverIP = InetAddress.getByName(SERVER_HOST);
        //send the data back
        byte[] dataOut = "request".getBytes();
        DatagramPacket packetOut = new DatagramPacket(
                dataOut,
                dataOut.length,
                serverIP,
                SERVER_PORT
        );
        socket.send(packetOut);
        //receiving data
        byte[] dataReturn = new byte[DATAGRAM_SIZE];
        DatagramPacket packetReturn = new DatagramPacket(dataReturn, DATAGRAM_SIZE);
        socket.receive(packetReturn);

        String line = new String(dataReturn, 0, packetReturn.getLength());
        String[] strings = line.split("_");
        return new Socket(strings[0], Integer.parseInt(strings[1]));
    }
}

