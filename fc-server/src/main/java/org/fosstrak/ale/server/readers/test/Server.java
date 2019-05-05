package org.fosstrak.ale.server.readers.test;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    // 向android客户端输出hello worild

    private InputStream input;
    private OutputStream output;
    private Socket socket;

    public void disconnect() throws IOException{
        //关闭输入输出流
        output.close();
        input.close();
        socket.close();
    }
    public void connect() throws IOException {
    ServerSocket ss = new ServerSocket(5084);
    System.out.println(InetAddress.getLocalHost().getHostAddress());
    System.out.println("服务器正常启动。。。");

    socket = ss.accept();
    System.out.println("用户接入成功。。。");
    new ServerThread(socket).start();

    }
}

class ServerThread extends Thread{
    private Socket socket= null;
    public ServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            System.out.println("开始接收数据...");
            //向客户端发送信息
            OutputStream output = socket.getOutputStream();
            DataInputStream input = new DataInputStream(socket.getInputStream());
            FileOutputStream fout = new FileOutputStream(new File("tags1.txt" + input.readUTF()));

            byte[] inputByte = new byte[1024];
            int len;
            while((len=input.read(inputByte))!=-1){
                fout.write(inputByte, 0, len);
            }
//            OutputStream os = socket.getOutputStream();
            output.write("你发送的文件我已经接收".getBytes());
            output.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
