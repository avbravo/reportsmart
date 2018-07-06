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
import org.openide.util.actions.CookieAction;

/**
 *
 * @author avbravo
 */
public class ProyectoInformacion extends CookieAction {

    NotifyDescriptor nd;
    String web = "";
    String src = "";

    public boolean getInformation(Project project, String typeOfproject) {
        try {
            typeOfproject=typeOfproject.toLowerCase();
            web = "";

            MySession.setEsProyectoWeb(false);
            MySession.setDirectorioWebInf("");

            if (project != null) {
                MySession.setNombreProyecto(project.getProjectDirectory().getName());
                String tipoProyecto = project.getClass().getSimpleName();
                MySession.setTipoProyecto(tipoProyecto);
                if (project.getProjectDirectory().getFileObject("src") == null) {
                    nd = new NotifyDescriptor.Message("El proyecto no contiene la carpeta src", NotifyDescriptor.Message.ERROR_MESSAGE);
                    DialogDisplayer.getDefault().notify(nd);

                    return false;
                }
                src = project.getProjectDirectory().getFileObject("src").toString();
                src = src.substring(src.indexOf("[") + 1, src.indexOf("@"));
                MySession.setSrc(src);

                if (tipoProyecto.equals("NbMavenProjectImpl")) {
                    /*
                     * maven
                     */
                    MySession.setSrcJava(MySession.getSrc() + MySession.getFileSeparator() + "main" + MySession.getFileSeparator() + "java");
                    String lweb = MySession.getSrc() + MySession.getFileSeparator() + "main" + MySession.getFileSeparator() + "webapp";
                    MySession.setResourcesPath("");
                    MySession.setReportPath("");
                    File file = new File(lweb);
                    if (file.exists()) {
                        //indica que es web
                        web = lweb;
                        MySession.setWeb(web);
                        MySession.setDirectorioWebInf(web + MySession.getFileSeparator() + "WEB-INF");
                        MySession.setEsProyectoWeb(true);

                        //Folder resources
                        String resourcesPath = lweb + MySession.getFileSeparator() + "resources";
                        MySession.setResourcesPath(resourcesPath);
                        File fileResources = new File(resourcesPath);
                        if (!fileResources.isDirectory()) {
                            //No existe el directorio hay que crearlo
                            if (fileResources.mkdir()) {
                                nd = new NotifyDescriptor.Message("No se puede crear la carpeta resources", NotifyDescriptor.Message.ERROR_MESSAGE);
                                DialogDisplayer.getDefault().notify(nd);
                                MySession.setResourcesPath("");
                                return false;
                            }

                        }

                        String reportPath = resourcesPath + MySession.getFileSeparator() + "reportes";

                        MySession.setReportPath(reportPath);

                        MySession.setReportShortPath("resources" + MySession.getFileSeparator() + "reportes" + MySession.getFileSeparator());

                        File fileReportes = new File(reportPath);
                        if (!fileReportes.isDirectory()) {
                            //No existe el directorio hay que crearlo
                            if (fileReportes.mkdir()) {
                                nd = new NotifyDescriptor.Message("No se puede crear la carpeta reportes", NotifyDescriptor.Message.ERROR_MESSAGE);
                                DialogDisplayer.getDefault().notify(nd);
                                MySession.setReportPath("");
                                return false;
                            }

                        }

                    }
                } else {

                    if (tipoProyecto.equals("NbModuleProject")) {
                        /*
                         * modulo netbeans
                         */
                        MySession.setSrcJava(MySession.getSrc());

                    } else {
                        if (tipoProyecto.equals("J2SEProject")) {
                            /*
                             * desktop
                             */
                            MySession.setSrcJava(MySession.getSrc());
                        } else {
                            if (tipoProyecto.equals("WebProject")) {
                                /*
                                 * web
                                 */
                                web = project.getProjectDirectory().getFileObject("web").toString();
                                web = web.substring(web.indexOf("[") + 1, web.indexOf("@"));
                                MySession.setSrcJava(MySession.getSrc() + MySession.getFileSeparator() + "java");
                                MySession.setDirectorioWebInf(web + MySession.getFileSeparator() + "WEB-INF");
                                MySession.setEsProyectoWeb(true);
                            }
                        }
                    }

                    MySession.setWeb(web);
                }

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
