
package app;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class inicio extends JFrame implements ActionListener{    
    private JLabel labelTitulo;
    private JLabel labelCarita;
    private JButton botonEncontre, botonBuscar;  
    
    public inicio(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Inicio");
        getContentPane().setBackground(new Color(51,102,230));
        
        ImageIcon imagen = new ImageIcon ("src/recursos/Carita_1.png");
        labelCarita = new JLabel(imagen);
        labelCarita.setBounds(140,65,120,120);
        add(labelCarita);       
        
        labelTitulo = new JLabel("PERDIDOCS");
        labelTitulo.setBounds(50, 5, 180, 50);
        labelTitulo.setFont(new Font("Arial Rounded MT Bold", 1, 26));
        labelTitulo.setForeground(new Color(255,255,255));
        add(labelTitulo);
        
        botonEncontre = new JButton("Encontre Documentos");
        botonEncontre.setBounds(10, 235, 238, 40);
        botonEncontre.setBackground(Color.WHITE);
        botonEncontre.setFont(new Font("Arial Rounded MT Bold", 1, 16));
        botonEncontre.setForeground(Color.BLACK);
        add(botonEncontre);
        botonEncontre.addActionListener(this);        
        
        botonBuscar = new JButton("Buscar Documentos");
        botonBuscar.setBounds(10, 300, 238, 40);
        botonBuscar.setBackground(Color.WHITE);
        botonBuscar.setFont(new Font("Arial Rounded MT Bold", 1, 16));
        botonBuscar.setForeground(Color.BLACK);
        add(botonBuscar);
        botonBuscar.addActionListener(this);
                
    }  
    
    public void actionPerformed(ActionEvent EventoClic){
        if(EventoClic.getSource() == botonEncontre){
            encontreDoc ventanaEncontreDocs = new encontreDoc();
            ventanaEncontreDocs.setBounds(0, 0, 262, 415);
            ventanaEncontreDocs.setVisible(true);
            ventanaEncontreDocs.setResizable(false);
            ventanaEncontreDocs.setLocationRelativeTo(null);
            this.setVisible(false);
        } else if (EventoClic.getSource() ==  botonBuscar){
            buscarDocumentos ventanaBusDoc = new buscarDocumentos();
            ventanaBusDoc.setBounds(0,0,262,415);
            ventanaBusDoc.setVisible(true);
            ventanaBusDoc.setResizable(false);
            ventanaBusDoc.setLocationRelativeTo(null);
            this.setVisible(false);            
        }
    }  
    
    public static void main (String args[]){
        inicio ventanainicio = new inicio();
        ventanainicio.setBounds(0, 0, 262, 415);
        ventanainicio.setVisible(true);
        ventanainicio.setResizable(false);
        ventanainicio.setLocationRelativeTo(null);
        pantallaRegistros panReg = new pantallaRegistros();
        panReg.setBounds(0,0,262,415);
        panReg.setVisible(true);
        panReg.setResizable(true);
        panReg.setLocation(10,10);
    }    
    
}
