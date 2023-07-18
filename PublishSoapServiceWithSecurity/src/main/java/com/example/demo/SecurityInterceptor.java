package com.example.demo;

import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class SecurityInterceptor extends WSS4JInInterceptor {

    static Map<String, Object> securityInterceptor;
    static {
        securityInterceptor = new HashMap<String, Object>();
        securityInterceptor.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
        securityInterceptor.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_DIGEST);
        securityInterceptor.put(WSHandlerConstants.PW_CALLBACK_CLASS, SecurityHandler.class.getName());
    }

    public SecurityInterceptor() {
        super(securityInterceptor);
    }

}
