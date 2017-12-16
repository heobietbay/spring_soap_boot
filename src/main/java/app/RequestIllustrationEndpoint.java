package app;

import learn.khoatrandang.demo.vn.request._1.RequestIllustrationType;
import learn.khoatrandang.demo.vn.response._1.IllustrationDataResponse;
import learn.khoatrandang.demo.vn.response._1.IllustrationResponseType;
import learn.khoatrandang.demo.vn.response._1.MemberDetails;
import learn.khoatrandang.demo.vn.response._1.ObjectFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBElement;

@Endpoint
public class RequestIllustrationEndpoint {
    // must be the same namespace of the RequestIllustrationType
    private static final String NAMESPACE_URI = "http://www.khoatrandang.learn/demo/vn/request/1.0";
    private ObjectFactory responseObjectFactory = new ObjectFactory();

    /**
     * Handle JAXBElement<RequestIllustrationType>, wrap it inside a JAXBElement because
     * RequestIllustrationType is defined as a complex type in xsd, and it is without root element.
     * Same thing goes for the response.
     * @param request request
     * @return JAXBElement that wrap a IllustrationResponseType.
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RequestIllustration")
    @ResponsePayload
    public JAXBElement<IllustrationResponseType> requestIllustration(@RequestPayload JAXBElement<RequestIllustrationType> request) {
        IllustrationResponseType response = new IllustrationResponseType();
        IllustrationDataResponse illustrationDataResponse = new IllustrationDataResponse();
        illustrationDataResponse.setAssumedMaxLta(10.0);
        MemberDetails memberDetails = new MemberDetails();
        memberDetails.setHealthStatus("OK");
        memberDetails.setPercentQualifyingAssets(100);
        illustrationDataResponse.setMemberDetails(memberDetails);
        response.setIllustrationDataResponse(illustrationDataResponse);
        return responseObjectFactory.createIllustrationResponse(response);
    }
}
