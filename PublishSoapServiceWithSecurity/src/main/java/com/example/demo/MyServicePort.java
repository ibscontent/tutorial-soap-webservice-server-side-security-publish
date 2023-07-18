package com.example.demo;

import com.example.ws.GetNameRequest;
import com.example.ws.GetNameResponse;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(targetNamespace = "http://ws.example.com/", name = "MyServicePort")
@XmlSeeAlso({com.example.ws.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface MyServicePort {

    @WebMethod(operationName = "GetName", action = "http://ws.example.com/MyService/GetName")
    @WebResult(name = "GetNameResponse", targetNamespace = "http://ws.example.com/MyService/schema", partName = "parameters")
    public GetNameResponse getName(
            @WebParam(partName = "parameters", name = "GetNameRequest", targetNamespace = "http://ws.example.com/MyService/schema") GetNameRequest parameters
    );

}
