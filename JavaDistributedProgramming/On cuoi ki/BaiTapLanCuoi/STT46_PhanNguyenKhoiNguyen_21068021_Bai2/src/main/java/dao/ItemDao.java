package dao;

import entity.Item;

import java.util.List;

public interface ItemDao {
    public List<Item> listItems (String supplierName);
}
