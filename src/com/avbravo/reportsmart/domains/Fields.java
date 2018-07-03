/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.reportsmart.domains;

/**
 *
 * @author avbravo
 */
public class Fields {
    private String name;
    private String type;
    private String label;
    private Integer orden;

    public Fields() {
    }

    public Fields(String name, String type, String label, Integer orden) {
        this.name = name;
        this.type = type;
        this.label = label;
        this.orden = orden;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
    
    
    
}
