/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.jms;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.jupiter.api.Test;

/**
 * Unit test for useOriginalBody unit test
 */
public class JmsOnCompletionTest extends AbstractJMSTest {

    @Test
    public void testSynchronizeComplete() throws Exception {
        getMockEndpoint("mock:sync").expectedBodiesReceived("Bye World");
        getMockEndpoint("mock:sync").expectedPropertyReceived(Exchange.ON_COMPLETION, true);

        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedBodiesReceived("Bye World");

        template.sendBody("activemq:queue:JmsOnCompletionTest.start", "Hello World");

        assertMockEndpointsSatisfied();
    }

    @Test
    public void testSynchronizeFailure() throws Exception {
        getMockEndpoint("mock:sync").expectedMessageCount(1);
        getMockEndpoint("mock:sync").expectedPropertyReceived(Exchange.ON_COMPLETION, true);

        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMessageCount(0);

        template.sendBody("activemq:queue:JmsOnCompletionTest.start", "Kabom");

        assertMockEndpointsSatisfied();
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                // START SNIPPET: e1
                from("activemq:queue:JmsOnCompletionTest.start")
                        .onCompletion()
                        // this route is only invoked when the original route is complete as a kind
                        // of completion callback
                        .to("log:sync")
                        .to("mock:sync")
                        // must use end to denote the end of the onCompletion route
                        .end()
                        // here the original route continues
                        .process(new MyProcessor())
                        .to("mock:result");
                // END SNIPPET: e1
            }
        };
    }

    public static class MyProcessor implements Processor {

        public MyProcessor() {
        }

        @Override
        public void process(Exchange exchange) {
            if ("Kabom".equals(exchange.getIn().getBody())) {
                throw new IllegalArgumentException("Kabom");
            }
            exchange.getIn().setBody("Bye World");
        }
    }

    @Override
    protected String getComponentName() {
        return "activemq";
    }

}
