/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.reportsmart.projects;

import com.avbravo.reportsmart.domains.MySession;
import java.io.File;

import org.netbeans.api.project.Project;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;
import org.openide.util.actions.CookieAction;

/**
 *
 * @author avbravo
 */
public class Proyecto extends CookieAction {

    NotifyDescriptor nd;
    String web = "";
    String src = "";

    @Override
    public boolean isEnabled() {
        try {
            web = "";
            src = "";
            MySession.setEsProyectoWeb(false);
            MySession.setDirectorioWebInf("");
            if (this.getActivatedNodes() == null || this.getActivatedNodes().length != 1) {
                return false;
            }
            Lookup lookup = this.getActivatedNodes()[0].getLookup();
            // gets the selected project
            Project currentProject = lookup.lookup(Project.class);
            if (currentProject != null) {

                MySession.setNombreProyecto(currentProject.getProjectDirectory().getName());
                String tipoProyecto = currentProject.getClass().getSimpleName();

                MySession.setTipoProyecto(tipoProyecto);
                src = currentProject.getProjectDirectory().getFileObject("src").toString();
                src = src.substring(src.indexOf("[") + 1, src.indexOf("@"));

                MySession.setSrc(src);
                if (tipoProyecto.equals("NbMavenProjectImpl")) {
                    /*
                     * maven
                     */
                    MySession.setSrcJava(src + MySession.getFileSeparator() + "main" + MySession.getFileSeparator() + "java");
                    String lweb = src + MySession.getFileSeparator() + "main" + MySession.getFileSeparator() + "webapp";

                    File file = new File(lweb);
                    if (file.exists()) {
                        //indica que es web
                        web = lweb;
                        MySession.setWeb(web);
                        MySession.setDirectorioWebInf(web + MySession.getFileSeparator() + "WEB-INF");
                        MySession.setEsProyectoWeb(true);
                    }
                } else {

                    if (tipoProyecto.equals("NbModuleProject")) {
                        /*
                         * modulo netbeans
                         */
                        MySession.setSrcJava(src);

                    } else {
                        if (tipoProyecto.equals("J2SEProject")) {
                            /*
                             * desktop
                             */
                            MySession.setSrcJava(src);
                        } else {
                            if (tipoProyecto.equals("WebProject")) {
                                /*
                                 * web
                                 */
                                web = currentProject.getProjectDirectory().getFileObject("web").toString();
                                web = web.substring(web.indexOf("[") + 1, web.indexOf("@"));
                                MySession.setSrcJava(src + MySession.getFileSeparator() + "java");
                                MySession.setDirectorioWebInf(web + MySession.getFileSeparator() + "WEB-INF");
                                MySession.setEsProyectoWeb(true);
                            }
                        }
                    }

                    MySession.setWeb(web);
                }
//                if (!MySession.isEsProyectoWeb()) {
//                    nd = new NotifyDescriptor.Message(NbBundle.getMessage(JSFClassGTopComponent.class, "Mensaje_ProyectoNoSeleccionado"), NotifyDescriptor.Message.INFORMATION_MESSAGE);
//                    DialogDisplayer.getDefault().notify(nd);
//                    return false;
//                }
//                TopComponent tc = WindowManager.getDefault().findTopComponent("JSFClassGTopComponent");
//                tc.open();
//                tc.requestActive();
                return true;

            }

        } catch (Exception ex) {
            nd = new NotifyDescriptor.Message(ex.getLocalizedMessage(), NotifyDescriptor.Message.INFORMATION_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);

        }
        return false;
    }

    @Override
    protected int mode() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected Class<?>[] cookieClasses() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void performAction(Node[] nodes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public HelpCtx getHelpCtx() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
