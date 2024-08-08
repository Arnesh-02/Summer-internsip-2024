import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {
    private static HashMap<String, Double> exchangeRates;

    static {
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.75);
        exchangeRates.put("INR", 74.0);
    }

    public static double convertCurrency(String baseCurrency, String targetCurrency, double amount) {
        double baseRate = exchangeRates.getOrDefault(baseCurrency, 1.0);
        double targetRate = exchangeRates.getOrDefault(targetCurrency, 1.0);
        return amount * (targetRate / baseRate);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available currencies: USD, EUR, GBP, INR");

        System.out.print("Enter base currency: ");
        String baseCurrency = scanner.next().toUpperCase();
        System.out.print("Enter target currency: ");
        String targetCurrency = scanner.next().toUpperCase();
        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        double convertedAmount = convertCurrency(baseCurrency, targetCurrency, amount);
        System.out.println(amount + " " + baseCurrency + " = " + convertedAmount + " " + targetCurrency);
    }
}
