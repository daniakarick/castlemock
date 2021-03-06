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

package com.castlemock.web.mock.soap.model.project;

import com.castlemock.core.mock.soap.model.project.domain.SoapMockResponse;
import com.castlemock.core.mock.soap.model.project.domain.SoapMockResponseStatus;
import com.castlemock.core.mock.soap.model.project.dto.SoapMockResponseDto;

/**
 * @author Karl Dahlgren
 * @since 1.0
 */
public class SoapMockResponseDtoGenerator {

    public static SoapMockResponseDto generateSoapMockResponseDto(){
        final SoapMockResponseDto soapMockResponseDto = new SoapMockResponseDto();
        soapMockResponseDto.setName("Soap mock response name");
        soapMockResponseDto.setBody("Soap mock response body");
        soapMockResponseDto.setId("SOAP MOCK RESPONSE");
        soapMockResponseDto.setStatus(SoapMockResponseStatus.ENABLED);
        return soapMockResponseDto;
    }

    public static SoapMockResponse generateSoapMockResponse(){
        final SoapMockResponse soapMockResponse = new SoapMockResponse();
        soapMockResponse.setName("Soap mock response name");
        soapMockResponse.setBody("Soap mock response body");
        soapMockResponse.setId("SOAP MOCK RESPONSE");
        soapMockResponse.setStatus(SoapMockResponseStatus.ENABLED);
        return soapMockResponse;
    }
}
