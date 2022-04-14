package props;

public class Users {
    private int uid;
    private String user_email;
    private String password;

    public Users() {
    }

    public Users(int uid, String user_email, String password) {
        this.uid = uid;
        this.user_email = user_email;
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", user_email='" + user_email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
