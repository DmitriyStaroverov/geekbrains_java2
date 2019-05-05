package lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {

    public static final String IP_Address = "127.0.0.1";

    public static final int PORT = 9999;

    DataInputStream in;

    DataOutputStream out;

    ServerSocket serverSocket;

    Socket socket;

    public void sendMsg(String msg) {
        try {
            out.writeUTF ( msg );
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public ServerMain() {
        try {
            serverSocket = new ServerSocket ( PORT );
            System.out.println ( "Сервер запущен и ожидает подключения" );
            socket = serverSocket.accept ();
            System.out.println ( "Клиент подключился" );
            in = new DataInputStream ( socket.getInputStream () );
            out = new DataOutputStream ( socket.getOutputStream () );
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public static void main(String[] args) {
        ServerMain serverMain = new ServerMain ();

        Thread threadScan = new Thread ( new Runnable () {
            @Override
            public void run() {
                Scanner scanner = new Scanner ( System.in );
                System.out.println ( "Введите текст для отправки или END - для завершения" );
                while (scanner.hasNextLine ()) {
                    String s = scanner.nextLine ();
                    if (s.equalsIgnoreCase ( "end" )) break;
                    serverMain.sendMsg ( s );
                    System.out.println ( "Сообщение отправлено. Введите текст или END" );
                }
                scanner.close ();
            }
        } );
        threadScan.setDaemon ( true );
        threadScan.start ();

        try {
            while (true) {
                String str = serverMain.in.readUTF ();
                if (str.equalsIgnoreCase ( "END" )) break;
                System.out.println ( "Получено от клиента: /n" + str );
            }

        } catch (IOException e) {
            e.printStackTrace ();
        } finally {
            try {
                serverMain.socket.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
            try {
                serverMain.serverSocket.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }

        }
        System.out.println ( "BUY" );
    }
}

