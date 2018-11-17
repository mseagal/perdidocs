
package app;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class buscarDocumentos extends JFrame implements ActionListener, ItemListener {
    private JLabel labelCarita, labelTipo, labelDocumento;
    private JButton botonBuscar, botonVolver;
    private JComboBox boxTipo;
    private JTextArea cuadroTexto;
    private JTextField boxBuscarDoc;
    public static String SeleccionTipo = "";
    public static String NumDocumento = "";
    public static String NumTelefono = "";
    public static String TipoDocBD;
    public static int TipoDoc;
    public static boolean estado=false;
    
    public String gettel(){
        
        return NumTelefono;
    }
    
    
    
    public buscarDocumentos (){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Buscar Documentos");
        getContentPane().setBackground(new Color(51,102,230));
        
        ImageIcon imagenCarita = new ImageIcon ("src/recursos/carita_1.png");
        labelCarita = new JLabel(imagenCarita);
        labelCarita.setBounds(142,0,120,120);
        add(labelCarita);
        
        ImageIcon imagenVolver = new ImageIcon("src/recursos/Volver.png");
        botonVolver = new JButton(imagenVolver);
        botonVolver.setBounds(0, 0, 60, 60);
        botonVolver.setBorder(null);
        botonVolver.setBorderPainted(false);
        botonVolver.setContentAreaFilled(false);
        botonVolver.addActionListener(this);
        add(botonVolver);
        
        cuadroTexto = new JTextArea("       !hola¡\n"
                + "       Puedo ayudarte a buscar\n"
                + "       tu documento. Selecciona\n"
                + "       el tipo de documento e ingresa\n"
                + "       el numero");
        
        cuadroTexto.setBounds(10,125,220,85);
        cuadroTexto.setBackground(new Color(255,255,255));
        cuadroTexto.setFont(new Font("Arial",3,12));
        cuadroTexto.setForeground(new Color(0,0,0));        
        add(cuadroTexto);
        
        labelTipo = new JLabel("Tipo");
        labelTipo.setBounds(10, 230, 30, 20);
        labelTipo.setFont(new Font("Arial",1,14));
        labelTipo.setForeground(new Color(0,0,0));
        add(labelTipo);
        
        boxTipo = new JComboBox();
        boxTipo.setBounds(50,230,60,25);
        add(boxTipo);
        boxTipo.addItem("RC");
        boxTipo.addItem("TI");
        boxTipo.addItem("CC");
        boxTipo.addItem("CE");
        boxTipo.setForeground(new Color(0,0,0));
        boxTipo.addItemListener(this);
        
        labelDocumento = new JLabel("Numero de documento");
        labelDocumento.setBounds(10,265,200, 20);
        labelDocumento.setFont(new Font("Arial",1,14));
        labelDocumento.setForeground(new Color(0,0,0));
        add (labelDocumento);
        
        boxBuscarDoc = new JTextField();
        boxBuscarDoc.setBounds(10,290,240,30);
        add(boxBuscarDoc);
        
        botonBuscar = new JButton("BUSCAR");
        botonBuscar.setBounds(90,345,160,40);
        botonBuscar.setBackground(new Color(255,255,255));
        botonBuscar.setFont(new Font("Arial",1,14));
        botonBuscar.setForeground(new Color(0,0,0));
        botonBuscar.addActionListener(this);
        add(botonBuscar);       
                
        
    }
    
    public void itemStateChanged (ItemEvent selecBox){
        if (selecBox.getSource()== boxTipo){
            SeleccionTipo = boxTipo.getSelectedItem().toString();            
        }        
        
        
        if(SeleccionTipo.equals("RC")){    
            
            TipoDoc=1;
        }
        if(SeleccionTipo.equals("TI")){    
            
            TipoDoc=2;
        }
        if(SeleccionTipo.equals("CC")){    
            
            TipoDoc=3;
        }
        if(SeleccionTipo.equals("CE")){    
            
            TipoDoc=4;
        }
        
        
    }    
    
    public void actionPerformed(ActionEvent eventoClic) {
        if (eventoClic.getSource() == botonVolver){
            inicio ventanainicio = new inicio();
            ventanainicio.setBounds(0, 0, 262, 415);
            ventanainicio.setVisible(true);
            ventanainicio.setResizable(false);
            ventanainicio.setLocationRelativeTo(null);
            this.setVisible(false);
        }else if (eventoClic.getSource()== botonBuscar){
            NumDocumento=boxBuscarDoc.getText().trim();
            
            try {
                conexionBD_buscar();
            } catch (SQLException ex) {
                
            }
            
            if(estado==true){
            ventanaConfirmacionBusqueda venConbus = new ventanaConfirmacionBusqueda();
            venConbus.setBounds(0, 0, 262, 415);
            venConbus.setVisible(true);
            venConbus.setResizable(false);
            venConbus.setLocationRelativeTo(null);
            }
            else{
            JOptionPane.showMessageDialog(null,"El Documento no existe en la base de datos");
            }
           
            
            
        }
    }
            public static void conexionBD_buscar() throws SQLException{
        
        String driver="org.git.mm.mysql.Driver";
        String url="jdbc:mysql://localhost/perdidocs";
        try{
            
        Connection con=DriverManager.getConnection(url,"root","");
        Statement sta=con.createStatement();
        String sql="SELECT tipo_doc.nombre as tipo,documento.numero,documento.contacto, documento.fecha from documento "
                + "inner join tipo_doc "
                + "on documento.tipo_tipo_doc=tipo_doc.codigo "
                + "where numero='"+NumDocumento+"' and tipo_tipo_doc="+TipoDoc+"";
        
        ResultSet resultado=sta.executeQuery(sql);
        
            
        while(resultado.next()){
            
            NumTelefono=resultado.getString("contacto");
            TipoDocBD=resultado.getString("tipo");
            estado=true;
        }
        
        
        
        
        }catch(SQLException ex){
            System.out.println("Error de conexion");
        }  
    }
 

    public static void main (String args[]){
        buscarDocumentos ventanaBusDoc = new buscarDocumentos();
        ventanaBusDoc.setBounds(0,0,262,415);
        ventanaBusDoc.setVisible(true);
        ventanaBusDoc.setResizable(false);
        ventanaBusDoc.setLocationRelativeTo(null);
        
        
    }    

    
}
