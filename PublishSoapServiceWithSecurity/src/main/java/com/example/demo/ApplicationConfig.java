package com.example.demo;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.xml.ws.Endpoint;

@Configuration
public class ApplicationConfig {

    @Autowired
    private Bus bus;


    //Endpoint becomes http://localhost:8080/services/soap/MyService?wsdl
    @Bean
    public Endpoint endpoint(MyServiceImpl myServiceImpl) {
        EndpointImpl endpoint = new EndpointImpl(bus, myServiceImpl, javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING);
        endpoint.publish("/soap/MyService");
        return endpoint;
    }

}
