package Hangman;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");
        System.out.print("Guess the word: > ");

        Scanner scanner = new Scanner(System.in);
        String guessedWord = scanner.nextLine().toLowerCase(); // припустимо, слово заздалегідь встановлено і переведено у нижній регістр

        // Припустимо, що слово для вгадування - "java"
        String secretWord = "java";

        if (guessedWord.equals(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}

