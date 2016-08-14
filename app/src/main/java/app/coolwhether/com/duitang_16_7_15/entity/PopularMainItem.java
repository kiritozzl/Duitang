package app.coolwhether.com.duitang_16_7_15.entity;

/**
 * Created by Administrator on 2016/8/14.
 */
public class PopularMainItem {
    private int imgId;
    private String imgDesci;
    private int thumbImgId;
    private String userName;
    private String collect;
    private int collectNumber;

    public PopularMainItem() {
    }

    public PopularMainItem(int imgId, String imgDesci, int thumbImgId, String userName, String collect, int collectNumber) {
        this.imgId = imgId;
        this.imgDesci = imgDesci;
        this.thumbImgId = thumbImgId;
        this.userName = userName;
        this.collect = collect;
        this.collectNumber = collectNumber;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getImgDesci() {
        return imgDesci;
    }

    public void setImgDesci(String imgDesci) {
        this.imgDesci = imgDesci;
    }

    public int getThumbImgId() {
        return thumbImgId;
    }

    public void setThumbImgId(int thumbImgId) {
        this.thumbImgId = thumbImgId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCollect() {
        return collect;
    }

    public void setCollect(String collect) {
        this.collect = collect;
    }

    public int getCollectNumber() {
        return collectNumber;
    }

    public void setCollectNumber(int collectNumber) {
        this.collectNumber = collectNumber;
    }
}
