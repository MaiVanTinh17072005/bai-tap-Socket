import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client{
    public Client() throws Exception {
        Socket socket= new Socket("localhost",1903);
        while(true) {
            Thread.sleep(1000);
            //dua qua serve
            DataOutputStream toServe = new DataOutputStream(socket.getOutputStream());
            toServe.writeBytes("time" + "\n");
        }

    }

    public static void main(String[] args) throws Exception{
        new Client();
    }
}
