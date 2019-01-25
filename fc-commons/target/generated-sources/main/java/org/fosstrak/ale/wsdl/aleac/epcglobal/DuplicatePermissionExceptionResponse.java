
package org.fosstrak.ale.wsdl.aleac.epcglobal;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.1
 * 2019-01-25T13:11:15.246+08:00
 * Generated source version: 2.6.1
 */

@WebFault(name = "DuplicatePermissionException", targetNamespace = "urn:epcglobal:aleac:wsdl:1")
public class DuplicatePermissionExceptionResponse extends Exception {
    
    private org.fosstrak.ale.wsdl.aleac.epcglobal.DuplicatePermissionException duplicatePermissionException;

    public DuplicatePermissionExceptionResponse() {
        super();
    }
    
    public DuplicatePermissionExceptionResponse(String message) {
        super(message);
    }
    
    public DuplicatePermissionExceptionResponse(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicatePermissionExceptionResponse(String message, org.fosstrak.ale.wsdl.aleac.epcglobal.DuplicatePermissionException duplicatePermissionException) {
        super(message);
        this.duplicatePermissionException = duplicatePermissionException;
    }

    public DuplicatePermissionExceptionResponse(String message, org.fosstrak.ale.wsdl.aleac.epcglobal.DuplicatePermissionException duplicatePermissionException, Throwable cause) {
        super(message, cause);
        this.duplicatePermissionException = duplicatePermissionException;
    }

    public org.fosstrak.ale.wsdl.aleac.epcglobal.DuplicatePermissionException getFaultInfo() {
        return this.duplicatePermissionException;
    }
}
