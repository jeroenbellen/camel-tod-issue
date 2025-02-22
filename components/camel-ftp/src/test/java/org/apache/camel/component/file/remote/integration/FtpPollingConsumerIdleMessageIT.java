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
package org.apache.camel.component.file.remote.integration;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test to verify that the polling consumer delivers an empty Exchange when the sendEmptyMessageWhenIdle property is set
 * and a polling event yields no results.
 */
public class FtpPollingConsumerIdleMessageIT extends FtpServerTestSupport {

    @Test
    public void testConsumeIdleMessages() throws Exception {
        Thread.sleep(110);
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMinimumMessageCount(2);
        assertMockEndpointsSatisfied();
        assertNull(mock.getExchanges().get(0).getIn().getBody());
        assertNull(mock.getExchanges().get(1).getIn().getBody());
    }

    @BeforeEach
    public void setup() {
        service.ftpFile("polling").toFile().mkdirs();
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from("ftp://admin@localhost:{{ftp.server.port}}/polling?password=admin&delay=50"
                     + "&sendEmptyMessageWhenIdle=true").to("mock:result");
            }
        };
    }

}
