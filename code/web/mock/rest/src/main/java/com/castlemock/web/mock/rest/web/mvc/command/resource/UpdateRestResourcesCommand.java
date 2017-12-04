/*
 * Copyright 2015 Karl Dahlgren
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.castlemock.web.mock.rest.web.mvc.command.resource;


import com.castlemock.core.mock.rest.model.project.domain.RestMethodStatus;
import com.castlemock.core.mock.rest.model.project.domain.RestResponseStrategy;
import com.castlemock.core.mock.rest.model.project.dto.RestResourceDto;

import java.util.List;

/**
 * The UpdateRestResourcesEndpointCommand is a command class and is used to identify which resource
 * will be updated with a new endpoint
 * @author Karl Dahlgren
 * @since 1.17
 */
public class UpdateRestResourcesCommand {

    private List<RestResourceDto> restResources;
    private RestMethodStatus status;
    private RestResponseStrategy responseStrategy;
    private String forwardedEndpoint;
    private String networkDelay;
    private Boolean simulateNetworkDelay = false;

    public List<RestResourceDto> getRestResources() {
        return restResources;
    }

    public void setRestResources(List<RestResourceDto> restResources) {
        this.restResources = restResources;
    }

    /**
     * Returns the forwarded endpoint
     * @return The forwarded endpoint
     */
    public String getForwardedEndpoint() {
        return forwardedEndpoint;
    }

    /**
     * Sets a new value for the forwarded endpoint
     * @param forwardedEndpoint The new value for forwarded endpoint
     */
    public void setForwardedEndpoint(String forwardedEndpoint) {
        this.forwardedEndpoint = forwardedEndpoint;
    }

    public RestMethodStatus getStatus() {
        return status;
    }

    public void setStatus(RestMethodStatus status) {
        this.status = status;
    }

    public RestResponseStrategy getResponseStrategy() {
        return responseStrategy;
    }

    public void setResponseStrategy(RestResponseStrategy responseStrategy) {
        this.responseStrategy = responseStrategy;
    }

    public String getNetworkDelay() {
        return networkDelay;
    }

    public void setNetworkDelay(String networkDelay) {
        this.networkDelay = networkDelay;
    }

    public Boolean getSimulateNetworkDelay() {
        return simulateNetworkDelay;
    }

    public void setSimulateNetworkDelay(Boolean simulateNetworkDelay) {
        this.simulateNetworkDelay = simulateNetworkDelay;
    }
}

