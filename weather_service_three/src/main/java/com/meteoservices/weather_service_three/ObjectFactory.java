
package com.meteoservices.weather_service_three;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.meteoservices.weather_service_three package. 
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

    private final static QName _GetWeatherRequest_QNAME = new QName("http://meteoservices.com/weather_service_three", "getWeatherRequest");
    private final static QName _GetWeatherResponse_QNAME = new QName("http://meteoservices.com/weather_service_three", "getWeatherResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.meteoservices.weather_service_three
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Weather }
     * 
     */
    public Weather createWeather() {
        return new Weather();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://meteoservices.com/weather_service_three", name = "getWeatherRequest")
    public JAXBElement<Object> createGetWeatherRequest(Object value) {
        return new JAXBElement<Object>(_GetWeatherRequest_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://meteoservices.com/weather_service_three", name = "getWeatherResponse")
    public JAXBElement<Object> createGetWeatherResponse(Object value) {
        return new JAXBElement<Object>(_GetWeatherResponse_QNAME, Object.class, null, value);
    }

}
