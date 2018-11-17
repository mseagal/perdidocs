
package app;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class encontreDoc extends JFrame implements ActionListener, ItemListener {

    private static void JOptionPane(String los_datos_se_insertaron_correctamente_en_) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private JLabel labelCarita, labelTipo, labelNumCC, labelNumTel;
    private JComboBox boxTipo;
    private JButton botonRegistrar, botonAtras;
    private JTextField boxDocumento, boxTelefono;
    private JTextArea cuadroTexto;
    public static String NumDoc = "";
    public static String NumTel = "";
    public static String Seleccion = "";
    public static int TipoDoc;
    public static String fecha="";
    
    
    
    
    
 
    
    
            
    public encontreDoc(){
        setLayout (null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(51,102,230));
        ImageIcon imagenCarita = new ImageIcon ("src/recursos/Carita_1.png");
        labelCarita = new JLabel(imagenCarita);
        labelCarita.setBounds(0, 0, 120, 110);
        add(labelCarita);
        
        cuadroTexto = new JTextArea("     Hey, has encontrado el documento\n"
                + "     de otra persona, ayúdalo \n"
                + "     registrándolo en mi base de datos, \n"
                + "     asi esa persona podrá ponerse\n"
                + "     en contaco para recuperarlo.");
        
        cuadroTexto.setBounds(10, 117, 225, 85);
        cuadroTexto.setFont(new Font("Arial",3,12));
        cuadroTexto.setForeground(new Color(0,0,0));
        add(cuadroTexto);        
        
        ImageIcon imagenVolver = new ImageIcon ("src/recursos/Volver.png");
        botonAtras = new JButton (imagenVolver);
        botonAtras.setBackground(new Color(51,51,51));
        botonAtras.setBorder(null);
        botonAtras.setBorderPainted(false);
        botonAtras.setContentAreaFilled(false);
        botonAtras.setBounds(192, 10, 60, 60);
        botonAtras.addActionListener(this);
        add(botonAtras);
        
        boxTipo = new JComboBox();
        boxTipo.setBounds(45,210,60,20);
        add(boxTipo);
        boxTipo.addItem("");
        boxTipo.addItem("RC");
        boxTipo.addItem("TI");
        boxTipo.addItem("CC");
        boxTipo.addItem("CE");
        boxTipo.addItemListener(this);
        boxTipo.setFont(new Font("Arial",1,14));
        boxTipo.setForeground(new Color(0,0,0));        
        
        labelTipo = new JLabel("Tipo");
        labelTipo.setBounds(10,210,80,20);
        labelTipo.setFont(new Font("Arial",1,12));
        labelTipo.setForeground(new Color (0,0,0));
        add (labelTipo);
        
        labelNumCC = new JLabel ("Numero documento encontrado");
        labelNumCC.setBounds(10,225,200,30);
        labelNumCC.setFont(new Font("Arial",1,12));
        labelNumCC.setForeground(new Color(0,0,0));
        add (labelNumCC);
        
        boxDocumento = new JTextField ();
        boxDocumento.setBounds(10, 250, 240, 30);
        boxDocumento.setBackground(new Color(255,255,255));
        boxDocumento.setFont(new Font("Arial",1,14));
        boxDocumento.setForeground(new Color(0,0,0));
        add (boxDocumento);
        
        labelNumTel = new JLabel ("Tu numero de celular");
        labelNumTel.setBounds(10, 280, 200, 30);
        labelNumTel.setFont(new Font("Arial",1,12));
        labelNumTel.setForeground(new Color(0,0,0));
        add (labelNumTel);
        
        boxTelefono = new JTextField ();
        boxTelefono.setBounds(10,305,240,30);
        boxTelefono.setBackground(new Color(255,255,255));
        boxTelefono.setFont(new Font("Arial",1,14));
        boxTelefono.setForeground(new Color(0,0,0));
        add (boxTelefono);  
        
        botonRegistrar = new JButton("REGISTRAR");
        botonRegistrar.setBounds(90,345,160,40);
        botonRegistrar.setBackground(new Color(255,255,255));
        botonRegistrar.setFont(new Font("Arial",1,20));
        botonRegistrar.setForeground(new Color(0,0,0));
        botonRegistrar.addActionListener(this);
        add(botonRegistrar);        
        
        
    }
    
    public void itemStateChanged(ItemEvent selecTipo){
        if(selecTipo.getSource()== boxTipo){
            Seleccion = boxTipo.getSelectedItem().toString();            
        }
        if(Seleccion.equals("RC")){    
            
            TipoDoc=1;
        }
        if(Seleccion.equals("TI")){    
            
            TipoDoc=2;
        }
        if(Seleccion.equals("CC")){    
            
            TipoDoc=3;
        }
        if(Seleccion.equals("CE")){    
            
            TipoDoc=4;
        }
        if(Seleccion.equals("")){    
            
            TipoDoc=0;
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent EventoClic1) {
        if (EventoClic1.getSource()== botonRegistrar){
            NumDoc = boxDocumento.getText().trim();
            NumTel = boxTelefono.getText().trim();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date=new Date();
            String fc=dateFormat.format(date);
            fecha=fc;
            try {
                conexionBD();
            } catch (SQLException ex) {
                Logger.getLogger(encontreDoc.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(EventoClic1.getSource()== botonAtras){
            inicio ventanainicio = new inicio();
            ventanainicio.setBounds(0, 0, 262, 415);
            ventanainicio.setVisible(true);
            ventanainicio.setResizable(false);
            ventanainicio.setLocationRelativeTo(null);
            this.setVisible(false);
        }
    }
     public static void conexionBD() throws SQLException{
    String driver="org.git.mm.mysql.Driver";
    String url="jdbc:mysql://localhost/perdidocs";
    
    
    try{
    Connection con=DriverManager.getConnection(url,"root","");
    Statement sta=con.createStatement();
    String sql1="insert into documento(tipo_tipo_doc,numero,contacto,fecha) values("+TipoDoc+",'"+NumDoc+"','"+NumTel+"','"+fecha+"')";
    
    boolean res=sta.execute(sql1);
    if (res==false){
        
        ventanaConfirmacionEncontre venConEn = new ventanaConfirmacionEncontre();
            venConEn.setBounds(0, 0, 262, 415);
            venConEn.setVisible(true);
            venConEn.setResizable(false);
            venConEn.setLocationRelativeTo(null);
    }else{
        JOptionPane.showMessageDialog(null,"Los datos no se insertaron correctamente en la BD");
    }
        
    
    } 
    catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Revise los datos ingresados");
        System.out.println(ex);
        
    }
    
    } 
    public static void main (String args[]){
        encontreDoc ventanaEncontreDocs = new encontreDoc();                     
        ventanaEncontreDocs.setBounds(0, 0, 262, 415);
        ventanaEncontreDocs.setVisible(true);
        ventanaEncontreDocs.setResizable(false);
        ventanaEncontreDocs.setLocationRelativeTo(null); 
        /*DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date=new Date();
        String fc=dateFormat.format(date);
        fecha=fc;*/
        
        
        
        
        
    }   

    
}

