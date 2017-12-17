package app.interceptors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;

import javax.xml.transform.Source;

/**
 * This is just a demo of what an endpoint interceptor looks like.
 * Logging incoming message can be done via setting application.properties
 *   +logging.level.org.springframework.ws.client.MessageTracing.received=TRACE
     +logging.level.org.springframework.ws.server.MessageTracing.received=TRACE
 */
@Component
public class EndpointLoggingInterceptor implements EndpointInterceptor {

    @Override
    public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
        Source payloadSource = messageContext.getRequest().getPayloadSource();
        LOG.info("Receiving request." + payloadSource);
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
        return false;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) throws Exception {

    }
    private static final Log LOG = LogFactory.getLog(EndpointLoggingInterceptor.class);

}
