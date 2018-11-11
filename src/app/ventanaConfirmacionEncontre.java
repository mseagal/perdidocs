
package app;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ventanaConfirmacionEncontre extends JFrame implements ActionListener {
    buscarDocumentos bd = new buscarDocumentos();
    
    private JLabel carita;
    private JTextArea textoConfirmacion;
    private JButton botonCerrar;
    
    
    
    String tipoSeleccion = "";
    
    
    public ventanaConfirmacionEncontre (){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Confirmacion Encontre Documentos");
        getContentPane().setBackground(new Color(51,102,230));
        String Telefono = bd.gettel();
        buscarDocumentos texTel = new buscarDocumentos();
        //Telefono = texTel.NumTelefono;
        System.out.println(Telefono);
        
        encontreDoc ed = new encontreDoc();
        String Numero=ed.NumDoc;
        
        ImageIcon ImagenCara = new ImageIcon("src/recursos/Carita_1.png");
        carita = new JLabel(ImagenCara);
        carita.setBounds(142, 2, 120, 120);
        add(carita);
        
        textoConfirmacion = new JTextArea(" El documento: "
                + ""+tipoSeleccion+" "
                + ""+Numero+"\n quedo registrado en"
                + " mi base de datos\n"
                + " por el numero de celular\n"
                + " "+Telefono+" la persona que lo extravio\n"
                + " se pondra en contacto para acordar\n la entrega.\n"
                + " Muchas gracias por ayudar");
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
        }
    }
    public static void main (String args[]){
        ventanaConfirmacionEncontre venConEn = new ventanaConfirmacionEncontre();
        venConEn.setBounds(0, 0, 262, 415);
        venConEn.setVisible(true);
        venConEn.setResizable(false);
        venConEn.setLocationRelativeTo(null);
        System.out.println("prueba");
    }
    
    
    
    
}
