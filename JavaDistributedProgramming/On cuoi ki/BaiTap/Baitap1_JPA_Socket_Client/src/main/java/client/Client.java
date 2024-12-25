package client;






import entity.Position;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("DESKTOP-GOSNO9K", 8021);
            Scanner scanner = new Scanner(System.in);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream()); //gửi kiểu int
            ObjectInputStream inObj = new ObjectInputStream(socket.getInputStream());
        ){
            while(true) {
                System.out.println("Enter your choosing: \n1. a: \n2. b: \n3. c: \n4. d: \n5. e: \n6. f: ");
                int choose = scanner.nextInt();
                out.writeInt(choose);
                switch (choose) {
                    case 1:
                        scanner.nextLine();
                        System.out.println("Vui lòng nhập tên vị trí công việc: ");
                        String name = scanner.nextLine();
                        out.writeUTF(name);
                        out.flush();
                        System.out.println("Vui lòng nhập mức lương từ: ");
                        double from = scanner.nextDouble();
                        out.writeDouble(from);
                        out.flush();
                        System.out.println("Vui lòng nhập mức lương đến: ");
                        double to = scanner.nextDouble();
                        out.writeDouble(to);
                        out.flush();


                        List<Position> ds = (List<Position>) inObj.readObject();
                        ds.forEach(position -> {
                            System.out.println(position);
                        });
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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
