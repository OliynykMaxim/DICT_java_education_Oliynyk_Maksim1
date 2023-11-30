package Hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        String[] wordList = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        int randomIndex = random.nextInt(wordList.length);
        String secretWord = wordList[randomIndex];
        char[] guessedLetters = new char[secretWord.length()];

        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '-';
        }

        int attempts = 8;
        int incorrectGuesses = 0;

        System.out.println("HANGMAN");
        System.out.println(String.valueOf(guessedLetters));
        Scanner scanner = new Scanner(System.in);

        while (attempts > 0) {
            System.out.print("Input a letter: > ");
            char guess = scanner.nextLine().toLowerCase().charAt(0);
            boolean isCorrect = false;

            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == guess && guessedLetters[i] != guess) {
                    guessedLetters[i] = guess;
                    isCorrect = true;
                }
            }

            if (!isCorrect) {
                attempts--;
                incorrectGuesses++;
                System.out.println("That letter doesn't appear in the word");
            } else {
                if (String.valueOf(guessedLetters).equals(secretWord) && attempts > 0) {
                    System.out.println("You guessed the word!");
                    System.out.println("You survived!");
                    return;
                } else if (incorrectGuesses == 0) {
                    System.out.println("No improvements");
                }
            }

            System.out.println(String.valueOf(guessedLetters));

            if (attempts == 0) {
                System.out.println("You lost!");
            }
        }
    }
}
