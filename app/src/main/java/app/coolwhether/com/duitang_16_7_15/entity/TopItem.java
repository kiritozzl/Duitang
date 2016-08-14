package app.coolwhether.com.duitang_16_7_15.entity;

/**
 * Created by Administrator on 2016/8/14.
 */
public class TopItem {
    private int imageSource;
    private String time;
    private String title;

    public TopItem(int imageSource, String title, String time) {
        this.imageSource = imageSource;
        this.time = time;
        this.title = title;
    }

    public int getImageSource() {
        return imageSource;
    }

    public void setImageSource(int imageSource) {
        this.imageSource = imageSource;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
