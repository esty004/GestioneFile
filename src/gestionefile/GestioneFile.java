/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionefile;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class GestioneFile {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Lettore lettore = new Lettore("user.json");
        lettore.start();
        scan.nextLine();
        System.out.println("Inserisci username:");
        String username = scan.nextLine();
        System.out.println("Inserisci password:");
        String password = scan.nextLine();
        System.out.println("Inserisci chiave per la crittografia:");
        String chiave = scan.nextLine();

        // Cripta la password con Vigenère utilizzando la chiave inserita dall'utente
        String passwordCifrata = criptaVigenere(password, chiave);

        Scrittore scrittore = new Scrittore("output.csv", username, passwordCifrata);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
        Lettore lettore2 = new Lettore("output.csv");
        lettore2.start();
    }

    private static String criptaVigenere(String password, String chiave) {
        StringBuilder passwordCifrata = new StringBuilder();

        for (int i = 0; i < password.length(); i++) {
            char carattere = password.charAt(i);
            char chiaveCorrispondente = chiave.charAt(i % chiave.length());

            // Esegue la cifratura di Vigenère
            char carattereCifrato = (char) ((carattere + chiaveCorrispondente) % 128);

            passwordCifrata.append(carattereCifrato);
        }

        return passwordCifrata.toString();
    }
}
