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
public class Parameters {
    private String name;
    private String type;


    public Parameters() {
    }

    public Parameters(String name, String type) {
        this.name = name;
        this.type = type;
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

    
    
    
}
