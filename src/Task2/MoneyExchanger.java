package Task2;

import java.util.Map;

public class MoneyExchanger {

    private double currentAmount;
    private Map<String, Double> exchangeRate;

    public MoneyExchanger(double currentAmount, Map<String, Double> exchangeRate) {
        this.currentAmount = currentAmount;
        this.exchangeRate = exchangeRate;
    }

    public void start() throws InterruptedException {
        System.out.println("=======================");
        System.out.println("Курс обмена");
        for (var rate: exchangeRate.entrySet()) {
            System.out.println("1 " +  rate.getKey() + " - " + rate.getValue() + " RUB");
            Thread.sleep(500);
        }
        Thread.sleep(1000);
        System.out.println("=======================");
        System.out.println("Расчет обмена валют:");
        for (var rate: exchangeRate.entrySet()) {
            System.out.printf("%.2f RUB = %.2f %s%n", currentAmount, currentAmount/ rate.getValue(), rate.getKey());
            Thread.sleep(500);
        }
    }
}
