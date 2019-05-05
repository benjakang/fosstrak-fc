
package org.fosstrak.ale.wsdl.aleac.epcglobal;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.1
 * 2019-04-10T16:21:22.888+08:00
 * Generated source version: 2.6.1
 */

@WebFault(name = "DuplicateRoleException", targetNamespace = "urn:epcglobal:aleac:wsdl:1")
public class DuplicateRoleExceptionResponse extends Exception {
    
    private org.fosstrak.ale.wsdl.aleac.epcglobal.DuplicateRoleException duplicateRoleException;

    public DuplicateRoleExceptionResponse() {
        super();
    }
    
    public DuplicateRoleExceptionResponse(String message) {
        super(message);
    }
    
    public DuplicateRoleExceptionResponse(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateRoleExceptionResponse(String message, org.fosstrak.ale.wsdl.aleac.epcglobal.DuplicateRoleException duplicateRoleException) {
        super(message);
        this.duplicateRoleException = duplicateRoleException;
    }

    public DuplicateRoleExceptionResponse(String message, org.fosstrak.ale.wsdl.aleac.epcglobal.DuplicateRoleException duplicateRoleException, Throwable cause) {
        super(message, cause);
        this.duplicateRoleException = duplicateRoleException;
    }

    public org.fosstrak.ale.wsdl.aleac.epcglobal.DuplicateRoleException getFaultInfo() {
        return this.duplicateRoleException;
    }
}
