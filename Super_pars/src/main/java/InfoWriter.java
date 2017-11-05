import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class InfoWriter {
    public void pushu(Elements marks) throws IOException {
        String mark, review;
        FileWriter writer = new FileWriter("result.csv", true);
        BufferedWriter bufferWriter = new BufferedWriter(writer);
        for(Element i: marks){
            mark = i.select(".g-rating-stars-i").attr("content");
            if(mark.length() < 1){
                mark = "0";
            }
            review = i.select(".pp-review-text-i").text();
            bufferWriter.write(mark + "," + review + "\n");
        }
        bufferWriter.close();
    }
}
