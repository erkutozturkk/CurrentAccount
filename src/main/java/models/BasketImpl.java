package models;

import props.Basket;
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
            String sql = "";
            if (customerId == -1)
                sql = "select * from basket";
            else {
                sql = "select * from basket where cid=?";
            }
            PreparedStatement pre = db.connect().prepareStatement(sql);
        }catch (Exception ex) {
            System.err.println("basketList Error : " +ex);
        }
        return null;
    }

    @Override
    public DefaultTableModel basketTableModel() {
        DefaultTableModel md = new DefaultTableModel();
        md.addColumn("bid");
        md.addColumn("cid");
        md.addColumn("pid");
        md.addColumn("ktid");
        md.addColumn("uuid");
        md.addColumn("date");
        md.addColumn("amount");
        md.addColumn("status");

        for (Basket item : ls) {
            Object[] row = {item.getBid(), item.getCid(), item.getPid(),item.getKtid(),
                    item.getUuid(), item.getDate(), item.getAmount(),item.getStatus()};
            md.addRow(row);
        }
        return md;
    }
}
