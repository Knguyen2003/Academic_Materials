package test;


import dao.ItemDao;

import daoImpl.ItemImpl;
import entity.Item;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import java.util.List;

public class ItemDaoTest {
    private ItemDao itemDao;


    public void setUp() {
        itemDao = new ItemImpl();
    }

    @Test
    public void testListItems(){
        setUp();
        List<Item> items = itemDao.listItems("S114");
        items.forEach(System.out::println);
    }



    @AfterEach
    public void tearDown() {
        itemDao = null;
    }
}
