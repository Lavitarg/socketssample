package socket.example.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocketManager {

    private Socket clientSocket;
    private PrintWriter clientOutput;
    private BufferedReader clientInput;

    public void setUpConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        clientOutput = new PrintWriter(clientSocket.getOutputStream(), true);
        clientInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public void sendMessageToServer(String msg) {
        clientOutput.println(msg);
    }

    public String getNextServerMessage() throws IOException{
        String msgFromServer = clientInput.readLine();
        return msgFromServer;
    }

    public void close() throws IOException {
        clientSocket.close();
    }
}
