package app;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.XsdSchemaCollection;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }
    @Bean(name = "illustration")
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
    /*
    @Bean
    public XsdSchemaCollection schema() {
        CommonsXsdSchemaCollection xsds = new CommonsXsdSchemaCollection(new ClassPathResource("schemas/schema.xsd"));
        xsds.setUriResolver(new DefaultURIResolver()); // so client can retrieve your freaking imported schemas :D
        xsds.setInline(true); // so client can retrieve your freaking imported schemas :D
        return xsds;
    }
    */
}