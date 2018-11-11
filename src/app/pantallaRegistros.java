
package app;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Good
 */
public class pantallaRegistros extends JFrame  {
    
    public pantallaRegistros(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Inicio");
        getContentPane().setBackground(new Color(51,102,230));
    }
    
    public static void main (String args[]){
        pantallaRegistros panReg = new pantallaRegistros();
        panReg.setBounds(0,0,262,415);
        panReg.setVisible(true);
        panReg.setResizable(false);
        panReg.setLocation(10,10);        
        
    }
    
}
