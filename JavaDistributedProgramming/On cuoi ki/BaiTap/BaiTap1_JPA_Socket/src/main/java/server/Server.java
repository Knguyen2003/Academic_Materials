package server;

import dao.CandidateDao;
import dao.PositionDao;
import dao.impl.CandidateImpl;
import dao.impl.PositionImpl;
import entity.Position;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8021)) { //Tạo port
            System.out.println("Really............. ");
            while (true) {  //Đang đợi gửi tin nhắn tới (ĐỢI MÃI MÃI)
                Socket socket = server.accept(); //CHẤP NHẬN CHO CLIENT GỬI TỚI
                Server temp = new Server();
                new Thread(temp.new Handler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private class Handler implements Runnable {
        private Socket socket;
        private CandidateDao candidateDao;
        private PositionDao positionDao;


        public Handler(Socket socket) {
            this.socket = socket;
            candidateDao = new CandidateImpl();
            positionDao = new PositionImpl();
        }

        @Override
        public void run() {
           try{
               DataInputStream in = new DataInputStream(socket.getInputStream());
               ObjectOutputStream outObj = new ObjectOutputStream(socket.getOutputStream());
               int choose;
               while(true) {
                   choose = in.readInt();
                   switch (choose) {
                       case 1:
                           String name = in.readUTF();
                           double from = in.readDouble();
                           double to = in.readDouble();
                           List<Position> DsPos = positionDao.listPositions(name, from, to);
                           outObj.writeObject(DsPos);
                           break;
                       case 2:
                           System.out.println("You choose b");
                           break;
                       case 3:
                           System.out.println("You choose c");
                           break;
                       case 4:
                           System.out.println("You choose d");
                           break;
                       case 5:
                           System.out.println("You choose e");
                           break;
                       case 6:
                           System.out.println("You choose f");
                           break;
                       default:
                           System.out.println("Invalid choose");
                           break;
                   }
               }
           }catch(IOException e){
               e.printStackTrace();
           }
        }
    }


}