package models;

import props.Basket;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public interface IBasket {
    int basketInsert(Basket basket);
    int basketDelete(int bid);
    int basketUpdate(int cid);
    List<Basket> basketList();
    DefaultTableModel basketTableModel();
}
