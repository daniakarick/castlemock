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

package com.castlemock.core.basis.model.system.service.message.output;

import com.castlemock.core.basis.model.Output;
import com.castlemock.core.basis.model.system.service.dto.SystemInformationDto;
import com.castlemock.core.basis.model.user.dto.UserDto;
import com.castlemock.core.basis.model.user.service.message.input.CreateUserInput;
import com.castlemock.core.basis.model.validation.NotNull;

/**
 * Get system information output
 * @author Karl Dahlgren
 * @since 1.7
 * @see com.castlemock.core.basis.model.system.service.message.input.GetSystemInformationInput
 */
public class GetSystemInformationOutput implements Output {

    private SystemInformationDto systemInformation;

    public GetSystemInformationOutput(SystemInformationDto systemInformation) {
        this.systemInformation = systemInformation;
    }

    public SystemInformationDto getSystemInformation() {
        return systemInformation;
    }

    public void setSystemInformation(SystemInformationDto systemInformation) {
        this.systemInformation = systemInformation;
    }
}
