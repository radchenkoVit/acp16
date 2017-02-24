package server;

import enums.Command;
import org.apache.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import static utils.Messages.*;

public class WeatherServer extends Thread {
    private Socket client;
    private String clientName;
    private Logger logger;

    public WeatherServer(Socket client){
        this.client = client;
        logger = Logger.getLogger(getClass().getName());

        setDaemon(true);
        setPriority(NORM_PRIORITY);
        start();
    }

    public static void main(String[] args){
        Logger logger = Logger.getLogger("server");
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(8888, 0, InetAddress.getByName("localhost"));
        } catch (IOException e) {
            logger.error(String.format(FAILED_TO_START_SERVER, e.getMessage()));
            throw new RuntimeException(String.format(FAILED_TO_START_SERVER, e.getMessage()));
        }

        logger.info(SERVER_START);

        try {
            while (true) {
                Socket client = serverSocket.accept();
                new WeatherServer(client);
            }
        } catch (IOException e) {
            logger.error(String.format(FAILED_TO_ESTABLISH_CONNECTION, e.getMessage()));
        }
    }

    public void run(){
        try {
            //transfer streams to more comfortable
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            clientName = in.readUTF(); // read and save client name
            logger.info(String.format(CLIENT_CONNECTED, clientName));

            while (true){
                String clientMessage = in.readUTF();
                logger.info(String.format(CLIENT_MESSAGE, clientName, clientMessage));
                String response = null;

                switch (clientMessage) {
                    case Command.WEATHER:
                        response = "2";
                        break;
                    case Command.QUIT:
                        client.close();
                        break;
                    default:
                        response = "Unknown command";
                }

                out.writeUTF(response);
                out.flush();
            }
        } catch (IOException e) {
            logger.info(String.format(CLIENT_CONNECTION_CLOSED, clientName));
        }
    }

}
