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

package com.castlemock.web.mock.soap.web.mvc.controller.port;


import com.castlemock.core.basis.model.ServiceProcessor;
import com.castlemock.core.mock.soap.model.project.dto.SoapOperationDto;
import com.castlemock.core.mock.soap.model.project.dto.SoapPortDto;
import com.castlemock.core.mock.soap.model.project.dto.SoapProjectDto;
import com.castlemock.core.mock.soap.model.project.service.message.input.ReadSoapPortInput;
import com.castlemock.core.mock.soap.model.project.service.message.output.ReadSoapPortOutput;
import com.castlemock.web.basis.web.mvc.controller.AbstractController;
import com.castlemock.web.mock.soap.config.TestApplication;
import com.castlemock.web.mock.soap.model.project.SoapOperationDtoGenerator;
import com.castlemock.web.mock.soap.model.project.SoapPortDtoGenerator;
import com.castlemock.web.mock.soap.model.project.SoapProjectDtoGenerator;
import com.castlemock.web.mock.soap.web.mvc.controller.AbstractSoapControllerTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * @author Karl Dahlgren
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplication.class)
@WebAppConfiguration
public class SoapPortControllerTest extends AbstractSoapControllerTest {

    private static final String PAGE = "partial/mock/soap/port/soapPort.jsp";


    @InjectMocks
    private SoapPortController soapPortController;

    @Mock
    private ServiceProcessor serviceProcessor;

    @Override
    protected AbstractController getController() {
        return soapPortController;
    }

    @Test
    public void getSoapPort() throws Exception {
        final SoapProjectDto soapProjectDto = SoapProjectDtoGenerator.generateSoapProjectDto();
        final SoapPortDto soapPortDto = SoapPortDtoGenerator.generateSoapPortDto();
        final SoapOperationDto soapOperationDto = SoapOperationDtoGenerator.generateSoapOperationDto();
        final List<SoapOperationDto> operationDtos = new ArrayList<SoapOperationDto>();
        operationDtos.add(soapOperationDto);
        soapPortDto.setOperations(operationDtos);
        when(serviceProcessor.process(any(ReadSoapPortInput.class))).thenReturn(new ReadSoapPortOutput(soapPortDto));
        final MockHttpServletRequestBuilder message = MockMvcRequestBuilders.get(SERVICE_URL + PROJECT + SLASH + soapProjectDto.getId() + SLASH + PORT + SLASH + soapPortDto.getId() + SLASH);
        ResultActions result = mockMvc.perform(message)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(4 + GLOBAL_VIEW_MODEL_COUNT))
                .andExpect(MockMvcResultMatchers.forwardedUrl(INDEX))
                .andExpect(MockMvcResultMatchers.model().attribute(PARTIAL, PAGE))
                .andExpect(MockMvcResultMatchers.model().attribute(SOAP_PORT, soapPortDto));
        SoapPortDto soapPortDtoResponse = (SoapPortDto) result.andReturn().getModelAndView().getModel().get(SOAP_PORT);
    }


}
