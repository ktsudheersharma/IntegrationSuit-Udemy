/* Refer the link below to learn more about the use cases of script.
https://help.sap.com/viewer/368c481cd6954bdfa5d0435479fd4eaf/Cloud/en-US/148851bf8192412cba1f9d2c17f4bd25.html

If you want to know more about the SCRIPT APIs, refer the link below
https://help.sap.com/doc/a56f52e1a58e4e2bac7f7adbf45b2e26/Cloud/en-US/index.html */
import com.sap.gateway.ip.core.customdev.util.Message;
import com.sap.it.api.msglog.MessageLogFactory
import com.sap.it.api.msglog.MessageLog

def Message processData(Message message) {

// To set or modify the body, you can use the following methods.
    def body = message.getBody(java.lang.String);
    message.setBody("<Root>" + body + "</Root>");

    //To set or modify the headers, you can use the following methods.
    def headers = message.getHeaders();
    def Hvalue1 = headers.get("H_VAR1");
    def Hvalue2 = headers.get("H_VAR2");
    message.setHeader("H_VAR3" , Hvalue1.toInteger() * Hvalue2.toInteger() );
    

    //To set or modify the properties, you can use the following methods.
    def properties = message.getProperties();
    def Pvalue1 = properties.get("P_VAR1");
    def Pvalue2 = properties.get("P_VAR2");
    message.setProperty("P_VAR3", Pvalue1.toInteger() + Pvalue2.toInteger());
    
    // Message processing log
    def messageLog = messageLogFactory.getMessageLog(message);
    messageLog.setStringProperty("Log file","Payload as an attachment");
    messageLog.addAttachmentAsString("Log File",body,"application/json");
    
    return message;
}