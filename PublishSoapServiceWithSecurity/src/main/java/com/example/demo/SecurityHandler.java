package com.example.demo;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

public class SecurityHandler implements CallbackHandler {
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        if(callbacks != null && callbacks.length > 0) {
            WSPasswordCallback getPass = (WSPasswordCallback) callbacks[0];
            if (getPass.getIdentifier().equals("james")) {
                getPass.setPassword("dean");
            }
        }
    }

}
