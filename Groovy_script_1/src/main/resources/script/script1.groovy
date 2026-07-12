/* Refer the link below to learn more about the use cases of script.
https://help.sap.com/viewer/368c481cd6954bdfa5d0435479fd4eaf/Cloud/en-US/148851bf8192412cba1f9d2c17f4bd25.html

If you want to know more about the SCRIPT APIs, refer the link below
https://help.sap.com/doc/a56f52e1a58e4e2bac7f7adbf45b2e26/Cloud/en-US/index.html */
import com.sap.gateway.ip.core.customdev.util.Message;

def Message processData(Message message) {

// To set or modify the body, you can use the following methods.
    def body = message.getBody();
    message.setBody("<ROOT>" + body + "</ROOT>");

    //To set or modify the headers, you can use the following methods.
    def headers = message.getHeaders();
    def value1 = headers.get("H_VAR1");
    def value2 = headers.get("H_VAR2");
    message.setHeader("H_VAR3" , value1.toInteger() * value2.toInteger() );
    

    //To set or modify the properties, you can use the following methods.
    def properties = message.getProperties();
    def value3 = properties.get("P_VAR1");
    def value4 = properties.get("P_VAR2");
    message.setProperty("P_VAR3", value3.toInteger() + value4.toInteger());
    
    return message;
}