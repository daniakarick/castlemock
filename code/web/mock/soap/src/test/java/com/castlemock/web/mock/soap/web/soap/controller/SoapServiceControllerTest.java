package com.castlemock.web.mock.soap.web.soap.controller;

import com.castlemock.web.basis.web.mvc.controller.AbstractController;
import com.castlemock.web.mock.soap.config.TestApplication;
import com.castlemock.web.mock.soap.web.mvc.controller.AbstractSoapControllerTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author Karl Dahlgren
 * @since 1.4
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplication.class)
@WebAppConfiguration
public class SoapServiceControllerTest extends AbstractSoapControllerTest {

    @InjectMocks
    private SoapServiceController soapServiceController;

    @Override
    protected AbstractController getController() {
        return soapServiceController;
    }


    @Test
    public void testProcess(){

    }
}
