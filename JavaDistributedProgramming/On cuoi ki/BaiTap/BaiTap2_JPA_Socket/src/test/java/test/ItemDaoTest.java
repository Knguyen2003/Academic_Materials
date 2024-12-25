package test;

import dao.ItemDao;
import daoImpl.ItemImpl;
import entity.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertNotEquals;

public class ItemDaoTest {
    private ItemDao itemDao;

    public void setUp(){
        itemDao = new ItemImpl();
    }

    @Test
    public void testListItems(){
        setUp();
        List<Item> items = itemDao.listItems("anNA");
        for (Item item : items) {
            System.out.println(item);
        }
//        assertNotEquals(0, items.size());
    }


    @AfterEach
    public void tearDown(){
        itemDao = null;
    }

}
