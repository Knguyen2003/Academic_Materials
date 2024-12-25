package server;

import dao.FacilityDao;
import dao.PersonDao;
import daoImpl.FacilityImpl;
import daoImpl.PersonImpl;
import entity.Person;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(8021)){
            System.out.println("Server is running on port 8021");
            while(true){
                Socket socket = server.accept();
                Server temp = new Server();
                new Thread(temp.new Handler(socket)).start();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private class Handler implements Runnable{
        private Socket socket;
        private FacilityDao facilityDao;
        private PersonDao personDao;


        public Handler(Socket socket){
            this.socket = socket;
            facilityDao = new FacilityImpl();
            personDao = new PersonImpl();
        }

        @Override
        public void run() {
            try(
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            ){
                while (true){
                    int choice = dis.readInt();
                    switch (choice){
                        case 1:
                            String facilityName = dis.readUTF();
                            List<Person> persons = personDao.getMaintenanceWorkers(facilityName);
                            oos.writeObject(persons);
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
}
