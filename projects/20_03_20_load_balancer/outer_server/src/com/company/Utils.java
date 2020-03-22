package com.company;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;
import java.util.List;

public class Utils {
    private static final int DATA_SIZE = 128;
    private final static int SERVER_PORT = 2014; //порт куда кидать сообщение
    private final static String SERVER_HOST = "localhost"; // адрес куда кида кидать сообщение

    private DatagramSocket socket;

    private int balancerPort = SERVER_PORT;
    private String balancerHost = SERVER_HOST;
    //регион конструкторов
    //#region constructor
    /*
    конструктор принимает только сокет, адрес и порт балансера
     */

    public Utils() throws SocketException {
        this.socket = new DatagramSocket();
    }
    /*
     конструктор принимает сокет, адрес и порт балансера
     */
    public Utils(int balancerPort, String balancerHost) throws SocketException {
        this.balancerPort = balancerPort;
        this.balancerHost = balancerHost;
        this.socket = new DatagramSocket();
    }
//#endregion //

    public Socket bestServerLoad() throws IOException {
//        serverLoadAsk();
//        gettingAnswerFromLoadBalancer();
//        return serverDeparture();
        return new Socket("localhost", 3033);

    }

    /**
     * проверяет загруженость сервера
     */
    private void serverLoadAsk() throws IOException {

        InetAddress serverIP = InetAddress.getByName(balancerHost);

        String line = "request";
        byte[] dataOut = line.getBytes();

        DatagramPacket packetOut = new DatagramPacket(
                dataOut,
                dataOut.length,
                serverIP,
                balancerPort
        );
        socket.send(packetOut);
    }

    /**
     * получаем ответ от балансёра
     *
     * @return List<String> где интекс 0 это ip сервера, индекс 1 это порт
     * TODO: от "LoadBalancer" должно приходить пакет со строкой формата "serverIP_serverPort". пример: "127.0.0.1_2014"
     */
    private List<String> gettingAnswerFromLoadBalancer() throws IOException {
        byte[] dataToReceive = new byte[DATA_SIZE];
        DatagramPacket packetIn = new DatagramPacket(
                dataToReceive,
                DATA_SIZE
        );
        socket.receive(packetIn);

        String line = new String(dataToReceive, 0, packetIn.getLength());
        String[] strings = line.split("_");

        // ответ какой сервер менее загружен. Должен содержать адрес и порт сервера.
        return Arrays.asList(strings[0], strings[1]);
    }

    /**
     * отправка задания на сервер
     *
     * @return new Socket с указанным адресом от балансировщика
     */
    private Socket serverDeparture() throws IOException {
        List<String> list = gettingAnswerFromLoadBalancer();
        return new Socket(list.get(0)
                , Integer.parseInt(list.get(1)));
    }
}
