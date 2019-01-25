package org.fosstrak.ale.wsdl.aletm.epcglobal;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.6.1
 * 2019-01-25T13:11:17.223+08:00
 * Generated source version: 2.6.1
 * 
 */
@WebService(targetNamespace = "urn:epcglobal:aletm:wsdl:1", name = "ALETMServicePortType")
@XmlSeeAlso({ObjectFactory.class, org.fosstrak.ale.xsd.epcglobal.ObjectFactory.class, org.fosstrak.ale.xsd.ale.epcglobal.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ALETMServicePortType {

    @WebMethod
    @WebResult(name = "DefineTMSpecResult", targetNamespace = "urn:epcglobal:aletm:wsdl:1", partName = "defineTMSpecReturn")
    public DefineTMSpecResult defineTMSpec(
        @WebParam(partName = "parms", name = "DefineTMSpec", targetNamespace = "urn:epcglobal:aletm:wsdl:1")
        DefineTMSpec parms
    ) throws DuplicateNameExceptionResponse, SecurityExceptionResponse, ImplementationExceptionResponse, TMSpecValidationExceptionResponse;

    @WebMethod
    @WebResult(name = "GetTMSpecNamesResult", targetNamespace = "urn:epcglobal:aletm:wsdl:1", partName = "getTMSpecNamesReturn")
    public ArrayOfString getTMSpecNames(
        @WebParam(partName = "parms", name = "GetTMSpecNames", targetNamespace = "urn:epcglobal:aletm:wsdl:1")
        EmptyParms parms
    ) throws SecurityExceptionResponse, ImplementationExceptionResponse;

    @WebMethod
    @WebResult(name = "UndefineTMSpecResult", targetNamespace = "urn:epcglobal:aletm:wsdl:1", partName = "undefineTMSpecReturn")
    public UndefineTMSpecResult undefineTMSpec(
        @WebParam(partName = "parms", name = "UndefineTMSpec", targetNamespace = "urn:epcglobal:aletm:wsdl:1")
        UndefineTMSpec parms
    ) throws SecurityExceptionResponse, ImplementationExceptionResponse, NoSuchNameExceptionResponse;

    @WebMethod
    @WebResult(name = "GetTMSpecResult", targetNamespace = "urn:epcglobal:aletm:wsdl:1", partName = "getTMSpecReturn")
    public org.fosstrak.ale.xsd.ale.epcglobal.TMSpec getTMSpec(
        @WebParam(partName = "parms", name = "GetTMSpec", targetNamespace = "urn:epcglobal:aletm:wsdl:1")
        GetTMSpec parms
    ) throws SecurityExceptionResponse, ImplementationExceptionResponse, NoSuchNameExceptionResponse;

    @WebMethod
    @WebResult(name = "GetStandardVersionResult", targetNamespace = "urn:epcglobal:aletm:wsdl:1", partName = "getStandardVersionReturn")
    public java.lang.String getStandardVersion(
        @WebParam(partName = "parms", name = "GetStandardVersion", targetNamespace = "urn:epcglobal:aletm:wsdl:1")
        EmptyParms parms
    ) throws ImplementationExceptionResponse;

    @WebMethod
    @WebResult(name = "GetVendorVersionResult", targetNamespace = "urn:epcglobal:aletm:wsdl:1", partName = "getVendorVersionReturn")
    public java.lang.String getVendorVersion(
        @WebParam(partName = "parms", name = "GetVendorVersion", targetNamespace = "urn:epcglobal:aletm:wsdl:1")
        EmptyParms parms
    ) throws ImplementationExceptionResponse;
}