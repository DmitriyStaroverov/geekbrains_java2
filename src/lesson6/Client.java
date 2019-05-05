package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import static lesson6.ServerMain.IP_Address;
import static lesson6.ServerMain.PORT;

public class Client {

    private DataInputStream in;

    private DataOutputStream out;

    private Socket socket;

    public Client() {
        try {
            socket = new Socket ( IP_Address, PORT );
            System.out.println ( "Клиент подключился к серверу" );
            in = new DataInputStream ( socket.getInputStream () );
            out = new DataOutputStream ( socket.getOutputStream () );
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public static void main(String[] args) {
        Client client = new Client (  );

        Thread threadScan = new Thread ( new Runnable () {
            @Override
            public void run() {
                Scanner scanner = new Scanner ( System.in );
                System.out.println ( "Введите текст для отправки или END - для завершения" );
                while (scanner.hasNextLine ()) {
                    String s = scanner.nextLine ();
                    client.sendMsg ( s );
                    if (s.equalsIgnoreCase ( "end" )) break;
                    System.out.println ( "Сообщение отправлено. Введите текст или END" );
                }
                scanner.close ();
            }
        } );
        threadScan.setDaemon ( true );
        threadScan.start ();

        try {
            while (true) {
                String str = client.in.readUTF ();
                if (str.equalsIgnoreCase ( "END" )) break;
                System.out.println ( "Получено от серевера: " + str );
            }

        } catch (IOException e) {
            e.printStackTrace ();
        } finally {
            try {
                client.socket.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }
        System.out.println ( "BUY" );
    }

    private void sendMsg(String s) {
        try {
            out.writeUTF ( s );
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
