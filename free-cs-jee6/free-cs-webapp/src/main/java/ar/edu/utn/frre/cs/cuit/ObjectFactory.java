
package ar.edu.utn.frre.cs.cuit;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ar.edu.utn.frre.cs.cuit package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ValidarCuit_QNAME = new QName("http://cuit.cs.frre.utn.edu.ar/", "validarCuit");
    private final static QName _ValidarCuitResponse_QNAME = new QName("http://cuit.cs.frre.utn.edu.ar/", "validarCuitResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ar.edu.utn.frre.cs.cuit
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidarCuit }
     * 
     */
    public ValidarCuit createValidarCuit() {
        return new ValidarCuit();
    }

    /**
     * Create an instance of {@link ValidarCuitResponse }
     * 
     */
    public ValidarCuitResponse createValidarCuitResponse() {
        return new ValidarCuitResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidarCuit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cuit.cs.frre.utn.edu.ar/", name = "validarCuit")
    public JAXBElement<ValidarCuit> createValidarCuit(ValidarCuit value) {
        return new JAXBElement<ValidarCuit>(_ValidarCuit_QNAME, ValidarCuit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidarCuitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cuit.cs.frre.utn.edu.ar/", name = "validarCuitResponse")
    public JAXBElement<ValidarCuitResponse> createValidarCuitResponse(ValidarCuitResponse value) {
        return new JAXBElement<ValidarCuitResponse>(_ValidarCuitResponse_QNAME, ValidarCuitResponse.class, null, value);
    }

}
