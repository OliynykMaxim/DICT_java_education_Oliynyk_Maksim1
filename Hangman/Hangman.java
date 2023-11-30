package Hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        String[] wordList = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        int randomIndex = random.nextInt(wordList.length);
        String secretWord = wordList[randomIndex];

        System.out.println("HANGMAN");
        System.out.print("Guess the word: > ");

        Scanner scanner = new Scanner(System.in);
        String guessedWord = scanner.nextLine().toLowerCase();

        if (guessedWord.equals(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}


