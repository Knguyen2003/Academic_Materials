package client;


import java.rmi.Naming;
import java.util.Map;

import dao.AlbumDao;

public class Client {
  private static final String URL = "rmi://DESKTOP-GOSNO9K:8021/";
   public static void main(String[] args) {
	try {
		AlbumDao albumDao = (AlbumDao) Naming.lookup(URL + "albumDao");

		
		albumDao.getNumberOfAlbumsByGenre();
		
		Map<String, Long> map = albumDao.getNumberOfAlbumsByGenre();
		for (String key : map.keySet()) {
			System.out.println("Tên thể loại: "+key + " Số lương album: " + map.get(key));
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
}
}
