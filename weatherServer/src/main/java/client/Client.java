package client;

import java.io.*;
import java.net.Socket;

import static utils.Messages.CONNECTED_TO_SERVER;
import static utils.Messages.ENTER_CLIENT_NAME;
import static utils.Messages.FAILED_TO_START_CLIENT;

public class Client {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Socket socket;
        String clientName;
        try {

            System.out.print(ENTER_CLIENT_NAME);
            clientName = reader.readLine();
            System.out.println();
            socket = new Socket("localhost", 8888);
            System.out.println(CONNECTED_TO_SERVER);
        } catch (IOException e) {
            throw new RuntimeException(String.format(FAILED_TO_START_CLIENT, e.getMessage()));
        }

        //get streams and wrap them to more usable classes
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());


        out.writeUTF(clientName);
        out.flush(); // send client name

        while (true){
            System.out.print("you: ");
            String message = reader.readLine();

            out.writeUTF(message);
            out.flush(); // send client message

            String response = in.readUTF();
            System.out.printf("server: %s\n", response);
        }

        //socket.close(); TODO: doesn't work, reason?

    }
}
