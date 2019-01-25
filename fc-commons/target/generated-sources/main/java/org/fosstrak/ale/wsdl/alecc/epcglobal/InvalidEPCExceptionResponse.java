
package org.fosstrak.ale.wsdl.alecc.epcglobal;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.1
 * 2019-01-25T13:11:16.299+08:00
 * Generated source version: 2.6.1
 */

@WebFault(name = "InvalidEPCException", targetNamespace = "urn:epcglobal:alecc:wsdl:1")
public class InvalidEPCExceptionResponse extends Exception {
    
    private org.fosstrak.ale.wsdl.alecc.epcglobal.InvalidEPCException invalidEPCException;

    public InvalidEPCExceptionResponse() {
        super();
    }
    
    public InvalidEPCExceptionResponse(String message) {
        super(message);
    }
    
    public InvalidEPCExceptionResponse(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEPCExceptionResponse(String message, org.fosstrak.ale.wsdl.alecc.epcglobal.InvalidEPCException invalidEPCException) {
        super(message);
        this.invalidEPCException = invalidEPCException;
    }

    public InvalidEPCExceptionResponse(String message, org.fosstrak.ale.wsdl.alecc.epcglobal.InvalidEPCException invalidEPCException, Throwable cause) {
        super(message, cause);
        this.invalidEPCException = invalidEPCException;
    }

    public org.fosstrak.ale.wsdl.alecc.epcglobal.InvalidEPCException getFaultInfo() {
        return this.invalidEPCException;
    }
}