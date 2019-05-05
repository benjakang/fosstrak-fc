
package org.fosstrak.ale.wsdl.ale.epcglobal;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.1
 * 2019-04-10T16:21:22.456+08:00
 * Generated source version: 2.6.1
 */

@WebFault(name = "InvalidURIException", targetNamespace = "urn:epcglobal:ale:wsdl:1")
public class InvalidURIExceptionResponse extends Exception {
    
    private org.fosstrak.ale.wsdl.ale.epcglobal.InvalidURIException invalidURIException;

    public InvalidURIExceptionResponse() {
        super();
    }
    
    public InvalidURIExceptionResponse(String message) {
        super(message);
    }
    
    public InvalidURIExceptionResponse(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidURIExceptionResponse(String message, org.fosstrak.ale.wsdl.ale.epcglobal.InvalidURIException invalidURIException) {
        super(message);
        this.invalidURIException = invalidURIException;
    }

    public InvalidURIExceptionResponse(String message, org.fosstrak.ale.wsdl.ale.epcglobal.InvalidURIException invalidURIException, Throwable cause) {
        super(message, cause);
        this.invalidURIException = invalidURIException;
    }

    public org.fosstrak.ale.wsdl.ale.epcglobal.InvalidURIException getFaultInfo() {
        return this.invalidURIException;
    }
}
