/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionefile;
import java.io.IOException;
import java.io.FileReader;
/**
 *
 * @author Magdalena
 */
public class Lettore extends Thread{
    String nomeFile;
    
    public Lettore(String nomeFile){
        this.nomeFile = nomeFile;
    }
    
    public void leggi(){
        FileReader fr;
        int i;
        try{
            fr = new FileReader(nomeFile);
            while((i=fr.read()) != -1)
                System.out.println((char) i);
            
            System.out.println("\n\r");
            fr.close();
        } catch(IOException ex){
            System.err.println("Errore in lettura!");
        }
    }
    @Override
    public void run(){
        leggi();
    }
}

