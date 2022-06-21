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
package org.apache.camel.builder.endpoint.dsl;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import javax.annotation.Generated;
import org.apache.camel.builder.EndpointConsumerBuilder;
import org.apache.camel.builder.EndpointProducerBuilder;
import org.apache.camel.builder.endpoint.AbstractEndpointBuilder;

/**
 * Interact with JIRA issue tracker.
 * 
 * Generated by camel build tools - do NOT edit this file!
 */
@Generated("org.apache.camel.maven.packaging.EndpointDslMojo")
public interface JiraEndpointBuilderFactory {


    /**
     * Builder for endpoint consumers for the Jira component.
     */
    public interface JiraEndpointConsumerBuilder
            extends
                EndpointConsumerBuilder {
        default AdvancedJiraEndpointConsumerBuilder advanced() {
            return (AdvancedJiraEndpointConsumerBuilder) this;
        }
        /**
         * Time in milliseconds to elapse for the next poll.
         * 
         * The option is a: &lt;code&gt;java.lang.Integer&lt;/code&gt; type.
         * 
         * Default: 6000
         * Group: common
         * 
         * @param delay the value to set
         * @return the dsl builder
         */
        default JiraEndpointConsumerBuilder delay(Integer delay) {
            doSetProperty("delay", delay);
            return this;
        }
        /**
         * Time in milliseconds to elapse for the next poll.
         * 
         * The option will be converted to a
         * &lt;code&gt;java.lang.Integer&lt;/code&gt; type.
         * 
         * Default: 6000
         * Group: common
         * 
         * @param delay the value to set
         * @return the dsl builder
         */
        default JiraEndpointConsumerBuilder delay(String delay) {
            doSetProperty("delay", delay);
            return this;
        }
        /**
         * The Jira server url, example: http://my_jira.com:8081.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Required: true
         * Group: common
         * 
         * @param jiraUrl the value to set
         * @return the dsl builder
         */
        default JiraEndpointConsumerBuilder jiraUrl(String jiraUrl) {
            doSetProperty("jiraUrl", jiraUrl);
            return this;
        }
        /**
         * JQL is the query language from JIRA which allows you to retrieve the
         * data you want. For example jql=project=MyProject Where MyProject is
         * the product key in Jira. It is important to use the RAW() and set the
         * JQL inside it to prevent camel parsing it, example: RAW(project in
         * (MYP, COM) AND resolution = Unresolved).
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: consumer
         * 
         * @param jql the value to set
         * @return the dsl builder
         */
        default JiraEndpointConsumerBuilder jql(String jql) {
            doSetProperty("jql", jql);
            return this;
        }
        /**
         * Max number of issues to search for.
         * 
         * The option is a: &lt;code&gt;java.lang.Integer&lt;/code&gt; type.
         * 
         * Default: 50
         * Group: consumer
         * 
         * @param maxResults the value to set
         * @return the dsl builder
         */
        default JiraEndpointConsumerBuilder maxResults(Integer maxResults) {
            doSetProperty("maxResults", maxResults);
            return this;
        }
        /**
         * Max number of issues to search for.
         * 
         * The option will be converted to a
         * &lt;code&gt;java.lang.Integer&lt;/code&gt; type.
         * 
         * Default: 50
         * Group: consumer
         * 
         * @param maxResults the value to set
         * @return the dsl builder
         */
        default JiraEndpointConsumerBuilder maxResults(String maxResults) {
            doSetProperty("maxResults", maxResults);
            return this;
        }
        /**
         * Indicator for sending only changed fields in exchange body or issue
         * object. By default consumer sends only changed fields.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: true
         * Group: consumer
         * 
         * @param sendOnlyUpdatedField the value to set
         * @return the dsl builder
         */
        default JiraEndpointConsumerBuilder sendOnlyUpdatedField(
                boolean sendOnlyUpdatedField) {
            doSetProperty("sendOnlyUpdatedField", sendOnlyUpdatedField);
            return this;
        }
        /**
         * Indicator for sending only changed fields in exchange body or issue
         * object. By default consumer sends only changed fields.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: true
         * Group: consumer
         * 
         * @param sendOnlyUpdatedField the value to set
         * @return the dsl builder
         */
        default JiraEndpointConsumerBuilder sendOnlyUpdatedField(
                String sendOnlyUpdatedField) {
            doSetProperty("sendOnlyUpdatedField", sendOnlyUpdatedField);
            return this;
        }
        /**
         * Comma separated list of fields to watch for changes. Status,Priority
         * are the defaults.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Default: Status,Priority
         * Group: consumer
         * 
         * @param watchedFields the value to set
         * @return the dsl builder
         */
        default JiraEndpointConsumerBuilder watchedFields(String watchedFields) {
            doSetProperty("watchedFields", watchedFields);
            return this;
        }
        /**
         * (OAuth or Personal Access Token authentication) The access token
         * generated by the Jira server.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param accessToken the value to set
         * @return the dsl builder
         */
        default JiraEndpointConsumerBuilder accessToken(String accessToken) {
            doSetProperty("accessToken", accessToken);
            return this;
        }
        /**
         * (OAuth only) The consumer key from Jira settings.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param consumerKey the value to set
         * @return the dsl builder
         */
        default JiraEndpointConsumerBuilder consumerKey(String consumerKey) {
            doSetProperty("consumerKey", consumerKey);
            return this;
        }
        /**
         * (Basic authentication only) The password or the API Token to
         * authenticate to the Jira server. Use only if username basic
         * authentication is used.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param password the value to set
         * @return the dsl builder
         */
        default JiraEndpointConsumerBuilder password(String password) {
            doSetProperty("password", password);
            return this;
        }
        /**
         * (OAuth only) The private key generated by the client to encrypt the
         * conversation to the server.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param privateKey the value to set
         * @return the dsl builder
         */
        default JiraEndpointConsumerBuilder privateKey(String privateKey) {
            doSetProperty("privateKey", privateKey);
            return this;
        }
        /**
         * (Basic authentication only) The username to authenticate to the Jira
         * server. Use only if OAuth is not enabled on the Jira server. Do not
         * set the username and OAuth token parameter, if they are both set, the
         * username basic authentication takes precedence.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param username the value to set
         * @return the dsl builder
         */
        default JiraEndpointConsumerBuilder username(String username) {
            doSetProperty("username", username);
            return this;
        }
        /**
         * (OAuth only) The verification code from Jira generated in the first
         * step of the authorization proccess.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param verificationCode the value to set
         * @return the dsl builder
         */
        default JiraEndpointConsumerBuilder verificationCode(
                String verificationCode) {
            doSetProperty("verificationCode", verificationCode);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint consumers for the Jira component.
     */
    public interface AdvancedJiraEndpointConsumerBuilder
            extends
                EndpointConsumerBuilder {
        default JiraEndpointConsumerBuilder basic() {
            return (JiraEndpointConsumerBuilder) this;
        }
        /**
         * Allows for bridging the consumer to the Camel routing Error Handler,
         * which mean any exceptions occurred while the consumer is trying to
         * pickup incoming messages, or the likes, will now be processed as a
         * message and handled by the routing Error Handler. By default the
         * consumer will use the org.apache.camel.spi.ExceptionHandler to deal
         * with exceptions, that will be logged at WARN or ERROR level and
         * ignored.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: consumer (advanced)
         * 
         * @param bridgeErrorHandler the value to set
         * @return the dsl builder
         */
        default AdvancedJiraEndpointConsumerBuilder bridgeErrorHandler(
                boolean bridgeErrorHandler) {
            doSetProperty("bridgeErrorHandler", bridgeErrorHandler);
            return this;
        }
        /**
         * Allows for bridging the consumer to the Camel routing Error Handler,
         * which mean any exceptions occurred while the consumer is trying to
         * pickup incoming messages, or the likes, will now be processed as a
         * message and handled by the routing Error Handler. By default the
         * consumer will use the org.apache.camel.spi.ExceptionHandler to deal
         * with exceptions, that will be logged at WARN or ERROR level and
         * ignored.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: false
         * Group: consumer (advanced)
         * 
         * @param bridgeErrorHandler the value to set
         * @return the dsl builder
         */
        default AdvancedJiraEndpointConsumerBuilder bridgeErrorHandler(
                String bridgeErrorHandler) {
            doSetProperty("bridgeErrorHandler", bridgeErrorHandler);
            return this;
        }
        /**
         * To let the consumer use a custom ExceptionHandler. Notice if the
         * option bridgeErrorHandler is enabled then this option is not in use.
         * By default the consumer will deal with exceptions, that will be
         * logged at WARN or ERROR level and ignored.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.spi.ExceptionHandler&lt;/code&gt; type.
         * 
         * Group: consumer (advanced)
         * 
         * @param exceptionHandler the value to set
         * @return the dsl builder
         */
        default AdvancedJiraEndpointConsumerBuilder exceptionHandler(
                org.apache.camel.spi.ExceptionHandler exceptionHandler) {
            doSetProperty("exceptionHandler", exceptionHandler);
            return this;
        }
        /**
         * To let the consumer use a custom ExceptionHandler. Notice if the
         * option bridgeErrorHandler is enabled then this option is not in use.
         * By default the consumer will deal with exceptions, that will be
         * logged at WARN or ERROR level and ignored.
         * 
         * The option will be converted to a
         * &lt;code&gt;org.apache.camel.spi.ExceptionHandler&lt;/code&gt; type.
         * 
         * Group: consumer (advanced)
         * 
         * @param exceptionHandler the value to set
         * @return the dsl builder
         */
        default AdvancedJiraEndpointConsumerBuilder exceptionHandler(
                String exceptionHandler) {
            doSetProperty("exceptionHandler", exceptionHandler);
            return this;
        }
        /**
         * Sets the exchange pattern when the consumer creates an exchange.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.ExchangePattern&lt;/code&gt; type.
         * 
         * Group: consumer (advanced)
         * 
         * @param exchangePattern the value to set
         * @return the dsl builder
         */
        default AdvancedJiraEndpointConsumerBuilder exchangePattern(
                org.apache.camel.ExchangePattern exchangePattern) {
            doSetProperty("exchangePattern", exchangePattern);
            return this;
        }
        /**
         * Sets the exchange pattern when the consumer creates an exchange.
         * 
         * The option will be converted to a
         * &lt;code&gt;org.apache.camel.ExchangePattern&lt;/code&gt; type.
         * 
         * Group: consumer (advanced)
         * 
         * @param exchangePattern the value to set
         * @return the dsl builder
         */
        default AdvancedJiraEndpointConsumerBuilder exchangePattern(
                String exchangePattern) {
            doSetProperty("exchangePattern", exchangePattern);
            return this;
        }
    }

    /**
     * Builder for endpoint producers for the Jira component.
     */
    public interface JiraEndpointProducerBuilder
            extends
                EndpointProducerBuilder {
        default AdvancedJiraEndpointProducerBuilder advanced() {
            return (AdvancedJiraEndpointProducerBuilder) this;
        }
        /**
         * Time in milliseconds to elapse for the next poll.
         * 
         * The option is a: &lt;code&gt;java.lang.Integer&lt;/code&gt; type.
         * 
         * Default: 6000
         * Group: common
         * 
         * @param delay the value to set
         * @return the dsl builder
         */
        default JiraEndpointProducerBuilder delay(Integer delay) {
            doSetProperty("delay", delay);
            return this;
        }
        /**
         * Time in milliseconds to elapse for the next poll.
         * 
         * The option will be converted to a
         * &lt;code&gt;java.lang.Integer&lt;/code&gt; type.
         * 
         * Default: 6000
         * Group: common
         * 
         * @param delay the value to set
         * @return the dsl builder
         */
        default JiraEndpointProducerBuilder delay(String delay) {
            doSetProperty("delay", delay);
            return this;
        }
        /**
         * The Jira server url, example: http://my_jira.com:8081.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Required: true
         * Group: common
         * 
         * @param jiraUrl the value to set
         * @return the dsl builder
         */
        default JiraEndpointProducerBuilder jiraUrl(String jiraUrl) {
            doSetProperty("jiraUrl", jiraUrl);
            return this;
        }
        /**
         * (OAuth or Personal Access Token authentication) The access token
         * generated by the Jira server.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param accessToken the value to set
         * @return the dsl builder
         */
        default JiraEndpointProducerBuilder accessToken(String accessToken) {
            doSetProperty("accessToken", accessToken);
            return this;
        }
        /**
         * (OAuth only) The consumer key from Jira settings.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param consumerKey the value to set
         * @return the dsl builder
         */
        default JiraEndpointProducerBuilder consumerKey(String consumerKey) {
            doSetProperty("consumerKey", consumerKey);
            return this;
        }
        /**
         * (Basic authentication only) The password or the API Token to
         * authenticate to the Jira server. Use only if username basic
         * authentication is used.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param password the value to set
         * @return the dsl builder
         */
        default JiraEndpointProducerBuilder password(String password) {
            doSetProperty("password", password);
            return this;
        }
        /**
         * (OAuth only) The private key generated by the client to encrypt the
         * conversation to the server.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param privateKey the value to set
         * @return the dsl builder
         */
        default JiraEndpointProducerBuilder privateKey(String privateKey) {
            doSetProperty("privateKey", privateKey);
            return this;
        }
        /**
         * (Basic authentication only) The username to authenticate to the Jira
         * server. Use only if OAuth is not enabled on the Jira server. Do not
         * set the username and OAuth token parameter, if they are both set, the
         * username basic authentication takes precedence.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param username the value to set
         * @return the dsl builder
         */
        default JiraEndpointProducerBuilder username(String username) {
            doSetProperty("username", username);
            return this;
        }
        /**
         * (OAuth only) The verification code from Jira generated in the first
         * step of the authorization proccess.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param verificationCode the value to set
         * @return the dsl builder
         */
        default JiraEndpointProducerBuilder verificationCode(
                String verificationCode) {
            doSetProperty("verificationCode", verificationCode);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint producers for the Jira component.
     */
    public interface AdvancedJiraEndpointProducerBuilder
            extends
                EndpointProducerBuilder {
        default JiraEndpointProducerBuilder basic() {
            return (JiraEndpointProducerBuilder) this;
        }
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: producer (advanced)
         * 
         * @param lazyStartProducer the value to set
         * @return the dsl builder
         */
        default AdvancedJiraEndpointProducerBuilder lazyStartProducer(
                boolean lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: false
         * Group: producer (advanced)
         * 
         * @param lazyStartProducer the value to set
         * @return the dsl builder
         */
        default AdvancedJiraEndpointProducerBuilder lazyStartProducer(
                String lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
    }

    /**
     * Builder for endpoint for the Jira component.
     */
    public interface JiraEndpointBuilder
            extends
                JiraEndpointConsumerBuilder,
                JiraEndpointProducerBuilder {
        default AdvancedJiraEndpointBuilder advanced() {
            return (AdvancedJiraEndpointBuilder) this;
        }
        /**
         * Time in milliseconds to elapse for the next poll.
         * 
         * The option is a: &lt;code&gt;java.lang.Integer&lt;/code&gt; type.
         * 
         * Default: 6000
         * Group: common
         * 
         * @param delay the value to set
         * @return the dsl builder
         */
        default JiraEndpointBuilder delay(Integer delay) {
            doSetProperty("delay", delay);
            return this;
        }
        /**
         * Time in milliseconds to elapse for the next poll.
         * 
         * The option will be converted to a
         * &lt;code&gt;java.lang.Integer&lt;/code&gt; type.
         * 
         * Default: 6000
         * Group: common
         * 
         * @param delay the value to set
         * @return the dsl builder
         */
        default JiraEndpointBuilder delay(String delay) {
            doSetProperty("delay", delay);
            return this;
        }
        /**
         * The Jira server url, example: http://my_jira.com:8081.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Required: true
         * Group: common
         * 
         * @param jiraUrl the value to set
         * @return the dsl builder
         */
        default JiraEndpointBuilder jiraUrl(String jiraUrl) {
            doSetProperty("jiraUrl", jiraUrl);
            return this;
        }
        /**
         * (OAuth or Personal Access Token authentication) The access token
         * generated by the Jira server.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param accessToken the value to set
         * @return the dsl builder
         */
        default JiraEndpointBuilder accessToken(String accessToken) {
            doSetProperty("accessToken", accessToken);
            return this;
        }
        /**
         * (OAuth only) The consumer key from Jira settings.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param consumerKey the value to set
         * @return the dsl builder
         */
        default JiraEndpointBuilder consumerKey(String consumerKey) {
            doSetProperty("consumerKey", consumerKey);
            return this;
        }
        /**
         * (Basic authentication only) The password or the API Token to
         * authenticate to the Jira server. Use only if username basic
         * authentication is used.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param password the value to set
         * @return the dsl builder
         */
        default JiraEndpointBuilder password(String password) {
            doSetProperty("password", password);
            return this;
        }
        /**
         * (OAuth only) The private key generated by the client to encrypt the
         * conversation to the server.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param privateKey the value to set
         * @return the dsl builder
         */
        default JiraEndpointBuilder privateKey(String privateKey) {
            doSetProperty("privateKey", privateKey);
            return this;
        }
        /**
         * (Basic authentication only) The username to authenticate to the Jira
         * server. Use only if OAuth is not enabled on the Jira server. Do not
         * set the username and OAuth token parameter, if they are both set, the
         * username basic authentication takes precedence.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param username the value to set
         * @return the dsl builder
         */
        default JiraEndpointBuilder username(String username) {
            doSetProperty("username", username);
            return this;
        }
        /**
         * (OAuth only) The verification code from Jira generated in the first
         * step of the authorization proccess.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param verificationCode the value to set
         * @return the dsl builder
         */
        default JiraEndpointBuilder verificationCode(String verificationCode) {
            doSetProperty("verificationCode", verificationCode);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint for the Jira component.
     */
    public interface AdvancedJiraEndpointBuilder
            extends
                AdvancedJiraEndpointConsumerBuilder,
                AdvancedJiraEndpointProducerBuilder {
        default JiraEndpointBuilder basic() {
            return (JiraEndpointBuilder) this;
        }
    }

    public interface JiraBuilders {
        /**
         * Jira (camel-jira)
         * Interact with JIRA issue tracker.
         * 
         * Category: api,reporting
         * Since: 3.0
         * Maven coordinates: org.apache.camel:camel-jira
         * 
         * Syntax: <code>jira:type</code>
         * 
         * Path parameter: type (required)
         * Operation to perform. Consumers: NewIssues, NewComments. Producers:
         * AddIssue, AttachFile, DeleteIssue, TransitionIssue, UpdateIssue,
         * Watchers. See this class javadoc description for more information.
         * There are 14 enums and the value can be one of: ADDCOMMENT, ADDISSUE,
         * ATTACH, DELETEISSUE, NEWISSUES, NEWCOMMENTS, WATCHUPDATES,
         * UPDATEISSUE, TRANSITIONISSUE, WATCHERS, ADDISSUELINK, ADDWORKLOG,
         * FETCHISSUE, FETCHCOMMENTS
         * 
         * @param path type
         * @return the dsl builder
         */
        default JiraEndpointBuilder jira(String path) {
            return JiraEndpointBuilderFactory.endpointBuilder("jira", path);
        }
        /**
         * Jira (camel-jira)
         * Interact with JIRA issue tracker.
         * 
         * Category: api,reporting
         * Since: 3.0
         * Maven coordinates: org.apache.camel:camel-jira
         * 
         * Syntax: <code>jira:type</code>
         * 
         * Path parameter: type (required)
         * Operation to perform. Consumers: NewIssues, NewComments. Producers:
         * AddIssue, AttachFile, DeleteIssue, TransitionIssue, UpdateIssue,
         * Watchers. See this class javadoc description for more information.
         * There are 14 enums and the value can be one of: ADDCOMMENT, ADDISSUE,
         * ATTACH, DELETEISSUE, NEWISSUES, NEWCOMMENTS, WATCHUPDATES,
         * UPDATEISSUE, TRANSITIONISSUE, WATCHERS, ADDISSUELINK, ADDWORKLOG,
         * FETCHISSUE, FETCHCOMMENTS
         * 
         * @param componentName to use a custom component name for the endpoint
         * instead of the default name
         * @param path type
         * @return the dsl builder
         */
        default JiraEndpointBuilder jira(String componentName, String path) {
            return JiraEndpointBuilderFactory.endpointBuilder(componentName, path);
        }
    }
    static JiraEndpointBuilder endpointBuilder(String componentName, String path) {
        class JiraEndpointBuilderImpl extends AbstractEndpointBuilder implements JiraEndpointBuilder, AdvancedJiraEndpointBuilder {
            public JiraEndpointBuilderImpl(String path) {
                super(componentName, path);
            }
        }
        return new JiraEndpointBuilderImpl(path);
    }
}