
package https.github_com.tracee.tracee.examples.jaxws.service.wsdl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CalculationService", targetNamespace = "https://github.com/tracee/tracee/examples/jaxws/service/wsdl", wsdlLocation = "file:/Users/tobiasstamann/Projects/Tracee/tracee-microservices-demo/spring-boot/spring-boot-jaxws/src/main/resources/calculation.wsdl")
public class CalculationService
    extends Service
{

    private final static URL CALCULATIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException CALCULATIONSERVICE_EXCEPTION;
    private final static QName CALCULATIONSERVICE_QNAME = new QName("https://github.com/tracee/tracee/examples/jaxws/service/wsdl", "CalculationService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/Users/tobiasstamann/Projects/Tracee/tracee-microservices-demo/spring-boot/spring-boot-jaxws/src/main/resources/calculation.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CALCULATIONSERVICE_WSDL_LOCATION = url;
        CALCULATIONSERVICE_EXCEPTION = e;
    }

    public CalculationService() {
        super(__getWsdlLocation(), CALCULATIONSERVICE_QNAME);
    }

    public CalculationService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CALCULATIONSERVICE_QNAME, features);
    }

    public CalculationService(URL wsdlLocation) {
        super(wsdlLocation, CALCULATIONSERVICE_QNAME);
    }

    public CalculationService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CALCULATIONSERVICE_QNAME, features);
    }

    public CalculationService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CalculationService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CalculationWS
     */
    @WebEndpoint(name = "CalculationServicePort")
    public CalculationWS getCalculationServicePort() {
        return super.getPort(new QName("https://github.com/tracee/tracee/examples/jaxws/service/wsdl", "CalculationServicePort"), CalculationWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CalculationWS
     */
    @WebEndpoint(name = "CalculationServicePort")
    public CalculationWS getCalculationServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("https://github.com/tracee/tracee/examples/jaxws/service/wsdl", "CalculationServicePort"), CalculationWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CALCULATIONSERVICE_EXCEPTION!= null) {
            throw CALCULATIONSERVICE_EXCEPTION;
        }
        return CALCULATIONSERVICE_WSDL_LOCATION;
    }

}
