package Task1;

import java.util.Scanner;

public class Game {

    Scanner input = new Scanner(System.in);

    private String currentWord;
    private int HP = 6;
    private int foundLetters = 0;
    private String wordWithGuessedLetters;
    private String currentLetter;

    public Game(String currentWord) {
        this.currentWord = currentWord;
        wordWithGuessedLetters = "_".repeat(currentWord.length());
    }

    private void openLettersInWord(char currentLetter) {
        char[] wordArray = wordWithGuessedLetters.toCharArray();
        for (int i = 0; i < currentWord.length(); i++) {
            if (currentWord.charAt(i) == currentLetter) {
                wordArray[i] = currentLetter;
                foundLetters++;
            }
        }
        wordWithGuessedLetters = new String(wordArray);
    }

    private static final String[] HUMAN = {

            "  _ _ _ \n" +
                    " |     |\n" +
                    " |     \n" +
                    " |     \n" +
                    " |     \n" +
                    " |     \n" +
                    " |     \n" +
                    "/ \\    \n",

            "  _ _ _ \n" +
                    " |     |\n" +
                    " |     0\n" +
                    " |     \n" +
                    " |     \n" +
                    " |     \n" +
                    " |     \n" +
                    "/ \\    \n",

            "  _ _ _ \n" +
                    " |     |\n" +
                    " |     0\n" +
                    " |     |\n" +
                    " |     \n" +
                    " |     \n" +
                    " |     \n" +
                    "/ \\    \n",

            "  _ _ _ \n" +
                    " |     |\n" +
                    " |     0\n" +
                    " |    /|\n" +
                    " |     \n" +
                    " |     \n" +
                    " |     \n" +
                    "/ \\    \n",

            "  _ _ _ \n" +
                    " |     |\n" +
                    " |     0\n" +
                    " |    /|\\\n" +
                    " |     \n" +
                    " |     \n" +
                    " |     \n" +
                    "/ \\    \n",

            "  _ _ _ \n" +
                    " |     |\n" +
                    " |     0\n" +
                    " |    /|\\\n" +
                    " |    / \n" +
                    " |     \n" +
                    " |     \n" +
                    "/ \\    \n",

            "  _ _ _ \n" +
                    " |     |\n" +
                    " |     0\n" +
                    " |    /|\\\n" +
                    " |    / \\\n" +
                    " |     \n" +
                    " |     \n" +
                    "/ \\    \n"
    };

    private boolean isLetterInWord(String letter) {
        return currentWord.contains(letter);
    }

    private  boolean isRussianLetter(String letter) {
        if (letter == null || letter.length() != 1) {
            return false;
        }
        char ch = letter.charAt(0);
        return (ch >= 'а' && ch <= 'я') || (ch >= 'А' && ch <= 'Я') || (ch == 'ё') || (ch == 'Ё');
    }

    public void start() throws InterruptedException {
        while (true) {
            while (true) {
                System.out.println("======================");
                System.out.println("Введите букву");
                System.out.print("Буква: ");
                currentLetter = input.nextLine().toLowerCase();
                if (!isRussianLetter(currentLetter)) {
                    System.out.println("Неверный ввод, попробуйте еще раз!");
                    continue;
                }
                break;
            }

            if (!isLetterInWord(currentLetter)) {
                HP--;
            } else {
                openLettersInWord(currentLetter.charAt(0));
            }

            if (HP > 0 && foundLetters != currentWord.length()) {
                System.out.println(HUMAN[6 - HP]);
                Thread.sleep(500);
                System.out.println("У вас осталось " + HP + " жизней");
                Thread.sleep(500);
                System.out.println("Слово: " + wordWithGuessedLetters);
                Thread.sleep(500);
                System.out.println("Игра продолжается!");
            } else if (HP > 0) {
                System.out.println(HUMAN[6-HP]);
                Thread.sleep(500);
                System.out.println("У вас осталось " + HP + " жизней");
                Thread.sleep(500);
                System.out.println("Загаданное слово: " + currentWord);
                Thread.sleep(500);
                System.out.print("Вы победили!");
                break;
            } else {
                System.out.println(HUMAN[6-HP]);
                Thread.sleep(500);
                System.out.println("Осталось жизней: " + HP);
                Thread.sleep(500);
                System.out.println("Загаданное слово: " + currentWord);
                Thread.sleep(500);
                System.out.print("Вы проиграли!");
                break;
            }
        }
    }
}
