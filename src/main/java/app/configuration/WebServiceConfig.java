package app.configuration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;

@EnableWs
@Configuration
@Import({SchemaConfig.class,SoapServerConfig.class})
public class WebServiceConfig extends WsConfigurerAdapter {
    /**
     * Need to configure all the needed schema, so that when client discovers wsdl
     * they can get the needed schema.
     * Could be done in a separate config file. See {@link SchemaConfig}
     * @param applicationContext
     * @return
     */
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    /**
     * This will result in wsdl exposed in an address like this
     * http://localhost:8080/ws/illustration.wsdl
     * @return
     */
    @Bean(name = "illustration")
    public Wsdl11Definition defaultWsdl11Definition() {
        SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
        wsdl11Definition.setWsdl(new ClassPathResource("RequestIllustration.wsdl"));
        return wsdl11Definition;
    }

    /**
     * Support SOAP version 1.2
     * Which require the SOAP ENVELOPE
     *   + Namespace: http://www.w3.org/2003/05/soap-envelope
     *   + Content-Type: application/soap+xml
     * @return
     */
    @Bean
    public SaajSoapMessageFactory messageFactory() {
        SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
        messageFactory.setSoapVersion(SoapVersion.SOAP_12);
        return messageFactory;
    }
    /*
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchemaCollection schema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("RequestIllustrationPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setSchemaCollection(schema);
        wsdl11Definition.setTargetNamespace("http://www.khoatrandang.learn/demo/vn/request/1.0");
        wsdl11Definition.setCreateSoap12Binding(true);
        wsdl11Definition.setCreateSoap11Binding(false);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchemaCollection schema() {
        CommonsXsdSchemaCollection xsds = new CommonsXsdSchemaCollection(new ClassPathResource("schemas/schema.xsd"));
        xsds.setUriResolver(new DefaultURIResolver()); // so client can retrieve your freaking imported schemas :D
        xsds.setInline(true); // so client can retrieve your freaking imported schemas :D
        return xsds;
    }
    */

}