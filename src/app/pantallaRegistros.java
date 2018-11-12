
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Good
 */
public class pantallaRegistros extends JFrame  {
    private JTextArea areaTexto;
    public static ResultSet res;
    
    
    
    public pantallaRegistros() throws SQLException{
        
        
        
        
        
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Inicio");
        getContentPane().setBackground(new Color(51,102,230));
        
        //JTextArea areaTexto = new JTextArea();
        //areaTexto.setBounds(10, 10, 230, 350);
        //add(areaTexto);
        
    }
    
    public static void conexion_registros() throws SQLException{
        String driver="org.git.mm.mysql.Driver";
        String url="jdbc:mysql://localhost/perdidocs";
        
        try{
            Connection con=DriverManager.getConnection(url,"root","");
            Statement sta=con.createStatement();
            String sql="SELECT tipo_doc.nombre as tipo,documento.numero,documento.contacto,documento.fecha from documento\n" +
            "inner join tipo_doc\n" +
            "on documento.tipo_tipo_doc=tipo_doc.codigo";
            res=sta.executeQuery(sql);
            
            
            
            
        
        
        }catch(SQLException ex){
        
            System.out.println("error de conexion");
        }
        
        
        
    }
    
    public static void main (String args[]) throws SQLException{
        pantallaRegistros panReg = new pantallaRegistros();
        panReg.setBounds(0,0,262,415);
        panReg.setVisible(true);
        panReg.setResizable(false);
        panReg.setLocation(10,10);     
        conexion_registros();
        DefaultTableModel modelo=new DefaultTableModel();
            JTable tab_reg=new JTable(modelo);
            try{modelo.addColumn("tipo");
            modelo.addColumn("documento");
            modelo.addColumn("contacto");
            modelo.addColumn("fecha");
        
        while(res.next()){
                
                Object [] ob=new Object[4];
                ob[0]=(res.getString(1));
                ob[1]=(res.getString(2));
                ob[2]=(res.getString(3));
                modelo.addRow(ob);
                
                ob=null;
                
            }
             res.close();
                
            }catch(SQLException ex){
                System.out.println(ex);
            }
        
        
    }
    
}
