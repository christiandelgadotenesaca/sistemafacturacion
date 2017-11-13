/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

import Formularios.Frm_Factura;
import Formularios.Frm_Reporte_Ventas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author USUARIO
 */
public class Cls_Conexion {
   
   Connection Conect;
   Statement st;
   
   static String user="root";
   static String pass="user";
   static String url="jdbc:mysql://localhost:3306/facturacion_db";
public Cls_Conexion(){
   try
   {

   Class.forName("com.mysql.jdbc.Driver");
   Conect=DriverManager.getConnection(url,user,pass);
   if(Conect!=null)
   {
   System.out.println();
   System.out.println("succesafully conected");
   System.out.println();
   System.out.println("\nDriver infromation");
  
   }   
   }
   catch(SQLException excepcionSql)
    {
        JOptionPane.showMessageDialog(null, excepcionSql.getMessage(),"error en base de datos",JOptionPane.ERROR_MESSAGE);
     }
   catch(ClassNotFoundException claseNoEncontrada)
     {
        JOptionPane.showMessageDialog(null, claseNoEncontrada.getMessage(),"no se encontro el controlador",JOptionPane.ERROR_MESSAGE);
           
      }
   }

    //ejecutar las instrucciones sql
 public String ejecutar(String sql)
        {
        String error="";
        try
        {
        st=Conect.createStatement();
        st.executeUpdate(sql);
        }
        catch(SQLException es)
        {
        error= es.getMessage();

        }
        return(error);
        }
    
 
 //consulta
 public ResultSet Consulta(String sql)
    {
       
    ResultSet res=null;
    try
        {
        Statement s=Conect.createStatement();
        res=s.executeQuery(sql);
             
        }catch(Exception e)
        {
        JOptionPane.showMessageDialog(null,e.getMessage(),"No se encontro los datos",JOptionPane.ERROR_MESSAGE);

        }
        return res;

        }
        //consulta el numero maxor
 public ResultSet ConsultaNumero(String sql)
    {
       
    ResultSet res=null;
    try
        {
        Statement s=Conect.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
        res=s.executeQuery(sql);
        while (res.next()){
//            String max = res.getString("MAXIMO");
            System.out.println(res.getString("MAXIMO"));
            Frm_Factura.txt_codigo_factura.setText(res.getString("MAXIMO"));
        }
        
        }catch(Exception e)
        {
        JOptionPane.showMessageDialog(null,e.getMessage(),"No se encontro los datos",JOptionPane.ERROR_MESSAGE);

        }
        return res;

        }
    public ResultSet ConsultarTotalFecha(String sql)
    {
       
    ResultSet res=null;
    try
        {
        Statement s=Conect.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
        res=s.executeQuery(sql);
        while (res.next()){
            String max = res.getString("TOTAL");
//            System.out.println(res.getString("TOTAL"));
            Frm_Reporte_Ventas.txt_total.setText(res.getString("TOTAL"));
        }
        
        }catch(Exception e)
        {
        JOptionPane.showMessageDialog(null,e.getMessage(),"No se encontro los datos",JOptionPane.ERROR_MESSAGE);

        }
        return res;

        }
 
 
 
 
 
 
 
        
  public void CargarTabla(String instruccionsql,JTable NombreTabla)
    {
    try
    {
    //para establecer el modelo al JTable
        DefaultTableModel modelo = new DefaultTableModel();
        NombreTabla.setModel(modelo);
        ResultSet rs=Consulta(instruccionsql);
        //Obteniendo la informacion de las columnas que estan siendo consultadas
        ResultSetMetaData rsMd=rs.getMetaData();
        //Establecer como cabezeras el nombre de las columnas
        for(int i=1;i<=rsMd.getColumnCount();i++)
        {modelo.addColumn(rsMd.getColumnLabel(i));}
        //creando las filas para el JTable
        while(rs.next()){
        Object[]fila=new Object[rsMd.getColumnCount()];
        for(int i=0; i<rsMd.getColumnCount();i++)
        {
        fila[i]=rs.getObject(i+1);
        }
        modelo.addRow(fila);
        }
        rs.close();
    }catch(Exception ex){}
  }
}
