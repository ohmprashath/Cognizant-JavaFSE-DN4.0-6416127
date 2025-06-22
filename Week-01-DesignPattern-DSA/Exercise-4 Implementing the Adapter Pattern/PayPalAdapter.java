public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypal = new PayPalGateway();

    public void processPayment(double amount) {
        paypal.send(amount);
    }
}
