/*
 * Copyright 2016 Karl Dahlgren
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

package com.castlemock.web.mock.websocket.model.project.service;

import com.castlemock.core.basis.model.Service;
import com.castlemock.core.basis.model.ServiceResult;
import com.castlemock.core.basis.model.ServiceTask;
import com.castlemock.core.mock.websocket.model.project.dto.WebSocketBroadcasterDto;
import com.castlemock.core.mock.websocket.model.project.dto.WebSocketResourceDto;
import com.castlemock.core.mock.websocket.model.project.service.message.input.DeleteWebSocketBroadcastersInput;
import com.castlemock.core.mock.websocket.model.project.service.message.input.DeleteWebSocketResourcesInput;
import com.castlemock.core.mock.websocket.model.project.service.message.output.DeleteWebSocketBroadcastersOutput;
import com.castlemock.core.mock.websocket.model.project.service.message.output.DeleteWebSocketResourcesOutput;


/**
 * @author Karl Dahlgren
 * @since 1.5
 */
@org.springframework.stereotype.Service
public class DeleteWebSocketBroadcastersService extends AbstractWebSocketProjectService implements Service<DeleteWebSocketBroadcastersInput, DeleteWebSocketBroadcastersOutput> {

    /**
     * The process message is responsible for processing an incoming serviceTask and generate
     * a response based on the incoming serviceTask input
     * @param serviceTask The serviceTask that will be processed by the service
     * @return A result based on the processed incoming serviceTask
     * @see ServiceTask
     * @see ServiceResult
     */
    @Override
    public ServiceResult<DeleteWebSocketBroadcastersOutput> process(final ServiceTask<DeleteWebSocketBroadcastersInput> serviceTask) {
        final DeleteWebSocketBroadcastersInput input = serviceTask.getInput();
        for(final WebSocketBroadcasterDto webSocketBroadcasterDto : input.getWebSocketBroadcasters()){
            repository.deleteWebSocketBroadcaster(input.getWebSocketProjectId(),
                    input.getWebSocketTopicId(), webSocketBroadcasterDto.getId());
        }

        return createServiceResult(new DeleteWebSocketBroadcastersOutput());
    }
}