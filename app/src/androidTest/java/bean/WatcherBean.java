package bean;

/**
 * Created by elon on 2016/10/17.
 */
public class WatcherBean {


    public String getWatch() {
        return watch;
    }

    public void setWatch(String watch) {
        this.watch = watch;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getZan() {
        return zan;
    }

    public void setZan(String zan) {
        this.zan = zan;
    }

    private String comments;
    private String zan;
    private String watch;

    @Override
    public String toString() {
        return "WatcherBean{" +
                "comments='" + comments + '\'' +
                ", zan='" + zan + '\'' +
                ", watch='" + watch + '\'' +
                '}';
    }
}
