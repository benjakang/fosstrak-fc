
package org.fosstrak.ale.wsdl.alecc.epcglobal;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.1
 * 2019-01-25T13:11:16.260+08:00
 * Generated source version: 2.6.1
 */

@WebFault(name = "SecurityException", targetNamespace = "urn:epcglobal:alecc:wsdl:1")
public class SecurityExceptionResponse extends Exception {
    
    private org.fosstrak.ale.wsdl.alecc.epcglobal.SecurityException securityException;

    public SecurityExceptionResponse() {
        super();
    }
    
    public SecurityExceptionResponse(String message) {
        super(message);
    }
    
    public SecurityExceptionResponse(String message, Throwable cause) {
        super(message, cause);
    }

    public SecurityExceptionResponse(String message, org.fosstrak.ale.wsdl.alecc.epcglobal.SecurityException securityException) {
        super(message);
        this.securityException = securityException;
    }

    public SecurityExceptionResponse(String message, org.fosstrak.ale.wsdl.alecc.epcglobal.SecurityException securityException, Throwable cause) {
        super(message, cause);
        this.securityException = securityException;
    }

    public org.fosstrak.ale.wsdl.alecc.epcglobal.SecurityException getFaultInfo() {
        return this.securityException;
    }
}
