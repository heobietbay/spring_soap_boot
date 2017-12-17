package app.configuration;

import app.interceptors.EndpointLoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;

import java.util.List;

@Configuration
public class SoapServerConfig extends WsConfigurerAdapter {
    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        super.addInterceptors(interceptors);
        interceptors.add(new EndpointLoggingInterceptor());
    }
}
