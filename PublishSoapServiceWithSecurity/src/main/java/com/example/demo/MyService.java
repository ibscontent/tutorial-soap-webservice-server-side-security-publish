package com.example.demo;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

@WebServiceClient(name = "MyService", wsdlLocation = "classpath:NameProviderService.wsdl", targetNamespace = "http://ws.example.com/MyService2/wsdl")
public class MyService extends Service {

    protected MyService(URL wsdlDocumentLocation, QName serviceName) {
        super(wsdlDocumentLocation, serviceName);
    }

    protected MyService(URL wsdlDocumentLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlDocumentLocation, serviceName, features);
    }

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://ws.example.com/MyService2/wsdl", "MyService");
    public final static QName NameServiceSOAPBinding = new QName("http://ws.example.com/MyService2/wsdl",
            "NameServiceSOAPBinding");
    static {
        URL url = null;
        try {
            url = new URL("classpath:NameProviderService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(MyService.class.getName()).log(Level.SEVERE, "Cannot load the wsdl file.");
        }
        WSDL_LOCATION = url;
    }

    @WebEndpoint(name = "MyServiceSOAPBinding")
    public MyServicePort getNameServiceSOAPBinding() {
        return super.getPort(NameServiceSOAPBinding, MyServicePort.class);
    }

    @WebEndpoint(name = "MyServiceSOAPBinding")
    public MyServicePort getNameServiceSOAPBinding(WebServiceFeature... features) {
        return super.getPort(NameServiceSOAPBinding, MyServicePort.class, features);
    }

}
