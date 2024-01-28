/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionefile;
import java.util.Scanner;
/**
 *
 * @author Magdalena
 */
public class GestioneFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Lettore lettore = new Lettore(" user.json ");
        lettore.start();
        scan.nextLine();
        System.out.println("Inserisci username:");
        String username = scan.nextLine();
        System.out.println("Inserisci password:");
        String password = scan.nextLine();
        Scrittore scrittore = new Scrittore("output.csv", username, password);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
    } // TODO code application logic here
    
    
}
