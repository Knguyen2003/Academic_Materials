package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class test {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("JPA_Baithi_MSSQL").createEntityManager();
        //JPA_Baithi_MSSQL
        //JPA_Baithi_MariaDB
    }
}
