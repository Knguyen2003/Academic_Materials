package daoImpl;

import dao.ItemDao;
import entity.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class ItemImpl implements ItemDao {
    private EntityManager em;

    public ItemImpl() {
        em= Persistence.createEntityManagerFactory("JPA_Baithi_MSSQL").createEntityManager();
    }


    @Override
    public List<Item> listItems(String supplierName) {
         return em.createNamedQuery("Item.listItems", Item.class).setParameter("name", "%"+ supplierName + "%").getResultList();
    }
}
