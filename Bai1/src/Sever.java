import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Sever {
    public Sever() throws Exception{
        ServerSocket serverSocket= new ServerSocket(1707);
        Socket socket = serverSocket.accept();
        Scanner sc = new Scanner(System.in);
        while(true) {
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String data_of_Client = fromClient.readLine();
            if(data_of_Client.equals("exit")){
                socket.close();
            }
            System.out.println("Client: " + data_of_Client);

            String mess_of_Serve = sc.nextLine();
            DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
            toClient.writeBytes(mess_of_Serve + "\n");
        }
    }

    public static void main(String[] args) throws Exception{
        new Sever();
    }
}
