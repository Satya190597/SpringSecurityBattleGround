package satya.spring.security.battle.ground.initial_configuration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    @Primary
    SecurityFilterChain myCustomFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((request) ->
                        request.requestMatchers("/settings", "/dashboard").authenticated()
                                .anyRequest().permitAll())
                .formLogin(formLogin -> formLogin.disable())
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }
}
