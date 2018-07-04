/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.reportsmart.domains;
// <editor-fold defaultstate="collapsed" desc="import">


import com.avbravo.reportsmarts.beans.Atributos;
import com.avbravo.reportsmarts.beans.Embedded;
import com.avbravo.reportsmarts.beans.Entidad;
import com.avbravo.reportsmarts.beans.Referenced;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// </editor-fold>

/**
 *
 * @author avbravoserver
 */

public class EntityReader implements Serializable {
// <editor-fold defaultstate="collapsed" desc="atributos">

    private static final long serialVersionUID = 1L;
    public static final String DEFAULT_CHARSET = "UTF-8";
   

    Entidad entidad = new Entidad();
    List<Atributos> atributosList = new ArrayList<>();
    List<Referenced> referencedList = new ArrayList<>();
    List<Embedded> embeddedList = new ArrayList<>();
    private Boolean terminaReferenced = true;

    Boolean startReferenced = false;
    Boolean endReferenced = false;
    Boolean endEmbedded = false;

    private String campoId = "";
    Integer fila = 0;
    Integer rowId = 0;
    Integer contador = 0;
    private Boolean detener = false;

    // </editor-fold>
    /**
     * Creates a new instance of ProcesarEntity
     */
    public EntityReader() {
    }
// <editor-fold defaultstate="collapsed" desc="readEntity">

    public Boolean readEntity(String name, String texto) {
        try {
           
           
            /**
             *
             */
            entidad = new Entidad();
            entidad.setTabla(name);
            atributosList = new ArrayList<>();
            referencedList = new ArrayList<>();
            embeddedList = new ArrayList<>();

            fila = 0;
            rowId = 0;
            campoId = "";
            // buscar el campo que es primaryKey
            if (!searchId(texto)) {
                MySession.setAllTablesWithPrimaryKey(false);
                MySession.getMensajesInformacion().add(name + " No tiene Primary Key");
                
            }else {
                 MySession.setAllTablesWithPrimaryKey(true);
            }
            // procesar los atributos
            startReferenced = false;
            endReferenced = false;
             for (String line : texto.split("\\n")){
                   linea(line);
             }
           

            //Referenciado
              for (String line : texto.split("\\n")){

                if (line.contains("@Referenced") && line.contains(")")) {
                    startReferenced = true;
                    endReferenced = true;
                } else {
                    if (line.contains("@Referenced") && !line.contains(")")) {
                        startReferenced = true;
                        endReferenced = false;
                    } else {
                        if (startReferenced && !endReferenced && line.contains(")")) {
                            endReferenced = true;

                        } else {
                            if (endReferenced) {
                                lineReferenced(line);
                                startReferenced = false;
                                endReferenced = false;
                            }
                        }
                    }

                }

            }

            endEmbedded = false;
           for (String line : texto.split("\\n")){
                if (line.contains("@Embedded")) {
                    endEmbedded = true;
                } else {
                    if (endEmbedded) {
                        lineEmbedded(line);
                        endEmbedded = false;
                    }
                }

            }
            Boolean esEmbebido;
            Boolean esList = false;
            Boolean esReferenciado;
            Integer contador = 0;
            /**
             * Se indica si el atributo es Embebido o referenciado
             */

            for (Atributos a : atributosList) {
                atributosList.get(contador).setEsReferenced(false);

                if (!embeddedList.isEmpty()) {
 
                    esEmbebido = false;
                    esList = false;

                    for (Embedded e : embeddedList) {
                        if (a.getNombre().toLowerCase().equals(e.getField().toLowerCase())) {
                            esEmbebido = true;
                            esList = e.getEsList();
                            break; 
                        }
                    }
                    atributosList.get(contador).setEsEmbedded(esEmbebido);
                    atributosList.get(contador).setEsListEmbedded(esList);
                    

                } else {
                    atributosList.get(contador).setEsEmbedded(false);
                    atributosList.get(contador).setEsListEmbedded(false);
                }
                contador++;
            }
            /*
            Referenced
             */
            contador = 0;
            for (Atributos a : atributosList) {
                atributosList.get(contador).setEsReferenced(false);
                if (!referencedList.isEmpty()) {
                    esReferenciado = false;
                    esList = false;
                    for (Referenced r : referencedList) {
                        if (a.getNombre().equals(r.getField())) {
                            esReferenciado = true;
                            esList = r.getEsList();
                            break;
                        }
                    }
                    atributosList.get(contador).setEsReferenced(esReferenciado);
                    atributosList.get(contador).setEsListReferenced(esList);
                } else {
                    atributosList.get(contador).setEsReferenced(false);
                    atributosList.get(contador).setEsListReferenced(false);

                }
                contador++;
            }

            entidad.setAtributosList(atributosList);
            entidad.setEmbeddedList(embeddedList);
            entidad.setReferencedList(referencedList);
            MySession.getEntidadList().add(entidad);
        } catch (Exception e) {
            MySession.error("readEntity() " + e.getLocalizedMessage());

        }
        return true;

    }// </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="linea">
    /*
    se establece el tipo de datos
     */
    private void linea(String s) {
        try {
            Atributos atributos = new Atributos();
            if (s.indexOf("private static final long serialVersionUID = 1L;") != -1 || s.indexOf("private Collection") != -1) {
                //no se toma en cuenta
            } else if (s.indexOf("@Id") != -1) {
                //id
            } else if (s.indexOf("private") != -1) {
                s = s.replace("private", "");
                s = s.replace(";", "");
                s = s.trim();
                String[] splited = s.split("\\s");
//                atributos.setTipo(splited[0]);
                atributos.setTipo(Utilidades.mysqlToJava(splited[0]));

                atributos.setNombre(splited[1]);
                atributos.setEsPrimaryKey(atributos.getNombre().equals(campoId));

                atributosList.add(atributos);

            } else {
                if (s.indexOf("@Referenced") != -1) {
                    //  terminaReferenced=true;

                } else {
                    if (s.indexOf("@Embedded") != -1) {
                        //terminaEmbedded = true;

                    }
                }
            }
        } catch (Exception e) {
            MySession.error("EntidadGenerador.linea() " + e.getLocalizedMessage());
        }

    }

    private Boolean searchId(String texto) {
        try {

            for (String line : texto.split("\\n")){
                fila++;
                if (line.indexOf("@Id") != -1) {
                    rowId = fila;
                }
            }

            if (rowId != 0) {
                if (!searchNameFieldId(texto)) {
                    MySession.advertencia("No se encontre el campo llave del entity");
                    return false;
                }
                return true;
            }
        } catch (Exception e) {
            MySession.error("searchId() " + e.getLocalizedMessage());
        }

        return false;
    }// </editor-fold> 
// <editor-fold defaultstate="collapsed" desc="searchNameFieldId">

    private Boolean searchNameFieldId(String texto) {
        try {
            contador = 0;
            detener = false;
            campoId = "";
             for (String line : texto.split("\\n")){
                  contador++;
                if (!detener) {
                    if (contador >= rowId + 1) {
                        if (line.indexOf("private") != -1) {
                            line = line.replace("private", "");
                            line = line.replace(";", "");
                            line = line.trim();
                            String[] splited = line.split("\\s");
                            campoId = splited[1];
                            detener = true;
                        }
                    }
                }

            }

            if (!campoId.equals("")) {
                return true;
            }
        } catch (Exception e) {
            MySession.error("searchNameFieldId() " + e.getLocalizedMessage());
        }
        //private static final long serialVersionUID = 1L;
        //private Collection
        return false;
    }// </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="lineReferenced">
    private void lineReferenced(String s) {
        try {

//            if (terminaReferenced) {
            Referenced referenced = new Referenced();
            // aqui es la linea referenciada
            if (s.contains("List")) {
                referenced.setEsList(true);
                if (s.contains("private List<")) {
                    s = s.replace("private List<", "");
                } else {
                    s = s.replace("List<", "");
                }
                if (s.contains(">")) {
                    s = s.replace(">", "");
                }

            } else {
                referenced.setEsList(false);
                if (s.contains("private")) {
                    s = s.replace("private", "");
                }

            }
            if (s.contains(";")) {
                s = s.replace(";", "");
            }

            s = s.trim();
            String[] splited = s.split("\\s");
            referenced.setType(splited[0]);
            referenced.setField(splited[1]);
            referencedList.add(referenced);

        } catch (Exception e) {
            MySession.error("lineReferenced() " + e.getLocalizedMessage());

        }

    }// </editor-fold> 
// <editor-fold defaultstate="collapsed" desc="lineEmbedded">

    private void lineEmbedded(String s) {
        try {

            Embedded embedded = new Embedded();
            if (s.contains("List")) {
                embedded.setEsList(true);
                if (s.contains("private List<")) {
                    s = s.replace("private List<", "");
                } else {
                    if (s.contains("List<")) {
                        s = s.replace("List<", "");
                    }
                }
                if (s.contains(">")) {
                    s = s.replace(">", "");
                }
            } else {
                embedded.setEsList(false);
                if (s.contains("private")) {
                    s = s.replace("private", "");
                }
            }

            if (s.contains(";")) {
                s = s.replace(";", "");
            }

            s = s.trim();

            String[] splited = s.split("\\s");
            embedded.setType(splited[0]);
            embedded.setField(splited[1]);
            embeddedList.add(embedded);

        } catch (Exception e) {
            MySession.error("lineEmbedded() " + e.getLocalizedMessage());
        }

    }// </editor-fold> 
}
