import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

public class Client {
    public Client() throws Exception{
        Socket socket= new Socket("localhost",1707);
        Scanner sc= new Scanner(System.in);
        while (true) {
            String mess_Client = sc.nextLine();
            if(mess_Client.equals("exit")){
                DataOutputStream toSever = new DataOutputStream(socket.getOutputStream());
                toSever.writeBytes("exit");
                socket.close();
            }
            //dua sang Sever
            DataOutputStream toSever = new DataOutputStream(socket.getOutputStream());
            toSever.writeBytes(mess_Client + "\n");

            BufferedReader fromServe = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String data_of_serve = fromServe.readLine();
            System.out.println("Serve: "+data_of_serve);
        }

    }

    public static void main(String[] args) throws Exception{
        new Client();
    }
}
