package com.fortmocks.core.model.configuration.processor.message.input;

import com.fortmocks.core.model.Input;
import com.fortmocks.core.model.configuration.dto.ConfigurationGroupDto;
import com.fortmocks.core.model.validation.NotNull;

import java.util.List;

/**
 * @author Karl Dahlgren
 * @since 1.0
 */
public class UpdateAllConfigurationGroupsInput implements Input{

    @NotNull
    private List<ConfigurationGroupDto> configurationGroups;

    public List<ConfigurationGroupDto> getConfigurationGroups() {
        return configurationGroups;
    }

    public void setConfigurationGroups(List<ConfigurationGroupDto> configurationGroups) {
        this.configurationGroups = configurationGroups;
    }
}