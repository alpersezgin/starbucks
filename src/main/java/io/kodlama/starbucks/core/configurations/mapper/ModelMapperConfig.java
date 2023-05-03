package io.kodlama.starbucks.core.configurations.mapper;

import io.kodlama.starbucks.core.configurations.mapper.converters.TimestampToLocalDateTimeConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addConverter(new TimestampToLocalDateTimeConverter());
        return new ModelMapper();
    }
}