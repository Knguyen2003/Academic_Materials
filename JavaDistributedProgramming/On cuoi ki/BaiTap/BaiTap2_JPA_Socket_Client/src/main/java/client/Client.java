package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("DESKTOP-GOSNO9K", 8021);
            Scanner sc = new Scanner(System.in);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        ){
            while (true){
                System.out.println("\n1. Câu a \n2. Câu b \n3. Câu c \n4. Thoát \n Vui lòng nhập lựa chọn của bạn :");
                int choice = sc.nextInt();
                dos.writeInt(choice);
                switch (choice){
                    case 1:
                        sc.nextLine();
                        System.out.println("Vui lòng nhập ID với ID bắt đầu bằng F và 3 số :");
                        String id = sc.nextLine();
                        dos.writeUTF(id);
                        dos.flush();

                        System.out.println("Vui lòng chọn loại món ăn: \n1. MAIN_COURSE \n2. DESSERT \n3. APPETIZER");
                        int type = sc.nextInt();
                        dos.writeInt(type);
                        dos.flush();

                        System.out.println("Vui lòng nhập so phut phuc vu:");
                        int phucVu = sc.nextInt();
                        dos.writeInt(phucVu);
                        dos.flush();
                        System.out.println("Vui lòng nhập so phut chuan bi:");
                        int chuanBi = sc.nextInt();
                        dos.writeInt(chuanBi);
                        dos.flush();

                        String result = dis.readUTF();
                        System.out.println(result);

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
