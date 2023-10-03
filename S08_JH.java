/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package S08_00JosemariaHuaman;

/**
 *
 * @author josem
 */
public class S08_JH{
    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) {
        int nArgs = args.length;
        System.out.println( "Args introducidos: " + nArgs );
        
        if ( nArgs > 0 ) {
            for ( int i = 0; i < nArgs; i ++ ) {
                System.out.println( i + 1 + ". " + args[i] );
            }
        }
    }
    
}
