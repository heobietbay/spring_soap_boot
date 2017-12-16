package app;

import com.infocomp.cbis.uk.request._1.RequestIllustrationType;
import com.infocomp.cbis.uk.response._1.IllustrationResponseType;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class RequestIllustrationEndpoint {
    private static final String NAMESPACE_URI = "http://www.khoatrandang.learn/demo/vn/request/1.0";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RequestIllustration")
    @ResponsePayload
    public IllustrationResponseType requestIllustration(@RequestPayload RequestIllustrationType request) {
        IllustrationResponseType response = new IllustrationResponseType();
        return response;
    }
}
