package main;

import dao.PositionDao;
import dao.impl.PositionImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Test {
    public static void main(String[] args) {

//        EntityManager em = Persistence.createEntityManagerFactory("JPA_Baithi_MSSQL").createEntityManager();
        //JPA_Baithi_MariaDB
        //JPA_Baithi_MSSQL

        PositionDao positionDao = new PositionImpl();
        positionDao.listPositions("S", 10000, 20000).forEach(System.out::println);
    }
}
