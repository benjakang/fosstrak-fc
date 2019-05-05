
package org.fosstrak.ale.wsdl.alecc.epcglobal;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.1
 * 2019-04-10T16:21:23.323+08:00
 * Generated source version: 2.6.1
 */

@WebFault(name = "InvalidAssocTableEntryException", targetNamespace = "urn:epcglobal:alecc:wsdl:1")
public class InvalidAssocTableEntryExceptionResponse extends Exception {
    
    private org.fosstrak.ale.wsdl.alecc.epcglobal.InvalidAssocTableEntryException invalidAssocTableEntryException;

    public InvalidAssocTableEntryExceptionResponse() {
        super();
    }
    
    public InvalidAssocTableEntryExceptionResponse(String message) {
        super(message);
    }
    
    public InvalidAssocTableEntryExceptionResponse(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidAssocTableEntryExceptionResponse(String message, org.fosstrak.ale.wsdl.alecc.epcglobal.InvalidAssocTableEntryException invalidAssocTableEntryException) {
        super(message);
        this.invalidAssocTableEntryException = invalidAssocTableEntryException;
    }

    public InvalidAssocTableEntryExceptionResponse(String message, org.fosstrak.ale.wsdl.alecc.epcglobal.InvalidAssocTableEntryException invalidAssocTableEntryException, Throwable cause) {
        super(message, cause);
        this.invalidAssocTableEntryException = invalidAssocTableEntryException;
    }

    public org.fosstrak.ale.wsdl.alecc.epcglobal.InvalidAssocTableEntryException getFaultInfo() {
        return this.invalidAssocTableEntryException;
    }
}
