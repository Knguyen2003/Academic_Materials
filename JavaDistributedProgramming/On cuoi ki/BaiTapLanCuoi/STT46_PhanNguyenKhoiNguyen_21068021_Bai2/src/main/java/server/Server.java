package server;

import dao.FoodDao;
import dao.ItemDao;
import daoImpl.FoodImpl;
import daoImpl.ItemImpl;
import entity.Food;
import entity.Item;
import entity.Type;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234);) {

            System.out.println("Server started on port 1234");
            while (true) {
                Socket socket = serverSocket.accept();
                Server temp = new Server();
                new Thread(temp.new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private class ClientHandler implements Runnable {
        private Socket socket;
        private FoodDao foodDao;
        private ItemDao itemDao;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            this.foodDao = new FoodImpl();
            this.itemDao = new ItemImpl();
        }

        @Override
        public void run() {
            try (
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                    DataInputStream dis = new DataInputStream(socket.getInputStream());
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            ){
                while(true){
                    int choice = dis.readInt();
                    switch (choice){
                        case 1:
                            int timeCB = dis.readInt();
                            int timePV = dis.readInt();
                            String id = dis.readUTF();
                            int typeInt = dis.readInt();
                            Type type;
                            switch (typeInt){
                                case 1:
                                    type = Type.MAIN_COURSE;
                                    break;
                                case 2:
                                    type = Type.DESSERT;
                                    break;
                                case 3:
                                    type = Type.APPETIZER;
                                    break;
                                default:
                                    type = Type.MAIN_COURSE;
                                    break;
                            }



                            Food food = new Food(id, timeCB, timePV, type);

                            boolean result = foodDao.addFood(food);
                            if(result){
                                dos.writeUTF("Success");
                            }else{
                                dos.writeUTF("Fail");
                            }
                            break;
                        case 2:
                            String name = dis.readUTF();
                            List<Item> list = itemDao.listItems(name);
                            oos.writeObject(list);
                            oos.flush();
                            break;
                        case 3:
                            Map<Food, Double> map = foodDao.listFoodAndCost();
                            oos.writeObject(map);
                            oos.flush();
                            break;
                        case 4:
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Vui long nhap lai");
                            break;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
