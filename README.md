# spring_soap_boot
Implement basic Spring soap service using Spring Boot

## Steps
 1. Define schema xsd file, that has request and response object
 2. Define wsdl, that includes
   + portType
   + binding
   + service
 3. Modify pom.xml to include needed plugin for wsdl code generation  
 4. Generate source my executing mvn install
 5. Coding: define 
    + EndPoint for handling the request
    + List of xsds being used
    + Expose Wsdl11Definition 
 6. Run as a Spring boot application.
 7. Check that under http://localhost:8080/ws/illustration.wsdl
 
