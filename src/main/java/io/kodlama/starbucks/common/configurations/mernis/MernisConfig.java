package io.kodlama.starbucks.common.configurations.mernis;

import io.kodlama.starbucks.adapter.mernis.webService.MEEKPSPublicSoap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MernisConfig {

    @Bean
    public MEEKPSPublicSoap getMernisSoap(){
        return new MEEKPSPublicSoap();
    }
}
