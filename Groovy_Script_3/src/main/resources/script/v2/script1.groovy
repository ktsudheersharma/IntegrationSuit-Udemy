// This is Groovy Flowstep Version 2.x, running with Groovy runtime 4, Downgrade the script if older behaviour needed.

/* Refer the link below to learn more about the use cases of script.
https://help.sap.com/viewer/368c481cd6954bdfa5d0435479fd4eaf/Cloud/en-US/148851bf8192412cba1f9d2c17f4bd25.html

If you want to know more about the SCRIPT APIs, refer the link below
https://help.sap.com/doc/a56f52e1a58e4e2bac7f7adbf45b2e26/Cloud/en-US/index.html */
import com.sap.it.script.v2.api.Message;
import groovy.xml.XmlParser
import groovy.xml.XmlUtil

def Message processData(Message message) {

/*    /*To set or modify the body, you can use the following methods. */
//    def body = message.getBody(java.lang.String);
    // Parse XMl into a document  tree that may be traversed similar to XPATH expressions
//    def root = new XmlSlurper().parseText(body);

/*    def reader = message.getBody(java.io.Reader);
/*    def root = new XmlSlurper().parse(reader);
/*    def cnt  = root.'*'.size(); */

    def reader = message.getBody(java.io.Reader)
    def root = new XmlParser().parse(reader)
    def orders = root.'Order'    
    
   for (int i = 0; i<orders.size(); i++){
       
       def price = orders[i].Price.text().toInteger();
       def qty   = orders[i].OrdQty.text().toInteger();
       def value = price * qty;
       orders[i].appendNode('Amount', value.toString())
   }
   
   String outxml = XmlUtil.serialize(root);
   message.setBody(outxml);
    
    return message;
}
