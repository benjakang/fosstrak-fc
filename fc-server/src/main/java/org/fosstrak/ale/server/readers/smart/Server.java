package org.fosstrak.ale.server.readers.smart;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * This Server start server to wait the connection of physical reader. After transferring
 * the file, Tags will be load on array.
 * @author benjakang
 *
 */
public class Server {

    private boolean isConnected;
    private SmartAdaptor smartAdapter;
//    private ServerThread thread;

    public Server(SmartAdaptor smartAdapter){
        this.smartAdapter = smartAdapter;
    }

    public void disconnect(){
        //关闭连接
        isConnected = false;
        try {
            new Socket("localhost",5084);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void connect() {
        isConnected = true;
        //启动服务器
        new ServerThread().start();
    }

    public synchronized boolean isConnecting(){
        return isConnected;
    }

    class ServerThread extends Thread{
        private Socket socket;

        @Override
        public void run() {

            try {
                ServerSocket ss = new ServerSocket(5084);
                //循环接收
                while (isConnecting()) {
                    System.out.println("等待client接入");
//                    System.out.println(Thread.currentThread().getName());
                    System.out.println(InetAddress.getLocalHost().getHostAddress());
                    socket = ss.accept();
                    if(isConnecting()) { //最后一次连接，不载入
                        //输入输出流
                        PrintWriter output = new PrintWriter(socket.getOutputStream());
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        //写入文件流
                        File file = new File(Server.class.getResource("/tags1.txt").getFile());
                        FileOutputStream fout = new FileOutputStream(file);

                        byte[] inputByte = new byte[1024];
                        int len = 0;
                        while ((len = input.read(inputByte, 0, inputByte.length)) != -1) {
                            fout.write(inputByte, 0, len);
                            fout.flush();
                        }
                        output.write("Have received the file\n");
                        output.flush();

                        input.close();
                        output.close();

                        //收到client数据马上load
                        synchronized (smartAdapter) {
                            smartAdapter.loadTags();
                        }
                    }
                    socket.close();
                }
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}