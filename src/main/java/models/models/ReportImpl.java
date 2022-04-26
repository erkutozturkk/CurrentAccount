package models;

import props.Orders;
import utils.DB;

import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReportImpl implements IReport {
    DB db = new DB();
    @Override
    public List<Orders> ReportOrderList() {
        List<Orders> orders = new ArrayList<>();
        try {
            String sql = "select cid,ktid,pid,name,ct_name,product_name,piece,date from orders " +
                    "inner join products on orders.pid = products.pid " +
                    "inner join categories on categories.ktid = products.ctid" +
                    "inner join customers on customers.cid = products.cid ";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();//satir ve sutun haline getirir. Iterator gibi calisir, tuketilince tekrar olusturmak gerekir.
            while (rs.next()){//son elemana kadar true doner, ilgili satir.
                int cid = rs.getInt("cid");
                int ktid = rs.getInt("ktid");
                int pid = rs.getInt("cid");
                String name = rs.getString("name");
                String ct_name = rs.getString("ct_name");
                String product_name = rs.getString("product_name");
                int piece = rs.getInt("piece");
                String date = rs.getString("date");
                /*Customer c = new Customer(cid,name,surname,email,phone);
                Service s = new Service(sid,cid,title,date,status,c);
                service.add(s);*/
            }
        }catch (Exception ex){
            System.err.println("ReportOrderList error" + ex );
        }
        finally {
            db.close();
        }
        return orders;
    }

    @Override
    public DefaultTableModel reportOrderTable() {
        return null;
    }
}
