package com.adour.openclassprog.config.mapper;

import com.adour.openclassprog.dto.CrmDTO;
import com.adour.openclassprog.model.Crm;
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
        // KONFIGURASI PENTING: Mengabaikan field yang bernilai null saat mapping
        modelMapper.getConfiguration()
                .setSkipNullEnabled(true);
        // Konverter string menjadi huruf besar.
        Converter<String, String> toUppercase = ctx ->
                ctx.getSource() != null ? ctx.getSource().toUpperCase() : null;
        modelMapper.typeMap(CrmDTO.class, Crm.class).addMappings(mapper -> {
            mapper.using(toUppercase).map(CrmDTO::getName, Crm::setName);
        });
        return modelMapper;
    }
}
