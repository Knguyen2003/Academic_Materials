package client;

import entity.Candidate;
import entity.Position;

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
        try(Socket socket = new Socket("DESKTOP-GOSNO9K", 1234);
            Scanner scanner = new Scanner(System.in);
            ObjectOutputStream ous = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        ){
                while(true){
                    System.out.println("\n1. Cau a \n2. Cau b \n3. Cau c \n4. Thoat \n Vui long nhap lua chon cua ban: ");
                    int choice = scanner.nextInt();
                    dos.writeInt(choice);
                    dos.flush();
                    switch (choice){
                        case 1:
                            scanner.nextLine();
                            System.out.println("Nhap vao ten vi tri cong viec muon tim");
                            String name = scanner.nextLine();
                            dos.writeUTF(name);
                            dos.flush();
                            System.out.println("Nhap vao muc luong tu :");
                            int min = scanner.nextInt();
                            dos.writeInt(min);
                            dos.flush();
                            System.out.println("Nhap vao muc luong toi :");
                            int max = scanner.nextInt();
                            dos.writeInt(max);
                            dos.flush();

                            List<Position> po = (List<Position>) ois.readObject();
                            for(Position p : po){
                                System.out.println(p);
                            }
                            break;
                        case 2:
                            Map<Candidate, Long> map = (Map<Candidate, Long>) ois.readObject();
                            map.forEach((k,v) -> {
                                System.out.println(k + "Số công ty là :" + v);
                            });
                            break;
                        case 3:
                            System.out.println("Nhap vao ID:");
                            String id = scanner.nextLine();
                            dos.writeUTF(id);
                            dos.flush();
                            System.out.println("Nhap mo ta:");
                            String description = scanner.nextLine();
                            dos.writeUTF(description);
                            dos.flush();
                            System.out.println("Nhap email:");
                            String email = scanner.nextLine();
                            dos.writeUTF(email);
                            dos.flush();
                            System.out.println("Nhap ten day du:");
                            String fullName = scanner.nextLine();
                            dos.writeUTF(fullName);
                            dos.flush();
                            System.out.println("Nhap gioi tinh:");
                            dos.writeUTF(scanner.nextLine());
                            dos.flush();
                            System.out.println("Nhap so dien thoai:");
                            dos.writeUTF(scanner.nextLine());
                            dos.flush();
                            System.out.println("Nhap nam sinh:");
                            dos.writeInt(scanner.nextInt());
                            dos.flush();

                            String result = dis.readUTF();
                            System.out.println(result);
                            break;
                        case 4:
                            System.out.println("Thoat");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
