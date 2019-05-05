
package org.fosstrak.ale.wsdl.alecc.epcglobal;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.1
 * 2019-04-10T16:21:23.304+08:00
 * Generated source version: 2.6.1
 */

@WebFault(name = "InvalidPatternException", targetNamespace = "urn:epcglobal:alecc:wsdl:1")
public class InvalidPatternExceptionResponse extends Exception {
    
    private org.fosstrak.ale.wsdl.alecc.epcglobal.InvalidPatternException invalidPatternException;

    public InvalidPatternExceptionResponse() {
        super();
    }
    
    public InvalidPatternExceptionResponse(String message) {
        super(message);
    }
    
    public InvalidPatternExceptionResponse(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPatternExceptionResponse(String message, org.fosstrak.ale.wsdl.alecc.epcglobal.InvalidPatternException invalidPatternException) {
        super(message);
        this.invalidPatternException = invalidPatternException;
    }

    public InvalidPatternExceptionResponse(String message, org.fosstrak.ale.wsdl.alecc.epcglobal.InvalidPatternException invalidPatternException, Throwable cause) {
        super(message, cause);
        this.invalidPatternException = invalidPatternException;
    }

    public org.fosstrak.ale.wsdl.alecc.epcglobal.InvalidPatternException getFaultInfo() {
        return this.invalidPatternException;
    }
}
