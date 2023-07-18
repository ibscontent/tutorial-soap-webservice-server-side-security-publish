package com.example.demo;

import com.example.ws.GetNameRequest;
import com.example.ws.GetNameResponse;
import org.apache.cxf.annotations.SchemaValidation;
import org.apache.cxf.annotations.SchemaValidation.SchemaValidationType;
import org.apache.cxf.interceptor.InInterceptors;
import org.springframework.stereotype.Service;

@Service
@SchemaValidation(type = SchemaValidationType.REQUEST)
@InInterceptors(classes = SecurityInterceptor.class)
public class MyServiceImpl implements MyServicePort {

    @Override
    public GetNameResponse getName(GetNameRequest parameters) {
        GetNameResponse response = new GetNameResponse();
        response.setReturn("Service "+parameters.getArg0());
        return response;
    }

}