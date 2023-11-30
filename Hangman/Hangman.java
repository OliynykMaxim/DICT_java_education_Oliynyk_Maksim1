package Hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        String[] wordList = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        int randomIndex = random.nextInt(wordList.length);
        String secretWord = wordList[randomIndex];

        String hint = getHint(secretWord); // Отримуємо підказку

        System.out.println("HANGMAN");
        System.out.print("Guess the word " + hint + ": > ");

        Scanner scanner = new Scanner(System.in);
        String guessedWord = scanner.nextLine().toLowerCase();

        if (guessedWord.equals(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }

    // Метод для отримання підказки
    private static String getHint(String word) {
        StringBuilder hint = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (i < 2) {
                hint.append(word.charAt(i));
            } else {
                hint.append("-");
            }
        }
        return hint.toString();
    }
}





