/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

/**
 *
 * @author usuario
 */
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Reportes_productos {
     public void reporteProductos () throws JRException, SQLException{
        Connection conect; 
        conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/facturacion_db","root","user");
        JasperReport report = null;
        report = (JasperReport) JRLoader.loadObjectFromFile("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\Sistema_Facturacion\\src\\Vistas\\Productos.jasper");
        JasperPrint im = JasperFillManager.fillReport(report,null,conect);
        JasperViewer ver = new JasperViewer(im,false);
        ver.setTitle("Reporte de Productos");
        ver.setVisible(true);
        
    
    }
    
    
}
