import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Connector {
    public Elements init(String url, String tag) throws IOException {
        String main_url = url;
        Document doc = Jsoup.connect(main_url).get();
        Elements info = doc.select(tag);
        return info;
    }
}
