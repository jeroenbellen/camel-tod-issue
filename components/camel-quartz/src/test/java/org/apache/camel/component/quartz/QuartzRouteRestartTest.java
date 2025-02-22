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
package org.apache.camel.component.quartz;

import java.util.concurrent.TimeUnit;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;

public class QuartzRouteRestartTest extends BaseQuartzTest {

    @Test
    public void testQuartzCronRoute() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMinimumMessageCount(2);

        assertMockEndpointsSatisfied();

        // restart route
        context().getRouteController().stopRoute("trigger");
        mock.reset();
        mock.expectedMessageCount(0);

        // wait a bit
        Awaitility.await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(() -> assertMockEndpointsSatisfied());

        // start route, and we got messages again
        mock.reset();
        mock.expectedMinimumMessageCount(1);

        context().getRouteController().startRoute("trigger");

        assertMockEndpointsSatisfied();
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            public void configure() {
                from("quartz://groupName/timerName?cron=0/1+*+*+*+*+?").routeId("trigger")
                        .to("mock:result");
            }
        };
    }

}
