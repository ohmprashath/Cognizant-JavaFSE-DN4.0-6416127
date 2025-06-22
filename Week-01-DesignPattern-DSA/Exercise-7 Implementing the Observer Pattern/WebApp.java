public class WebApp implements Observer {
    public void update(float price) {
        System.out.println("Web App - Price: " + price);
    }
}
