/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv11u3;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Dominik
 */
public class MyHandler1 extends DefaultHandler {

    boolean recept = false;
    boolean polozka = false;
    boolean omeleta = false;
    boolean mlieko = false;
    String nazov = null;
    String text = null;
    String jednotka = null;
    String mnozstvo = null;
    
    public MyHandler1() {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) {

        if (localName.equals("recept")) {
            recept = true;
        }

        if (localName.equals("polozka")) {
            polozka = true;
            recept = false;
        }
        
        if (localName.equals("mnozstvo")) {
            jednotka = atts.getValue("jednotka");
        }
        
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        if (localName.equals("recept")) {
            recept = false;
        }
        
        if (polozka == true && localName.equals("nazov") && text.equals("mlieko")){
            mlieko = true;
        }
        
        if (polozka == true && localName.equals("mnozstvo")){
            mnozstvo = text;
        }
        
        if (localName.equals("polozka") && mlieko == true && mnozstvo.length() > 0){
            System.out.println(mnozstvo + " " + jednotka);
            mlieko = false;
            polozka = false;
            recept = true;
            mnozstvo = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text = new String(ch, start, length);
    }

}
