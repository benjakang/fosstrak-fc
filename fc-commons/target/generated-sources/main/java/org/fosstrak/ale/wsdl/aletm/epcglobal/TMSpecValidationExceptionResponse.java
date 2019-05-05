
package org.fosstrak.ale.wsdl.aletm.epcglobal;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.1
 * 2019-04-10T16:21:23.693+08:00
 * Generated source version: 2.6.1
 */

@WebFault(name = "TMSpecValidationException", targetNamespace = "urn:epcglobal:aletm:wsdl:1")
public class TMSpecValidationExceptionResponse extends Exception {
    
    private org.fosstrak.ale.wsdl.aletm.epcglobal.TMSpecValidationException tmSpecValidationException;

    public TMSpecValidationExceptionResponse() {
        super();
    }
    
    public TMSpecValidationExceptionResponse(String message) {
        super(message);
    }
    
    public TMSpecValidationExceptionResponse(String message, Throwable cause) {
        super(message, cause);
    }

    public TMSpecValidationExceptionResponse(String message, org.fosstrak.ale.wsdl.aletm.epcglobal.TMSpecValidationException tmSpecValidationException) {
        super(message);
        this.tmSpecValidationException = tmSpecValidationException;
    }

    public TMSpecValidationExceptionResponse(String message, org.fosstrak.ale.wsdl.aletm.epcglobal.TMSpecValidationException tmSpecValidationException, Throwable cause) {
        super(message, cause);
        this.tmSpecValidationException = tmSpecValidationException;
    }

    public org.fosstrak.ale.wsdl.aletm.epcglobal.TMSpecValidationException getFaultInfo() {
        return this.tmSpecValidationException;
    }
}
