package com.sahoora.apache.camel.mq;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.direct.DirectEndpoint;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.junit.Test;

public class BlueprintBeanRouteTest extends CamelBlueprintTestSupport {
	
    @Override
    protected String getBlueprintDescriptor() {
        return "/OSGI-INF/blueprint/blueprint-bean.xml";
    }

    @Override
    protected String useOverridePropertiesWithConfigAdmin(Dictionary props) throws Exception {
        // override / add extra properties
        props.put("greeting", "Hello from test");
        props.put("activemq:queue:myActiveMq", "direct:mqtest");

        // return the persistence-id to use
        return "HelloBean";
    }
    
    @Test
    public void testMqMockEndpoint() throws Exception {
        MockEndpoint mockEndpoint = getMockEndpoint("mock:activemq:queue:myActiveMq");
        mockEndpoint.expectedMessageCount(1);

        mockEndpoint.whenAnyExchangeReceived(exchange -> {
            final List<String> params = new ArrayList<>();
            params.add("1234");
            exchange.getIn().setBody(params);
        });

        //send message
        template.request(mockEndpoint, new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {

            }
        });
        assertMockEndpointsSatisfied();
    }
    
    @Test
    public void testCxfRealEndpointRoute() throws Exception {

        DirectEndpoint testEndpoint = context.getEndpoint("direct:mqtest", DirectEndpoint.class);

        Exchange reply = template.request("direct:mqtest", new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                final List<String> params = new ArrayList<>();
                params.add("1234");
                exchange.getIn().setBody(params);
            }
        });

        assertMockEndpointsSatisfied();
    }

}
