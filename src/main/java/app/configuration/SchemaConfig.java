package app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * List all the needed schemas here.
 * This will be used
 *  + {@link MessageDispatcherServlet#initXsdSchemas} : upon initialize, will store all schema references
 *  + {@link MessageDispatcherServlet#getXsdSchema} : upon handle client wsdl discovery request
 */
@Configuration
public class SchemaConfig {
    @Bean
    /**
     * Must match the xsd name, in this case RequestIllustration.
     */
    public XsdSchema RequestIllustration() {
        return new SimpleXsdSchema(new ClassPathResource("schemas/vn/request/1.0/RequestIllustration.xsd"));
    }

    @Bean
    /**
     * Must match the xsd name, in this case RequestIllustration.
     */
    public XsdSchema IllustrationResponse() {
        return new SimpleXsdSchema(new ClassPathResource("schemas/vn/response/1.0/IllustrationResponse.xsd"));
    }
    @Bean
    /**
     * Must match the xsd name, in this case COM_DataTypes.
     */
    public XsdSchema COM_DataTypes() {
        return new SimpleXsdSchema(new ClassPathResource("schemas/common/1.0/COM_DataTypes.xsd"));
    }
    @Bean
    /**
     * Must match the xsd name, in this case COM_DomainCommon.
     */
    public XsdSchema COM_DomainCommon() {
        return new SimpleXsdSchema(new ClassPathResource("schemas/vn/domain/1.0/COM_DomainCommon.xsd"));
    }
}
