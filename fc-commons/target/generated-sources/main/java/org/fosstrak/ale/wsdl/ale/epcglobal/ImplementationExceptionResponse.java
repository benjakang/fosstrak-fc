
package org.fosstrak.ale.wsdl.ale.epcglobal;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.1
 * 2019-04-10T16:21:22.448+08:00
 * Generated source version: 2.6.1
 */

@WebFault(name = "ImplementationException", targetNamespace = "urn:epcglobal:ale:wsdl:1")
public class ImplementationExceptionResponse extends Exception {
    
    private org.fosstrak.ale.wsdl.ale.epcglobal.ImplementationException implementationException;

    public ImplementationExceptionResponse() {
        super();
    }
    
    public ImplementationExceptionResponse(String message) {
        super(message);
    }
    
    public ImplementationExceptionResponse(String message, Throwable cause) {
        super(message, cause);
    }

    public ImplementationExceptionResponse(String message, org.fosstrak.ale.wsdl.ale.epcglobal.ImplementationException implementationException) {
        super(message);
        this.implementationException = implementationException;
    }

    public ImplementationExceptionResponse(String message, org.fosstrak.ale.wsdl.ale.epcglobal.ImplementationException implementationException, Throwable cause) {
        super(message, cause);
        this.implementationException = implementationException;
    }

    public org.fosstrak.ale.wsdl.ale.epcglobal.ImplementationException getFaultInfo() {
        return this.implementationException;
    }
}
