package client;

import entity.Person;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try
        {
            Socket socket = new Socket("DESKTOP-GOSNO9K", 8021);
            Scanner sc = new Scanner(System.in);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            while (true){
                System.out.println("\n1. Cau a \n2. Cau b \n2. Cau c \n4. Thoat \nVui long nhap lua chon cua ban");
                int choice = sc.nextInt();
                dos.writeInt(choice);
                switch (choice) {
                    case 1:
                        sc.nextLine();
                        System.out.println("Nhap ten co so vat chat: ");
                        String facilityName = sc.nextLine();
                        dos.writeUTF(facilityName);
                        dos.flush();
                        List<Person> persons = (List<Person>) ois.readObject();
                        persons.forEach(System.out::println);
                        break;
                    case 2:
                        System.out.println("Cau b");
                        break;
                    case 3:
                        System.out.println("Cau c");
                        break;
                    case 4:
                        System.out.println("Thoat");
                        return;
                    default:
                        System.out.println("Lua chon khong hop le");
                }

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
