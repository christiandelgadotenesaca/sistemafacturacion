/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;
import Datos.Cls_Conexion;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 *
 * @author USUARIO
 */
public class Cls_Cliente {
    private  String CLI_ID;
    private  String CLI_NOMBRE;
    private  String CLI_APELLIDO;
    private  String CLI_DIRECCION;
    private  String CLI_TELEFONO;
    private  String CLI_MAIL;

    public Cls_Cliente(String CLI_ID, String CLI_NOMBRE, String CLI_APELLIDO, String CLI_DIRECCION, String CLI_TELEFONO, String CLI_MAIL) {
        this.CLI_ID = CLI_ID;
        this.CLI_NOMBRE = CLI_NOMBRE;
        this.CLI_APELLIDO = CLI_APELLIDO;
        this.CLI_DIRECCION = CLI_DIRECCION;
        this.CLI_TELEFONO = CLI_TELEFONO;
        this.CLI_MAIL = CLI_MAIL;
    }
    
    public Cls_Cliente(){}
    /**
     * @return the CLI_ID
     */
    public String getCLI_ID() {
        return CLI_ID;
    }

    /**
     * @return the CLI_NOMBRE
     */
    public String getCLI_NOMBRE() {
        return CLI_NOMBRE;
    }

    /**
     * @return the CLI_APELLIDO
     */
    public String getCLI_APELLIDO() {
        return CLI_APELLIDO;
    }

    /**
     * @return the CLI_DIRECCION
     */
    public String getCLI_DIRECCION() {
        return CLI_DIRECCION;
    }

    /**
     * @return the CLI_TELEFONO
     */
    public String getCLI_TELEFONO() {
        return CLI_TELEFONO;
    }

    /**
     * @return the CLI_MAIL
     */
    public String getCLI_MAIL() {
        return CLI_MAIL;
    }

    Cls_Conexion cnx=new Cls_Conexion();
  public void Guardar()
    {
        cnx.ejecutar("Insert into cliente_tb (CLI_ID,CLI_NOMBRE,CLI_APELLIDO,CLI_DIRECCION,CLI_TELEFONO,CLI_MAIL) values ('"+CLI_ID+"','"+CLI_NOMBRE+"','"+CLI_APELLIDO+"','"+CLI_DIRECCION+"','"+CLI_TELEFONO+"','"+CLI_MAIL+"')");
    }  
   public void GuardarActualizar()
    {
        cnx.ejecutar("Call SPGuardarActualizarClientes ('"+CLI_ID+"','"+CLI_NOMBRE+"','"+CLI_APELLIDO+"','"+CLI_DIRECCION+"','"+CLI_TELEFONO+"','"+CLI_MAIL+"')");
    }  
  public void Eliminar(String valor)
    {
        cnx.ejecutar("DELETE FROM cliente_tb WHERE CLI_ID='"+valor+"'");
    } 
  
   public void CargarDatos(JTable tblClientes)
    {
    //select* sirve para selecionar todos los datos que existen en la tabla
     cnx.CargarTabla("SELECT CLI_ID AS ID, CLI_NOMBRE AS NOMBRE, CLI_APELLIDO AS APELLIDO, CLI_DIRECCION AS DIRECCION, CLI_TELEFONO AS TELEFONO, CLI_MAIL AS MAIL FROM CLIENTE_TB", tblClientes);
     
    }
   public void CargarDatosBuscados(JTable tblClientes, String valor)
    {
    //select* sirve para selecionar todos los datos que existen en la tabla
     cnx.CargarTabla("Select CLI_ID AS ID, CLI_NOMBRE AS NOMBRE, CLI_APELLIDO AS APELLIDO, CLI_DIRECCION AS DIRECCION, CLI_TELEFONO AS TELEFONO, CLI_MAIL AS MAIL from cliente_tb where CONCAT (CLI_ID,' ',CLI_NOMBRE,' ',CLI_APELLIDO)  LIKE '%"+valor+"%'", tblClientes);
     
    }
    
   
}
