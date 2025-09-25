package Task2;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);

        System.out.println("Добро пожаловать в обменник валют!");

        double amount;
        while (true) {
            try {
                System.out.println("Введите сумму (RUB) для обмена");
                System.out.print("Сумма: ");
                amount = input.nextDouble();
                if (amount < 0) {
                    System.out.println("Неккоректный ввод, попробуйте еще раз!");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Неккоректный ввод, попробуйте еще раз!");
                input.nextLine();
            }
        }

        Map<String, Double> exchangeRate = new LinkedHashMap<>();
        exchangeRate.put("USD", 83.35);
        exchangeRate.put("EUR", 99.04);
        exchangeRate.put("JPY", 0.5624);
        exchangeRate.put("GBR", 112.48);
        exchangeRate.put("СТН", 11.7);

        while (true) {
            try {
                System.out.println("Выберите метод задания курса валют: ");
                System.out.println("1 - Константные значения курса");
                System.out.println("2 - Ввод значений курса самостоятельно");
                System.out.print("Выбор метода: ");
                int choice = input.nextInt();
                if (choice == 2) {
                    for (var rate : exchangeRate.entrySet()) {
                        while (true) {
                            try {
                                System.out.println("Введите курс обмена (относителльно рубля) для валюты " + rate.getKey());
                                System.out.print("Курс обмена (относительно рубля): ");
                                double value = input.nextDouble();
                                if (value < 0) {
                                    System.out.println("Неккоректный ввод, попробуйте еще раз!");
                                    continue;
                                }
                                rate.setValue(value);
                                break;
                            } catch (Exception e) {
                                System.out.println("Неккоректный ввод, попробуйте еще раз!");
                                input.nextLine();
                            }
                        }
                    }
                } else if (choice != 1) {
                    System.out.println("Неккоректный ввод, попробуйте еще раз!");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Неккоректный ввод, попробуйте еще раз!");
                input.nextLine();
            }
        }

        MoneyExchanger exchanger = new MoneyExchanger(amount, exchangeRate);
        exchanger.start();
    }
}
