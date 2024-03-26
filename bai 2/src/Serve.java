import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Serve extends JFrame {
    public Serve() throws Exception {
        ServerSocket serverSocket=new ServerSocket(1903);
        Socket socket=serverSocket.accept();
        while (true){
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String read_data_of_Client= fromClient.readLine();
            if(read_data_of_Client.equals("time")){
                    LocalDateTime currentTime = LocalDateTime.now();
                    int h= currentTime.getHour();
                    int phut= currentTime.getMinute();
                    int s= currentTime.getSecond();
                    String t= h+"h:"+phut+"p:"+s+"s";
                    this.setSize(300,300);
                    JPanel p= new JPanel();
                    p.setSize(300,300);
                    p.setPreferredSize(null);
                    JLabel label= new JLabel();
                    label.setText(t);
                    p.add(label);
                    this.add(p);
                    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    this.setVisible(true);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Serve();
    }
}
