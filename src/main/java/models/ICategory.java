package models;

import props.Categories;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public interface ICategory {
    int categoryInsert(Categories categories);
    int categoryUpdate(Categories categories, int ktid);
    int categoryDelete(int ktid);
    List<Categories> categoryList();
    DefaultTableModel categoriesTable();
}
