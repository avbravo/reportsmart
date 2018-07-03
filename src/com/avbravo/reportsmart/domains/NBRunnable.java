/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.reportsmart.domains;

/**
 *
 * @author avbravo
 */
import java.sql.Connection;
import javax.swing.JOptionPane;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.StatusDisplayer;

/**
 *
 * @author avbravo
 */
public class NBRunnable implements Runnable {

 
    int msgTypeError = NotifyDescriptor.ERROR_MESSAGE;
    int msgType = NotifyDescriptor.INFORMATION_MESSAGE;

    @Override
    public void run() {

        try {

           
                ProgressHandle p = ProgressHandleFactory.createHandle(
                        "Procesando tabla: " + "     espere....");
                p.start();
//                          DataBasesProcess dataBasesProcess = new DataBasesProcess(Conexion.getConn());
                // break;
                p.finish();
          
            StatusDisplayer.getDefault().setStatusText("");
//            NotifyDescriptor d = new NotifyDescriptor.Message("Proceso de migración terminada...", msgType);
//            DialogDisplayer.getDefault().notify(d);
            // p.finish();
        } catch (Exception ex) {
            StatusDisplayer.getDefault().setStatusText("Error " + ex.getMessage().toString());
        }

    }
}
