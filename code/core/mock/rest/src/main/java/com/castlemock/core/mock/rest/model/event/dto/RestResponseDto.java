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

package com.castlemock.core.mock.rest.model.event.dto;

import com.castlemock.core.basis.model.http.dto.HttpHeaderDto;
import org.dozer.Mapping;

import java.util.List;

/**
 * @author Karl Dahlgren
 * @since 1.0
 */

public class RestResponseDto {

    @Mapping("body")
    private String body;

    @Mapping("mockResponseName")
    private String mockResponseName;

    @Mapping("httpStatusCode")
    private Integer httpStatusCode;

    @Mapping("contentType")
    private String contentType;

    @Mapping("httpHeaders")
    private List<HttpHeaderDto> httpHeaders;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getMockResponseName() {
        return mockResponseName;
    }

    public void setMockResponseName(String mockResponseName) {
        this.mockResponseName = mockResponseName;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public List<HttpHeaderDto> getHttpHeaders() {
        return httpHeaders;
    }

    public void setHttpHeaders(List<HttpHeaderDto> httpHeaders) {
        this.httpHeaders = httpHeaders;
    }
}
