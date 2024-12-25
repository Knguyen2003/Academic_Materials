package server;

import dao.FoodDao;
import dao.ItemDao;
import daoImpl.FoodImpl;
import daoImpl.ItemImpl;
import entity.Food;
import entity.Type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(8021)){
            System.out.println("Running server... ");
            while (true){
                Socket socket = server.accept();

                Server temp = new Server();
                new Thread(temp.new Handler(socket)).start();

            }

        } catch (Exception e){
          e.printStackTrace();
        }
    }

    private class Handler implements Runnable{
        private Socket socket;
        private FoodDao foodDao;
        private ItemDao itemDao;



        public Handler(Socket socket){
            this.socket = socket;
            foodDao = new FoodImpl();
            itemDao = new ItemImpl();
        }


        @Override
        public void run(){
            try(
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            ){
                while (true){
                    int choice =  dis.readInt();
                    switch (choice){
                        case 1:
                            String id = dis.readUTF();

                            Type typeString;
                            int type = dis.readInt();
                            int phucVu = dis.readInt();
                            int chuanBi = dis.readInt();
                            if(type == 1){
                                typeString = Type.MAIN_COURSE;
                            } else if(type == 2){
                                typeString = Type.DESSERT;
                            } else {
                                typeString = Type.APPETIZER;
                            }

                            Food food = new Food(id, typeString, chuanBi,phucVu);
                            boolean result = foodDao.addFood(food);
                            if(result){
                                dos.writeUTF("Thêm món ăn thành công");
                            } else {
                                dos.writeUTF("Thêm món ăn thất bại");
                            }
                            break;
                        case 2:
                            break;
                        case 3:

                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Vui lòng chọn từ 1-4");
                    }

                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}



