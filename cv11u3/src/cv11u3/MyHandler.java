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
public class MyHandler extends DefaultHandler {

    boolean recept = false;
    boolean polozka = false;
    boolean muka = false;
    String nazov = null;
    String text = null;
    String receptName = null;

    public MyHandler() {
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

    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        if (localName.equals("recept")) {
            recept = false;
        }

        if (localName.equals("polozka")) {
            polozka = false;
            recept = true;
        }

        if (localName.equals("nazov") && recept == true){
            receptName = text;
        }
        
        if (localName.equals("nazov") && polozka == true && text.equals("muka")){
            muka = true;
        }
        
        if (localName.equals("recept")){
            if(muka == true){
                System.out.println(receptName);
            }
            polozka = false;
            recept = false;
            receptName = null;
            muka = false;
        }
        
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text = new String(ch, start, length);
    }

}
