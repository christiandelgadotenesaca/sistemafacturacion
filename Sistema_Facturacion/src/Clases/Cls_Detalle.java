/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import Datos.Cls_Conexion;

/**
 *
 * @author USUARIO
 */
public class Cls_Detalle {
    private int FAC_CODIGO;
    private int PROD_CODIGO;
    private int FAC_CANTIDAD;
    private String FAC_DETALLE;
    private double FAC_V_UNITARIO;
    private double FAC_TOTAL_ITEM;

    public Cls_Detalle(int FAC_CODIGO, int PROD_CODIGO, int FAC_CANTIDAD, String FAC_DETALLE, double FAC_V_UNITARIO, double FAC_TOTAL_ITEM) {
        this.FAC_CODIGO = FAC_CODIGO;
        this.PROD_CODIGO = PROD_CODIGO;
        this.FAC_CANTIDAD = FAC_CANTIDAD;
        this.FAC_DETALLE = FAC_DETALLE;
        this.FAC_V_UNITARIO = FAC_V_UNITARIO;
        this.FAC_TOTAL_ITEM = FAC_TOTAL_ITEM;
    }
    
    
    
    /**
     * @return the FAC_CODIGO
     */
    public int getFAC_CODIGO() {
        return FAC_CODIGO;
    }

    /**
     * @return the PROD_CODIGO
     */
    public int getPROD_CODIGO() {
        return PROD_CODIGO;
    }

    /**
     * @return the FAC_CANTIDAD
     */
    public int getFAC_CANTIDAD() {
        return FAC_CANTIDAD;
    }

    /**
     * @return the FAC_DETALLE
     */
    public String getFAC_DETALLE() {
        return FAC_DETALLE;
    }

    /**
     * @return the FAC_V_UNITARIO
     */
    public double getFAC_V_UNITARIO() {
        return FAC_V_UNITARIO;
    }

    /**
     * @return the FAC_TOTAL_ITEM
     */
    public double getFAC_TOTAL_ITEM() {
        return FAC_TOTAL_ITEM;
    }

    Cls_Conexion cnx= new Cls_Conexion();
    public void Guardar()
    {
     cnx.ejecutar("Insert Into factura_detalle_tb (FAC_CODIGO,PROD_CODIGO,FAC_CANTIDAD,FAC_DETALLE,FAC_V_UNITARIO,FAC_TOTAL_ITEM)values("+FAC_CODIGO+","+PROD_CODIGO+","+FAC_CANTIDAD+",'"+FAC_DETALLE+"',"+FAC_V_UNITARIO+","+FAC_TOTAL_ITEM+")");
    } 
    
    
}
