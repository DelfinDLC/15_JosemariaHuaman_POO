/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package S05_11JosemariaHuaman;

/**
 *
 * @author josem
 */
import javax.swing.JOptionPane;



public class Estudiante_11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String estudiante;
        int edad;
       
        estudiante=JOptionPane.showInputDialog("Nombre del Estudiante");
        edad = Integer.parseInt(JOptionPane.showInputDialog("Edad del Estudiante"));
        JOptionPane.showMessageDialog(null, "Información almacenada: "+ estudiante+" "+edad);
    }
    
}
