package Task3;

import java.security.SecureRandom;
import java.util.Random;

public class passwordGenerator {

    private int passwordLength;
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+-=[]{}|;:,.<>?";
    private static final String ALL_CHARS = UPPER_CASE + LOWER_CASE + DIGITS + SPECIAL_CHARS;
    private String password = "";

    Random random = new Random();
    private static final SecureRandom RANDOM = new SecureRandom();

    public passwordGenerator(int passwordLength) {
        this.passwordLength = passwordLength;
    }

    private static String shuffleString(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int randomIndex = RANDOM.nextInt(chars.length);
            char temp = chars[i];
            chars[i] = chars[randomIndex];
            chars[randomIndex] = temp;
        }
        return new String(chars);
    }

    public void start() {
        password += UPPER_CASE.charAt(random.nextInt(UPPER_CASE.length()));
        password += LOWER_CASE.charAt(random.nextInt(LOWER_CASE.length()));
        password += DIGITS.charAt(random.nextInt(DIGITS.length()));
        password += SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length()));

        for (int i=0; i < (passwordLength - 4); i++) {
            password += ALL_CHARS.charAt(random.nextInt(ALL_CHARS.length()));
        }

        password = shuffleString(password);
        System.out.println("Пароль сгенерирован!");
        System.out.print("Ваш пароль: " + password);

    }

}
