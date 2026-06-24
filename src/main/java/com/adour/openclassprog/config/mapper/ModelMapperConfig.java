package com.adour.openclassprog.config.mapper;

import com.adour.openclassprog.dto.AccountDTO;
import com.adour.openclassprog.dto.DeviceDTO;
import com.adour.openclassprog.model.Account;
import com.adour.openclassprog.model.Device;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 12/06/2026 - 13:17
 */
@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);

        // Shared Converter
        Converter<String, String> toUppercase = ctx ->
                ctx.getSource() != null ? ctx.getSource().toUpperCase() : null;

        // Call separate configuration methods
        configureAccountMapping(modelMapper, toUppercase);
        configureDeviceMapping(modelMapper, toUppercase);

        return modelMapper;
    }

    private void configureAccountMapping(ModelMapper modelMapper, Converter<String, String> toUppercase) {
        modelMapper.typeMap(AccountDTO.class, Account.class).addMappings(mapper -> {
            mapper.using(toUppercase).map(AccountDTO::getName, Account::setName);
        });
    }

    private void configureDeviceMapping(ModelMapper modelMapper, Converter<String, String> toUppercase) {
        modelMapper.typeMap(DeviceDTO.class, Device.class).addMappings(mapper -> {
            mapper.using(toUppercase).map(DeviceDTO::getUser, Device::setUser);
        });
    }
}
