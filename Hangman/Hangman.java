package Hangman;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("HANGMAN");

        while (true) {
            System.out.println("Type 'play' to play the game, 'exit' to quit: > ");
            String input = scanner.nextLine().toLowerCase();

            if (!input.equals("play") && !input.equals("exit")) {
                System.out.println("Please enter a valid option.");
                continue;
            }

            if (input.equals("exit")) {
                System.out.println("Goodbye!");
                break;
            }

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

            System.out.println("----------");
            System.out.println(String.valueOf(guessedLetters));

            while (attempts > 0) {
                System.out.print("Input a letter: > ");
                String guessInput = scanner.nextLine().toLowerCase();

                if (guessInput.length() != 1 || !Character.isLowerCase(guessInput.charAt(0))) {
                    System.out.println("Please enter a single lowercase English letter.");
                    continue;
                }

                char guess = guessInput.charAt(0);

                if (guessedLettersSet.contains(guess)) {
                    System.out.println("You've already guessed this letter.");
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
                    System.out.println("That letter doesn't appear in the word.");
                }

                System.out.println(String.valueOf(guessedLetters));

                if (correctGuesses == secretWord.length()) {
                    System.out.println("You guessed the word " + secretWord + "!");
                    System.out.println("You survived!");
                    break;
                } else if (attempts == 0) {
                    System.out.println("You lost!");
                    break;
                }
            }
        }
    }
}

