/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionefile;

import java.io.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Magdalena
 */
public class Scrittore implements Runnable {

    String nomeFile;
    String username;
    String password;

    public Scrittore(String nomeFile, String username, String password) {
        this.nomeFile = nomeFile;
        this.username = username;
        this.password = password;
    }

    public void scrivi() {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile))) {
            br.write("<" + username + ">");
            br.write("\n\r");
            br.write("<" + password + ">");
            br.write("\n\r");
            br.flush();

        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (DataInputStream rd = new DataInputStream(new FileInputStream("user.json")); DataOutputStream wr = new DataOutputStream(new FileOutputStream("user.csv"))) {
            int bytesRead;
            byte[] buffer = new byte[1024];

            while ((bytesRead = rd.read(buffer)) != -1) {
                wr.write(buffer, 0, bytesRead);
            }
        } catch(IOException e){
            System.err.println("Errore durante la copiatura del file");
        }
    }

    @Override
    public void run() {
        scrivi();
    }
}
