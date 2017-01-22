package garbage.contactListApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputString {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private InputString(){}

    /*
    * Input action made, by user
    * Enter String
    * */
    public static String enterString() throws IOException {
        return reader.readLine();
    }

    /*
    * Input action made, by user
    * Enter int
    * */
    public static int enterInt() throws IOException {
        return Integer.parseInt(enterString());
    }
}
