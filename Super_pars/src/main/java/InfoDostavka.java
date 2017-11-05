import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class InfoDostavka {
    public void inf_start(String url, String tag) throws IOException {
        Connector c = new Connector();
        Elements info = c.init(url, tag);
        int count = 0;
        for(Element i: info){
            if(count > 0){
                this.page_prod(i.select("a").attr("href"), ".g-i-tile-i-title");
            }
            count += 1;
        }
    }
    public void page_prod(String url, String tag) throws IOException {
        Connector c1 = new Connector();
        Elements items = c1.init(url, tag);
        for(Element i: items){
            this.page_rew(i.select("a").attr("href") + "/comments", ".pp-review-inner", ".detail-tabs");
        }
    }
    public void page_rew(String url, String tag1, String tag2) throws IOException {
        Connector c2 = new Connector();
        Elements marks = c2.init(url, tag1);
        Elements nums = c2.init(url, tag2);
        if(nums.select(".m-tabs-i-comments").text().length() < 1){
            System.out.println("0 " + "reviews from" + " " + url);
        }else{
            System.out.println(nums.select(".m-tabs-i-comments").text() + " " + "reviews from" + " " + url);
        }
        InfoWriter notalschik = new InfoWriter();
        notalschik.pushu(marks);
    }
}
