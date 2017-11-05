import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        InfoDostavka parser = new InfoDostavka();
        parser.inf_start("https://rozetka.com.ua/ua/gps-navigators/c80047/", ".paginator-catalog-l-link");
    }
}