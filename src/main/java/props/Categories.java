package props;

public class Categories {
    private int ktid;
    private String ct_name;
    private String ct_detail;

    public Categories() {
    }

    public Categories(int ktid, String ct_name, String ct_detail) {
        this.ktid = ktid;
        this.ct_name = ct_name;
        this.ct_detail = ct_detail;
    }

    public int getKtid() {
        return ktid;
    }

    public void setKtid(int ktid) {
        this.ktid = ktid;
    }

    public String getCt_name() {
        return ct_name;
    }

    public void setCt_name(String ct_name) {
        this.ct_name = ct_name;
    }

    public String getCt_detail() {
        return ct_detail;
    }

    public void setCt_detail(String ct_detail) {
        this.ct_detail = ct_detail;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "ktid=" + ktid +
                ", ct_name='" + ct_name + '\'' +
                ", ct_detail='" + ct_detail + '\'' +
                '}';
    }
}

