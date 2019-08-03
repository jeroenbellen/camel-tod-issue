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
package org.apache.camel.management.mbean;

import org.apache.camel.CamelContext;
import org.apache.camel.api.management.ManagedResource;
import org.apache.camel.api.management.mbean.ManagedProducerCacheMBean;
import org.apache.camel.spi.ProducerCache;

@ManagedResource(description = "Managed ProducerCache")
public class ManagedProducerCache extends ManagedService implements ManagedProducerCacheMBean {
    private final ProducerCache producerCache;

    public ManagedProducerCache(CamelContext context, ProducerCache producerCache) {
        super(context, producerCache);
        this.producerCache = producerCache;
    }

    public ProducerCache getProducerCache() {
        return producerCache;
    }

    @Override
    public String getSource() {
        if (producerCache.getSource() != null) {
            return producerCache.getSource().toString();
        }
        return null;
    }

    @Override
    public Integer getSize() {
        return producerCache.size();
    }

    @Override
    public Integer getMaximumCacheSize() {
        return producerCache.getCapacity();
    }

    @Override
    public Long getHits() {
        return producerCache.getHits();
    }

    @Override
    public Long getMisses() {
        return producerCache.getMisses();
    }

    @Override
    public Long getEvicted() {
        return producerCache.getEvicted();
    }

    @Override
    public void resetStatistics() {
        producerCache.resetCacheStatistics();
    }

    @Override
    public void purge() {
        producerCache.purge();
    }

    @Override
    public Boolean isEventNotifierEnabled() {
        return producerCache.isEventNotifierEnabled();
    }
}
