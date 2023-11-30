package Hangman;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

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
        Set<Character> guessedLettersSet = new HashSet<>();
        int correctGuesses = 0;

        System.out.println("HANGMAN");
        System.out.println(String.valueOf(guessedLetters));
        Scanner scanner = new Scanner(System.in);

        while (attempts > 0) {
            System.out.print("Input a letter: > ");
            String input = scanner.nextLine().toLowerCase();

            if (input.length() != 1) {
                System.out.println("You should input a single letter");
                System.out.println(String.valueOf(guessedLetters));
                continue;
            }

            char guess = input.charAt(0);

            if (!Character.isLowerCase(guess)) {
                System.out.println("Please enter a lowercase English letter");
                System.out.println(String.valueOf(guessedLetters));
                continue;
            }

            if (guessedLettersSet.contains(guess)) {
                System.out.println("You've already guessed this letter");
                System.out.println(String.valueOf(guessedLetters));
                continue;
            }

            boolean isCorrect = false;

            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == guess && guessedLetters[i] != guess) {
                    guessedLetters[i] = guess;
                    guessedLettersSet.add(guess);
                    isCorrect = true;
                    correctGuesses++;
                }
            }

            if (!isCorrect) {
                attempts--;
                System.out.println("That letter doesn't appear in the word");
            }

            System.out.println(String.valueOf(guessedLetters));

            if (correctGuesses == secretWord.length()) {
                System.out.println("You guessed the word " + secretWord + "!");
                System.out.println("You survived!");
                return;
            } else if (attempts == 0) {
                System.out.println("You lost!");
                return;
            }
        }
    }
}
