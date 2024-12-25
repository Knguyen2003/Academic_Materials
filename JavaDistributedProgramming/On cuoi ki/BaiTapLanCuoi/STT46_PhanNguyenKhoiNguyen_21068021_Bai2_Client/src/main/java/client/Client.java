package client;

import entity.Food;
import entity.Item;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("DESKTOP-GOSNO9K", 1234);
                Scanner scanner = new Scanner(System.in);
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        ){
            while(true){
                System.out.println("\n 1.  Cau a \n 2. Cau b \n 3. Cau c \n Thoat \n Vui long nhap vao su lua chon cua ban");
                int choice = scanner.nextInt();
                dos.writeInt(choice);
                switch (choice){
                    case 1:
                        scanner.nextLine();
                        System.out.println("Nhap vao time chuan bi: ");
                        int timeCB = scanner.nextInt();
                        dos.writeInt(timeCB);
                        dos.flush();
                        System.out.println("Nhap vao time phuc vu: ");
                        int timePV = scanner.nextInt();
                        dos.writeInt(timePV);
                        dos.flush();
                        scanner.nextLine();
                        System.out.println("Nhap vao ID: ");
                        String id = scanner.nextLine();
                        dos.writeUTF(id);
                        dos.flush();
                        System.out.println("Nhap vao loai: 1,2,3");
                        int type = scanner.nextInt();
                        dos.writeInt(type);
                        dos.flush();
                        String result = dis.readUTF();
                        System.out.println(result);
                        break;
                    case 2:
                        scanner.nextLine();
                        System.out.println("Nhap vao so ten nha cung cap: ");
                        String name = scanner.nextLine();
                        dos.writeUTF(name);
                        dos.flush();

                        List<Item> list = (List<Item>) ois.readObject();
                        for (Item item : list){
                            System.out.println(item);
                        }
                        break;
                    case 3:
                        Map<Food, Double> map = (Map<Food, Double>) ois.readObject();
                        map.forEach((k, v) -> System.out.println(k + " " + v));
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
