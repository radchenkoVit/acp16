package utils;

public class Messages {
    private Messages(){}

    public static String SERVER_START = "Server is started";
    public static String CLIENT_CONNECTED = "Client with name: %s is connected\n";
    public static String CLIENT_CONNECTION_CLOSED = "Connection with client: %s is closed";

    public static String FAILED_TO_START_SERVER = "Failed to start server, exception: %s";
    public static String FAILED_TO_ESTABLISH_CONNECTION = "Failed to establish connection, error message: %s\n";

    //client
    public static String ENTER_CLIENT_NAME = "Please, enter your name: ";
    public static String CONNECTED_TO_SERVER = "Connection with server is established.";
    public static String FAILED_TO_START_CLIENT = "Failed to start client, error: %s\n";
    public static String CLIENT_MESSAGE = "%s: %s\n";
}
