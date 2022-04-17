package models;

import props.Users;
import utils.DB;
import utils.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserImpl implements IUsers{
    DB db = new DB();
    public static String userName = "";
    public static int uid = 0;
    @Override
    public boolean usersLogin(String email, String password) {
        boolean status= false;
        try {
            String sql="select * from user where email=? and password=?";
            PreparedStatement pre=db.connect().prepareStatement(sql);
            pre.setString(1,email);
            pre.setString(2, Util.MD5(password));
            ResultSet rs=pre.executeQuery();
            status=rs.next();
            if(status){
                userName = rs.getString("name")+" "+rs.getString("surname");
                uid =rs.getInt("uid");
            }
        }catch (Exception e){
            System.out.println("UserLogin error: "+e);
        }finally {
            db.close();
        }
        return status;
    }

    @Override
    public int usersUpdate(Users users) {
        int status=0;

        try {
            String sql="update user set user_name=?,  user_surname=?,  user_email=?,  password=? where uid=?";
            PreparedStatement pre=db.connect().prepareStatement(sql);
            pre.setString(1, users.getUser_name());
            pre.setString(2, users.getUser_surname());
            pre.setString(3,users.getUser_email());
            pre.setString(4, Util.MD5(users.getPassword()));
            pre.setInt(5, users.getUid());
            status= pre.executeUpdate();
        }catch (Exception e){
            System.err.println("usersUpdate Error: "+ e);
        }finally {
            db.close();
        }
        return status;
    }
}

