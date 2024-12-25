package daoImpl;

import dao.ItemDao;
import entity.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class ItemImpl implements ItemDao {
    private EntityManager em;

    public ItemImpl() {
        em = Persistence.createEntityManagerFactory("JPA_Baithi_MSSQL").createEntityManager();
    }

    @Override
    public List<Item> listItems(String supplierName) {
        try {
            return em.createNamedQuery("Item.ds", Item.class)
                    .setParameter("name","%" + supplierName+ "%")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
