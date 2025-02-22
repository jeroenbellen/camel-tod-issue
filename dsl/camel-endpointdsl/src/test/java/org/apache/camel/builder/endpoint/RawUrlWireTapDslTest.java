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
package org.apache.camel.builder.endpoint;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.jupiter.api.Test;

//Covers both WireTapReifier and ToDynamicReifier
public class RawUrlWireTapDslTest extends BaseEndpointDslTest {

    @Test
    public void testFlow() throws Exception {
        MockEndpoint m1 = getMockEndpoint("mock:m1");
        m1.expectedMessageCount(1);

        MockEndpoint m2 = getMockEndpoint("mock:m2");
        m2.expectedMessageCount(1);

        MockEndpoint m3 = getMockEndpoint("mock:m3");
        m3.expectedMessageCount(1);

        template.requestBodyAndHeader("direct:a", "Hello World", "size", 1, String.class);

        assertMockEndpointsSatisfied();
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new EndpointRouteBuilder() {
            public void configure() {
                from(direct("a"))
                        .recipientList(endpoints(mock("m1"), direct("b")))
                        .routingSlip(endpoints(mock("m2"), direct("c")))
                        .wireTap(seda("d").size("${header.size}")).dynamicUri(true)
                        .enrich(direct("e"))
                        .toD(mock("${header.next}"));

                from(direct("b")).to(log("endpoint.b"));
                from(direct("c")).to(log("endpoint.c"));
                from(seda("d?size=1")).to(log("endpoint.d"));
                from(direct("e"))
                        .setBody(constant("body"))
                        .setHeader("next", constant("m3"));

            }
        };
    }

}
