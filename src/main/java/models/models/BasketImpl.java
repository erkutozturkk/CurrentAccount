package models;

import props.Basket;
import props.Categories;
import props.Customers;
import props.Products;
import utils.DB;

import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BasketImpl implements IBasket {
    DB db = new DB();
    List<Basket> ls = new ArrayList<>();
    int customerId;

    public BasketImpl() {
    }

    public BasketImpl(int customerId) {
        this.customerId = customerId;
        ls = basketList();
    }

    @Override
    public int basketInsert(Basket basket) {
        int status=0;
        try{
            String sql="insert into basket values(null,?,?,?,?,?,?,?)";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setInt(1,basket.getCid());
            pre.setInt(2,basket.getPid());
            pre.setInt(3,basket.getKtid());
            pre.setString(4,basket.getUuid());
            pre.setString(5,basket.getDate());
            pre.setInt(6,basket.getAmount());
            pre.setInt(7,basket.getStatus());
            status = pre.executeUpdate();
        }catch (Exception ex){
            System.err.println("basketInsert Error : " +ex);
        }
        finally {
            db.close();
        }
        return status;
    }

    @Override
    public int basketDelete(int bid) {
        int status=0;
        try{
            String sql="delete from basket where bid = ?";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setInt(1,bid);
            status = pre.executeUpdate();
        }catch (Exception ex){
            System.out.println("basketDelete Error : " +ex);
        }
        finally {
            db.close();
        }
        return status;
    }

    @Override
    public int basketUpdate(int cid) {
        int status = 0;
        try{
            String sql=" update basket set status= ?  where cid=?";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setInt(1,1);
            pre.setInt(2,cid);
            status = pre.executeUpdate();
        }catch (Exception ex){
            System.out.println("basketUpdate Error : " +ex);
        }
        finally {
            db.close();
        }
        return status;
    }




    @Override
    public List<Basket> basketList() {
        List<Basket> basketList = new ArrayList<>();
        try {
            String sql = "select bid, c.cid, c.name, p.pid, product_name, cat.ktid, ct_name, uuid, date, amount, status from basket inner join customers c on  basket.cid = c.cid inner join products p on  basket.pid = p.pid inner join categories cat on  basket.ktid = cat.ktid order by bid desc";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int bid=rs.getInt("bid");
                int cid=rs.getInt("cid");
                String name= rs.getString("name");
                int pid=rs.getInt("pid");
                String product_name=rs.getString("product_name");
                int ktid=rs.getInt("ktid");
                String  ct_name=rs.getString("ct_name");
                String uuid=rs.getString("uuid");
                String date =rs.getString("date");
                int amount=rs.getInt("amount");
                int status=rs.getInt("status");
                Customers customers = new Customers(name);
                Products products = new Products(product_name);
                Categories categories = new Categories(ct_name);
                Basket basket = new Basket(bid,cid,pid,ktid, uuid, date, amount, status,  customers, products, categories);
               basketList.add(basket);
        }}catch (Exception ex) {
            System.err.println("basketList Error : " +ex);
        }
        return basketList;
    }

    @Override
    public DefaultTableModel basketTableModel( ) {
        List<Basket> basketLs = new ArrayList<>();
        DefaultTableModel md = new DefaultTableModel();
        md.addColumn("Basket No");
        md.addColumn("CustomerName");
        md.addColumn("ProductName");
        md.addColumn("CategoryName");
        md.addColumn("Date");
        md.addColumn("Amount");
        md.addColumn("Status");
        basketLs = basketList();

        for (Basket item : ls) {
            Object[] row = {item.getBid(), item.getCustomer().getName(), item.getProduct().getProduct_name(),item.getCategory().getCt_name(),
                    item.getDate(), item.getAmount(),item.getStatus()};
            md.addRow(row);
        }
        return md;
    }
}
