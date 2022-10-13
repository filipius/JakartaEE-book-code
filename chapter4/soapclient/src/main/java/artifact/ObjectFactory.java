
package artifact;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the artifact package. 
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

    private final static QName _Add_QNAME = new QName("http://book/", "add");
    private final static QName _AddResponse_QNAME = new QName("http://book/", "addResponse");
    private final static QName _Subtract_QNAME = new QName("http://book/", "subtract");
    private final static QName _SubtractResponse_QNAME = new QName("http://book/", "subtractResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: artifact
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Add }
     * 
     * @return
     *     the new instance of {@link Add }
     */
    public Add createAdd() {
        return new Add();
    }

    /**
     * Create an instance of {@link AddResponse }
     * 
     * @return
     *     the new instance of {@link AddResponse }
     */
    public AddResponse createAddResponse() {
        return new AddResponse();
    }

    /**
     * Create an instance of {@link Subtract }
     * 
     * @return
     *     the new instance of {@link Subtract }
     */
    public Subtract createSubtract() {
        return new Subtract();
    }

    /**
     * Create an instance of {@link SubtractResponse }
     * 
     * @return
     *     the new instance of {@link SubtractResponse }
     */
    public SubtractResponse createSubtractResponse() {
        return new SubtractResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Add }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Add }{@code >}
     */
    @XmlElementDecl(namespace = "http://book/", name = "add")
    public JAXBElement<Add> createAdd(Add value) {
        return new JAXBElement<>(_Add_QNAME, Add.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://book/", name = "addResponse")
    public JAXBElement<AddResponse> createAddResponse(AddResponse value) {
        return new JAXBElement<>(_AddResponse_QNAME, AddResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Subtract }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Subtract }{@code >}
     */
    @XmlElementDecl(namespace = "http://book/", name = "subtract")
    public JAXBElement<Subtract> createSubtract(Subtract value) {
        return new JAXBElement<>(_Subtract_QNAME, Subtract.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubtractResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SubtractResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://book/", name = "subtractResponse")
    public JAXBElement<SubtractResponse> createSubtractResponse(SubtractResponse value) {
        return new JAXBElement<>(_SubtractResponse_QNAME, SubtractResponse.class, null, value);
    }

}
