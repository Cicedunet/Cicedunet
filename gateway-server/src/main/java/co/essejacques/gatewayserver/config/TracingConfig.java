package co.essejacques.gatewayserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.micrometer.tracing.propagation.Propagator;
import brave.propagation.B3Propagation;
import brave.propagation.Propagation;
import io.micrometer.tracing.brave.bridge.BravePropagator;

@Configuration
public class TracingConfig {
    @Bean
    public Propagator b3Propagator() {
        return new BravePropagator(B3Propagation.FACTORY);
    }
}
