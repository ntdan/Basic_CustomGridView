package vn.cusc.customgridview;

/**
 * Created by ntdan on 6/6/2017.
 */
public class Toy {
    String ten;
    int hinh;

    public Toy(String ten, int hinh) {
        this.ten = ten;
        this.hinh = hinh;
    }

    public Toy() {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
