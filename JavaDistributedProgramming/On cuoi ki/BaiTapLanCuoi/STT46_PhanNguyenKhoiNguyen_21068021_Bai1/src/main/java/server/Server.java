package server;

import dao.CandidateDao;
import dao.PositionDao;
import daoImpl.CandidateImpl;
import daoImpl.PositionImpl;
import entity.Candidate;
import entity.Position;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234);)
        {
            System.out.println("Server started on port 1234");
            while (true) {
                Socket socket = serverSocket.accept();
                Server temp = new Server();
                new Thread(temp.new Handler(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private class Handler implements Runnable {
        private Socket socket;
        private PositionDao positionDao;
        private CandidateDao candidateDao;

        public Handler(Socket socket) {
            this.socket = socket;
            this.positionDao = new PositionImpl();
            this.candidateDao = new CandidateImpl();
        }

        @Override
        public void run() {
            try(

                ObjectOutputStream ous = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            ){
                while(true){
                    int choice = dis.readInt();
                    switch (choice){
                        case 1:
                            String name = dis.readUTF();
                            int min = dis.readInt();
                            int max = dis.readInt();
                            List<Position> positions = positionDao.listPositions(name, min, max);
                            ous.writeObject(positions);
                            break;
                        case 2:
                            Map<Candidate, Long> map = candidateDao.listCadidatesByCompanies();
                            ous.writeObject(map);
                            break;
                        case 3:
                            String id = dis.readUTF();
                            String name1 = dis.readUTF();
                            String email = dis.readUTF();
                            String phone = dis.readUTF();
                            String gioiTinh = dis.readUTF();
                            int yearOfBirth = dis.readInt();
                            String description = dis.readUTF();
                            Candidate candidate = new Candidate(description, email, name1, gioiTinh, id, phone, yearOfBirth);
                            boolean result = candidateDao.addCandidate(candidate);
                            if(result){
                                dos.writeUTF("Success");
                            }else{
                                dos.writeUTF("Fail");
                            }
                            dos.flush();

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
}
