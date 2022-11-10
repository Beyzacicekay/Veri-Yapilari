/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ınuyazeditor;

/**
 *
 * @author Fatih
 */
public class Dugum {
    int index;
    String kelime;
    
    public Dugum(int i, String s)
    {
        index = i;
        kelime = s;
    }
    
    public String ToString()
    {
       return index + " - " + kelime;
    }
    
}
