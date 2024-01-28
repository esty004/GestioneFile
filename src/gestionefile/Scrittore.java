/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionefile;

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
        BufferedWriter br = null;

        try {
            synchronized (nomeFile) {
                br = new BufferedWriter(new FileWriter(nomeFile));
                br.write("<" + username + ">");
                br.write("\n\r");
                br.write("<" + password + ">");
                br.write("\n\r");
                br.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (br != null)
                try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void run() {
        scrivi();
    }
}
