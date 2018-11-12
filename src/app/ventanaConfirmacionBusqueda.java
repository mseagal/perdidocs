
package app;
import app.buscarDocumentos;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;



/**
 *
 * @author Good
 */
public class ventanaConfirmacionBusqueda extends JFrame implements ActionListener {
    buscarDocumentos bd = new buscarDocumentos();
    private JLabel carita;
    private JTextArea textoConfirmacion;
    private JButton botonCerrar;
    public String Numero ="";
    private String Telefono="";
    public String tipoSeleccion = "";
    
    
    
    
    public ventanaConfirmacionBusqueda(){  
        
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Confirmacion de busqueda");
        getContentPane().setBackground(new Color(51,102,230));
        
        buscarDocumentos tel = new buscarDocumentos();
        Telefono=tel.NumTelefono;
        
        ImageIcon ImagenCara = new ImageIcon("src/recursos/Carita_1.png");
        carita = new JLabel(ImagenCara);
        carita.setBounds(142, 2, 120, 120);
        add(carita);
        buscarDocumentos bd = new buscarDocumentos();
        
        textoConfirmacion = new JTextArea("  La persona con numero de\n"
                + " telefono "+Telefono+""
                + " encontro tu\n documento "+ tipoSeleccion +" "+ Numero +""
                + "\n ponte en contacto para\n acordar la entrega");             
               
        textoConfirmacion.setBounds(5, 130, 245, 130);
        textoConfirmacion.setFont(new Font("Arial",3,12));
        textoConfirmacion.setBackground(Color.WHITE);
        textoConfirmacion.setForeground(Color.BLACK);
        textoConfirmacion.setEditable(false);
        add(textoConfirmacion);
        
        botonCerrar = new JButton("CERRAR");
        botonCerrar.setBounds(90, 300, 160, 40);
        botonCerrar.setBackground(new Color(255,255,255));
        botonCerrar.setFont(new Font("Arial",1,14));
        botonCerrar.setForeground(new Color(0,0,0));
        botonCerrar.addActionListener(this);
        add(botonCerrar);
        
        
    }
    public void actionPerformed(ActionEvent eventoClicCerrar){
        if (eventoClicCerrar.getSource()== botonCerrar){
            inicio ventanainicio = new inicio();
            ventanainicio.setBounds(0, 0, 262, 415);
            ventanainicio.setVisible(true);
            ventanainicio.setResizable(false);
            ventanainicio.setLocationRelativeTo(null);
            this.setVisible(false);
            
        }
    }

    
    public static void main (String args[]){
        
        
        ventanaConfirmacionBusqueda venConbus = new ventanaConfirmacionBusqueda();
        venConbus.setBounds(0, 0, 262, 415);
        venConbus.setVisible(true);
        venConbus.setResizable(false);
        venConbus.setLocationRelativeTo(null);
        
        
        
    }
        
    
    
}
