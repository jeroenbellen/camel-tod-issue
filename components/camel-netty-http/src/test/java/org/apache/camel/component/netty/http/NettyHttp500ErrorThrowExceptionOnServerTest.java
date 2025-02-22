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
package org.apache.camel.component.netty.http;

import org.apache.camel.CamelExecutionException;
import org.apache.camel.builder.RouteBuilder;
import org.junit.jupiter.api.Test;

import static org.apache.camel.test.junit5.TestSupport.assertIsInstanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class NettyHttp500ErrorThrowExceptionOnServerTest extends BaseNettyTest {

    @Test
    public void testHttp500Error() throws Exception {
        getMockEndpoint("mock:input").expectedBodiesReceived("Hello World");

        try {
            template.requestBody("netty-http:http://localhost:{{port}}/foo", "Hello World", String.class);
            fail("Should have failed");
        } catch (CamelExecutionException e) {
            NettyHttpOperationFailedException cause = assertIsInstanceOf(NettyHttpOperationFailedException.class, e.getCause());
            assertEquals(500, cause.getStatusCode());
            String trace = cause.getContentAsString();
            assertNotNull(trace);
            assertTrue(trace.startsWith("java.lang.IllegalArgumentException: Camel cannot do this"));
            assertEquals("http://localhost:" + getPort() + "/foo", cause.getUri());
        }

        assertMockEndpointsSatisfied();
    }

    @Test
    public void testHttp500ErrorDisabled() throws Exception {
        getMockEndpoint("mock:input").expectedBodiesReceived("Hello World");

        String body = template.requestBody("netty-http:http://localhost:{{port}}/foo?throwExceptionOnFailure=false",
                "Hello World", String.class);
        assertTrue(body.startsWith("java.lang.IllegalArgumentException: Camel cannot do this"));

        assertMockEndpointsSatisfied();
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from("netty-http:http://0.0.0.0:{{port}}/foo")
                        .to("mock:input")
                        .throwException(new IllegalArgumentException("Camel cannot do this"));
            }
        };
    }

}
