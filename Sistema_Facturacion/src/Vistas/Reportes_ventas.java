/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vistas;

import java.sql.Connection;
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

/**
 *
 * @author USUARIO
 */
public class Reportes_ventas {
    public int reporteVentas (String fecha_inicio,String fecha_fin, String estado, String TOTAL) throws JRException, SQLException{
        Connection conect; 
        Map parametros = new HashMap();
        parametros.put("fecha_inicio", fecha_inicio);
        parametros.put("fecha_fin", fecha_fin);
        parametros.put("estado", estado);
        parametros.put("TOTAL", TOTAL);
        conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/facturacion_db","root","user");
        JasperReport report = null;
        report = (JasperReport) JRLoader.loadObjectFromFile("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\Sistema_Facturacion\\src\\Vistas\\Ventas.jasper");
        JasperPrint im = JasperFillManager.fillReport(report,parametros,conect);
        JasperViewer ver = new JasperViewer(im,false);
        ver.setTitle("Reporte de Ventas");
        ver.setVisible(true);
        return 0;
    
    }
    
}
