public class Main {
    public static void main(String[] args) {
        Notifier notifier = new SMSNotifierDecorator(
                new SlackNotifierDecorator(
                        new EmailNotifier()));
        notifier.send("Server down");
    }
}
