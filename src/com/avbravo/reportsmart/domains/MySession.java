/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.reportsmart.domains;

import com.avbravo.reportsmart.rules.EntidadPatron;
import com.avbravo.reportsmart.beans.Entidad;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;

/**
 *
 * @author avbravo
 */
public class MySession {
static Boolean allTablesWithPrimaryKey = true;
    static String SistemaOperativo;
    static String nombreProyecto;
    static String tipoProyecto;
    static String src;
    static String srcJava;
    static String web;
    static String directorioWebInf;
    static boolean esProyectoWeb;
    static String fileSeparator;
    static String var;
    static String primefacesVersion;
    static String faceletsTemplate;
    static String temaPrimefaces;
    static String resourcesPath;
    static String reportPath;
    static String reportShortPath;
    static String fields="";
    static String parameters="";
    static String nameOfProject="";
    static String nameOfReport="";
    static String nameOfPackage="";
    static DefaultTableModel modeloFields;
    static DefaultTableModel modeloParameters;
     static List<Entidad> entidadList = new ArrayList<>();
   static  List<Fields> fieldsList = new ArrayList<>();
   static  List<Parameters> parametersList = new ArrayList<>();
    static List<String> mensajesInformacion = new ArrayList<>();
static  List<EntidadPatron> entidadPatronList = new ArrayList<>();

  public static String compilarReporteaJasper = "";
  
  static String titleBand="";
  static String pageHeaderBand="";
  static String columnHeaderBand="";
  static String detailBand="";
  static String colummFooterBand="";
  static String pageFooterBand="";
  static String summaryBand="";
  

    /**
     * Date GMT+2
     */
   static String timeZone = "";
    static String patternDate = "dd/MM/yyyy";
    static String patternDateTime = "HH:mm dd/MM/yyyy";

    public static String getTitleBand() {
        return titleBand;
    }

    public static void setTitleBand(String titleBand) {
        MySession.titleBand = titleBand;
    }

    public static String getPageHeaderBand() {
        return pageHeaderBand;
    }

    public static void setPageHeaderBand(String pageHeaderBand) {
        MySession.pageHeaderBand = pageHeaderBand;
    }

    public static String getColumnHeaderBand() {
        return columnHeaderBand;
    }

    public static void setColumnHeaderBand(String columnHeaderBand) {
        MySession.columnHeaderBand = columnHeaderBand;
    }

    public static String getDetailBand() {
        return detailBand;
    }

    public static void setDetailBand(String detailBand) {
        MySession.detailBand = detailBand;
    }

    public static String getColummFooterBand() {
        return colummFooterBand;
    }

    public static void setColummFooterBand(String colummFooterBand) {
        MySession.colummFooterBand = colummFooterBand;
    }

    public static String getPageFooterBand() {
        return pageFooterBand;
    }

    public static void setPageFooterBand(String pageFooterBand) {
        MySession.pageFooterBand = pageFooterBand;
    }

    public static String getSummaryBand() {
        return summaryBand;
    }

    public static void setSummaryBand(String summaryBand) {
        MySession.summaryBand = summaryBand;
    }
    
    
    
    
    
    public static Boolean getAllTablesWithPrimaryKey() {
        return allTablesWithPrimaryKey;
    }

    public static void setAllTablesWithPrimaryKey(Boolean allTablesWithPrimaryKey) {
        MySession.allTablesWithPrimaryKey = allTablesWithPrimaryKey;
    }

    public static String getCompilarReporteaJasper() {
        return compilarReporteaJasper;
    }

    public static void setCompilarReporteaJasper(String compilarReporteaJasper) {
        MySession.compilarReporteaJasper = compilarReporteaJasper;
    }

    public static String getTimeZone() {
        return timeZone;
    }

    public static void setTimeZone(String timeZone) {
        MySession.timeZone = timeZone;
    }

    public static String getPatternDate() {
        return patternDate;
    }

    public static void setPatternDate(String patternDate) {
        MySession.patternDate = patternDate;
    }

    public static String getPatternDateTime() {
        return patternDateTime;
    }

    public static void setPatternDateTime(String patternDateTime) {
        MySession.patternDateTime = patternDateTime;
    }

    



   

    public static String getFields() {
        return fields;
    }

    public static void setFields(String fields) {
        MySession.fields = fields;
    }

    public static String getParameters() {
        return parameters;
    }

    public static void setParameters(String parameters) {
        MySession.parameters = parameters;
    }

    public static String getNameOfProject() {
        return nameOfProject;
    }

    public static void setNameOfProject(String nameOfProject) {
        MySession.nameOfProject = nameOfProject;
    }

    public static List<Entidad> getEntidadList() {
        return entidadList;
    }

    public static void setEntidadList(List<Entidad> entidadList) {
        MySession.entidadList = entidadList;
    }

    public static List<Parameters> getParametersList() {
        return parametersList;
    }

    public static void setParametersList(List<Parameters> parametersList) {
        MySession.parametersList = parametersList;
    }

    public static List<String> getMensajesInformacion() {
        return mensajesInformacion;
    }

    public static void setMensajesInformacion(List<String> mensajesInformacion) {
        MySession.mensajesInformacion = mensajesInformacion;
    }

    public static List<EntidadPatron> getEntidadPatronList() {
        return entidadPatronList;
    }

    public static void setEntidadPatronList(List<EntidadPatron> entidadPatronList) {
        MySession.entidadPatronList = entidadPatronList;
    }

   
   
   
    public static List<Fields> getFieldsList() {
        return fieldsList;
    }

    public static void setFieldsList(List<Fields> fieldsList) {
        MySession.fieldsList = fieldsList;
    }

   
     
     
    public static String getNameOfReport() {
        return nameOfReport;
    }

    public static void setNameOfReport(String nameOfReport) {
        MySession.nameOfReport = nameOfReport;
    }

    public static String getNameOfPackage() {
        return nameOfPackage;
    }

    public static void setNameOfPackage(String nameOfPackage) {
        MySession.nameOfPackage = nameOfPackage;
    }

    

    public static String getReportShortPath() {
        return reportShortPath;
    }

    public static void setReportShortPath(String reportShortPath) {
        MySession.reportShortPath = reportShortPath;
    }

    public static DefaultTableModel getModeloFields() {
        return modeloFields;
    }

    public static void setModeloFields(DefaultTableModel modeloFields) {
        MySession.modeloFields = modeloFields;
    }

    public static DefaultTableModel getModeloParameters() {
        return modeloParameters;
    }

    public static void setModeloParameters(DefaultTableModel modeloParameters) {
        MySession.modeloParameters = modeloParameters;
    }

    
    
    
    public static String getResourcesPath() {
        return resourcesPath;
    }

    public static void setResourcesPath(String resourcesPath) {
        MySession.resourcesPath = resourcesPath;
    }

    
    
    
    public static String getReportPath() {
        return reportPath;
    }

    public static void setReportPath(String reportPath) {
        MySession.reportPath = reportPath;
    }
    
    
    

    public static String getTemaPrimefaces() {
        return temaPrimefaces;
    }

    public static void setTemaPrimefaces(String temaPrimefaces) {
        MySession.temaPrimefaces = temaPrimefaces;
    }

    
    
    
    public static String getFaceletsTemplate() {
        return faceletsTemplate;
    }

    public static void setFaceletsTemplate(String faceletsTemplate) {
        MySession.faceletsTemplate = faceletsTemplate;
    }

    public static String getPrimefacesVersion() {
        return primefacesVersion;
    }

    public static void setPrimefacesVersion(String primefacesVersion) {
        MySession.primefacesVersion = primefacesVersion;
    }

    public static String getVar() {
        return var;
    }

    public static void setVar(String var) {
        MySession.var = var;
    }

    /*
     *
     */
    public static boolean isEsProyectoWeb() {
        return esProyectoWeb;
    }

    public static void setEsProyectoWeb(boolean esProyectoWeb) {
        MySession.esProyectoWeb = esProyectoWeb;
    }

    public static String getSistemaOperativo() {
        //linux
        return System.getProperty("os.name").toLowerCase();
    }

    public static void setSistemaOperativo(String SistemaOperativo) {
        MySession.SistemaOperativo = SistemaOperativo;
    }

    public static String getFileSeparator() {
        return System.getProperties().getProperty("file.separator");
    }

    public static void setFileSeparator(String fileSeparator) {
        MySession.fileSeparator = fileSeparator;
    }

    public static String getNombreProyecto() {
        return nombreProyecto;
    }

    public static void setNombreProyecto(String nombreProyecto) {
        MySession.nombreProyecto = nombreProyecto;
    }

    public static String getSrc() {
        return src;
    }

    public static void setSrc(String src) {
        MySession.src = src;
    }

    public static String getTipoProyecto() {
        return tipoProyecto;
    }

    public static void setTipoProyecto(String tipoProyecto) {
        MySession.tipoProyecto = tipoProyecto;
    }

    public static String getWeb() {
        return web;
    }

    public static void setWeb(String web) {
        MySession.web = web;
    }

    public static String getSrcJava() {
        return srcJava;
    }

    public static void setSrcJava(String srcJava) {
        MySession.srcJava = srcJava;
    }

    public static String getDirectorioWebInf() {
        return directorioWebInf;
    }

    public static void setDirectorioWebInf(String directorioWebInf) {
        MySession.directorioWebInf = directorioWebInf;
    }

    /*
     * convierte de ingles a español para el crud
     */
    public static String crudEnglishToSpanish(String lcrud) {
        String crudSpanish = "";
        lcrud= lcrud.toLowerCase();
        if (lcrud.equals("insert")) {
            crudSpanish = "Crear";
        } else {
            if (lcrud.equals("edit")) {
                crudSpanish = "Editar";
            } else {
                if (lcrud.equals("list")) {
                    crudSpanish = "Listar";
                } else {
                    if (lcrud.equals("query")) {
                        crudSpanish = "Consultar";
                    } else {
                        if (lcrud.equals("delete")) {
                            crudSpanish = "Eliminar";
                        }
                    }
                }
            }
        }
        return crudSpanish;
    }

    public static void error(String msg) {
        NotifyDescriptor nd;
        try {
            nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.Message.ERROR_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);
        } catch (Exception ex) {
            nd = new NotifyDescriptor.Message("Error() " + ex.getLocalizedMessage(), NotifyDescriptor.Message.ERROR_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);
        }
    }
     public static void advertencia(String msg) {
        NotifyDescriptor nd;
        try {
            nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.Message.WARNING_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);
        } catch (Exception ex) {
            nd = new NotifyDescriptor.Message("Advertencia() " + ex.getLocalizedMessage(), NotifyDescriptor.Message.WARNING_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);
        }
    }
     
     public static void informacion(String msg) {
        NotifyDescriptor nd;
        try {
            nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.Message.INFORMATION_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);
        } catch (Exception ex) {
            nd = new NotifyDescriptor.Message("Advertencia() " + ex.getLocalizedMessage(), NotifyDescriptor.Message.INFORMATION_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);
        }
    }
}
