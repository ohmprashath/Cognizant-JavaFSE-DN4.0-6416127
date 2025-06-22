public class Main {
    public static void main(String[] args) {
        PaymentContext ctx1 = new PaymentContext(new CreditCardPayment());
        ctx1.pay(1000);

        PaymentContext ctx2 = new PaymentContext(new PayPalPayment());
        ctx2.pay(500);
    }
}
