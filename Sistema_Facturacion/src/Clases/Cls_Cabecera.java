/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import Datos.Cls_Conexion;
import java.sql.ResultSet;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class Cls_Cabecera {
     private int FAC_CODIGO;
     private String CLI_ID;
     private String FAC_FECHA;
     private String FAC_ESTADO;
     private int FAC_PORCENTAJE;
     private double FAC_TOTAL;
     private String CLI_DIRECCION;

    public Cls_Cabecera(int FAC_CODIGO, String CLI_ID, String FAC_FECHA, String FAC_ESTADO, int FAC_PORCENTAJE, double FAC_TOTAL,String CLI_DIRECCION) {
        this.FAC_CODIGO = FAC_CODIGO;
        this.CLI_ID = CLI_ID;
        this.FAC_FECHA = FAC_FECHA;
        this.FAC_ESTADO = FAC_ESTADO;
        this.FAC_PORCENTAJE = FAC_PORCENTAJE;
        this.FAC_TOTAL = FAC_TOTAL;
        this.CLI_DIRECCION=CLI_DIRECCION;
    }
    
    
    public Cls_Cabecera(){}
    /**
     * @return the FAC_CODIGO
     */
    public int getFAC_CODIGO() {
        return FAC_CODIGO;
    }

    /**
     * @return the CLI_ID
     */
    public String getCLI_ID() {
        return CLI_ID;
    }

    /**
     * @return the FAC_FECHA
     */
    public String getFAC_FECHA() {
        return FAC_FECHA;
    }

    /**
     * @return the FAC_ESTADO
     */
    public String getFAC_ESTADO() {
        return FAC_ESTADO;
    }

    /**
     * @return the FAC_PORCENTAJE
     */
    public int getFAC_PORCENTAJE() {
        return FAC_PORCENTAJE;
    }

    /**
     * @return the FAC_TOTAL
     */
    public double getFAC_TOTAL() {
        return FAC_TOTAL;
    }
    /**
     * @return the FAC_TOTAL
     */
    public String getCLI_DIRECCION() {
        return CLI_DIRECCION;
    }
    Cls_Conexion cnx= new Cls_Conexion();
    public void Guardar()
    {
     cnx.ejecutar("Insert Into factura_cabecera_tb (FAC_CODIGO,CLI_ID,FAC_FECHA,FAC_ESTADO,FAC_PORCENTAJE,FAC_TOTAL,CLI_DIRECCION)values("+FAC_CODIGO+",'"+CLI_ID+"','"+FAC_FECHA+"','"+FAC_ESTADO+"',"+FAC_PORCENTAJE+","+FAC_TOTAL+",'"+CLI_DIRECCION+"')");
    }
    public void CargarDatos(JTable tblFactura)
    {
    //select* sirve para selecionar todos los datos que existen en la tabla
     cnx.CargarTabla("SELECT FAC_CODIGO as N°FACTURA, CLI_ID AS CLIENTE, FAC_FECHA AS FECHA, FAC_ESTADO AS ESTADO,FAC_PORCENTAJE AS PORCENTAJE,FAC_TOTAL AS TOTAL FROM factura_cabecera_tb", tblFactura);
     
    }
    public void CargarDatosporfecha(JTable tblFactura,String fechainicio,String fechafin,String estado)
    {
    //select* sirve para selecionar todos los datos que existen en la tabla
     cnx.CargarTabla("SELECT FAC_CODIGO as CODIGO,CLI_ID AS CLIENTE,FAC_FECHA AS FECHA,FAC_ESTADO AS ESTADO,FAC_PORCENTAJE AS PORCENTAJE,FAC_TOTAL AS TOTAL FROM factura_cabecera_tb WHERE FAC_FECHA BETWEEN '"+fechainicio+"' AND '"+fechafin+"'" +"and FAC_ESTADO = '"+estado+"'" +"ORDER BY  FAC_FECHA", tblFactura);
     
    } 
    public void ActualizarEstado(int Codigo,String Estado)
    {
     cnx.ejecutar("update factura_cabecera_tb set FAC_ESTADO='"+Estado+"' where(FAC_CODIGO="+Codigo+")");
    }
   
    public void CargarDatosUnitarios(JTable tblFactura, String valor)
    {
    //select* sirve para selecionar todos los datos que existen en la tabla
     cnx.CargarTabla("Select FAC_CODIGO as CODIGO,CLI_ID AS CLIENTE,FAC_FECHA AS FECHA,FAC_ESTADO AS ESTADO,FAC_PORCENTAJE AS PORCENTAJE,FAC_TOTAL AS TOTAL from factura_cabecera_tb where (FAC_CODIGO) LIKE '%"+valor+"%'", tblFactura);
     
    }
    
    
}