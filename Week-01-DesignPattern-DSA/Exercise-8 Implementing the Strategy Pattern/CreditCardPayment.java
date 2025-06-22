public class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid by Credit Card: " + amount);
    }
}
