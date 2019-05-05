
package org.fosstrak.ale.wsdl.aleac.epcglobal;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.1
 * 2019-04-10T16:21:22.865+08:00
 * Generated source version: 2.6.1
 */

@WebFault(name = "NoSuchClientIdentityException", targetNamespace = "urn:epcglobal:aleac:wsdl:1")
public class NoSuchClientIdentityExceptionResponse extends Exception {
    
    private org.fosstrak.ale.wsdl.aleac.epcglobal.NoSuchClientIdentityException noSuchClientIdentityException;

    public NoSuchClientIdentityExceptionResponse() {
        super();
    }
    
    public NoSuchClientIdentityExceptionResponse(String message) {
        super(message);
    }
    
    public NoSuchClientIdentityExceptionResponse(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchClientIdentityExceptionResponse(String message, org.fosstrak.ale.wsdl.aleac.epcglobal.NoSuchClientIdentityException noSuchClientIdentityException) {
        super(message);
        this.noSuchClientIdentityException = noSuchClientIdentityException;
    }

    public NoSuchClientIdentityExceptionResponse(String message, org.fosstrak.ale.wsdl.aleac.epcglobal.NoSuchClientIdentityException noSuchClientIdentityException, Throwable cause) {
        super(message, cause);
        this.noSuchClientIdentityException = noSuchClientIdentityException;
    }

    public org.fosstrak.ale.wsdl.aleac.epcglobal.NoSuchClientIdentityException getFaultInfo() {
        return this.noSuchClientIdentityException;
    }
}
