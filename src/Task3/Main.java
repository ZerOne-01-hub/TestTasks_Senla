package Task3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Добро пожаловать в генератор паролей!");

        int passwordLength;
        while (true) {
            try {
                System.out.println("Введите длину пароля (8-12 символов)");
                System.out.print("Длина пароля: ");
                passwordLength = input.nextInt();

                if (passwordLength < 8 || 12 < passwordLength) {
                    System.out.println("Неверный ввод, попробуйте еще раз");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Неккоректный ввод, попробуйте еще раз!");
                input.nextLine();
            }
        }

        passwordGenerator generator = new passwordGenerator(passwordLength);
        generator.start();
    }
}
