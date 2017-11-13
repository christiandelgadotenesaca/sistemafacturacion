/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema_facturacion;

import Formularios.Frm_Menu;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author USUARIO
 */
public class Sistema_Facturacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Diseño
        Frm_Menu.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");
        Frm_Menu vista = new Frm_Menu();
         vista.setVisible(true);
         vista.setLocationRelativeTo(null);
    }
    
}
