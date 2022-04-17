package models;

import props.Customers;
import props.Products;
import utils.DB;

import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrderImpl implements IOrder {

    DB db = new DB();
    List<Customers> lsc = new ArrayList<>();
    List<Products> lsp = new ArrayList<>();
    List<Customers> lsSearch = new ArrayList<>();

    public OrderImpl() {
        lsc = orderCustomersList();
        lsSearch = lsc;
    }

    @Override
    public List<Products> orderProductsList() {
    List<Products> lsp = new ArrayList<>();
        return null;
    }


    @Override
    public DefaultTableModel orderProductsTable(int ktid) {
        return null;
    }


    @Override
    public List<Customers> orderCustomersList() {
        List<Customers> customersList = new ArrayList<>();
        try {
            String sql = "select * from customers order by cid desc";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            customersList.clear();

            while (rs.next()) {
                int cid = rs.getInt("cid");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");

                Customers customer = new Customers(cid, name, surname, phone, email, address);
                customersList.add(customer);

            }
        } catch (Exception ex) {
            System.err.println("serviceCustomerList Error: " + ex.toString());
            ex.printStackTrace();
        } finally {
            db.close();
        }
        return customersList;
    }

    @Override
    public DefaultTableModel orderCustomersTable(String cData) {
        lsc = lsSearch;
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cid");
        model.addColumn("Name");
        model.addColumn("Surname");
        model.addColumn("Phone");
        model.addColumn("Email");
        model.addColumn("Address");

        if (cData != null && !cData.equals("")) {
            cData = cData.toLowerCase(Locale.ROOT);
            List<Customers> csubLs = new ArrayList<>();
            for (Customers item : lsc) {
                if (item.getName().toLowerCase(Locale.ROOT).contains(cData)
                        || item.getSurname().toLowerCase(Locale.ROOT).contains(cData)
                        || item.getPhone().toLowerCase(Locale.ROOT).contains(cData)
                        || item.getEmail().toLowerCase(Locale.ROOT).contains(cData)
                        || item.getAddress().toLowerCase(Locale.ROOT).contains(cData)) {
                    csubLs.add(item);
                }
                for (Customers item1 : lsc) {
                    Object[] row = {item1.getCid(), item1.getName(), item1.getSurname(), item1.getPhone(), item1.getEmail(), item1.getAddress()};
                    model.addRow(row);
                }
            }
        }
        return model;
    }
}





