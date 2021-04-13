package com.easy2excel.crm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;
//@Configuration
public class AuditingService implements AuditorAware<String> {

    @Bean
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Anil Sahoo");
    }
}
