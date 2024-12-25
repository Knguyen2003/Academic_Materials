package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import dao.CourseDAO;
import dao.impl.CourseImpl;
import entity.Course;

public class Server {
	public static void main(String[] args) {

		try (ServerSocket server = new ServerSocket(1234)) {

			System.out.println("Ready....");

			while (true) {

				Socket socket = server.accept();

				System.out.println("Host's client: " + socket.getInetAddress().getHostName());

				Server temp = new Server();

				new Thread(temp.new Handler(socket)).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private class Handler implements Runnable {
		private Socket socket;
		private CourseDAO courseDAO;

		public Handler(Socket socket) {
			this.socket = socket;
			courseDAO = new CourseImpl();
		}

		@Override
		public void run() {
			try {

				DataInputStream in = new DataInputStream(socket.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				int choose;

				while (true) {
					choose = in.readInt();
					switch (choose) {
					case 1:
						String title = in.readUTF();
						System.out.println("Received: " + title);
						
						List<Course> courses = courseDAO.findByTitle(title);
						out.writeObject(courses);
						break;
					case 2:
						
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
