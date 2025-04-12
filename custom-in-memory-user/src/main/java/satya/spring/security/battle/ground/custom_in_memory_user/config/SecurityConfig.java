package satya.spring.security.battle.ground.custom_in_memory_user.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    /**
     * Configures the security filter chain to handle HTTP security.
     * It defines authorization rules based on request matchers and user authorities.
     * - "/dashboard" requires "USER" authority
     * - "/admin-dashboard" requires "ADMIN" authority
     * - All other requests are permitted without authentication
     * Disables form login and enables HTTP Basic authentication with default settings.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> {
                    request.requestMatchers("/dashboard").hasAuthority("USER")
                            .requestMatchers("/admin-dashboard").hasAuthority("ADMIN")
                            .anyRequest().permitAll();
                })
                .formLogin(formLogin -> formLogin.disable())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    /**
     * Create an in memory user details manager with two users: user and admin. The password for both users is "password".
     * The user has the authority USER and the admin has the role USER and ADMIN.
     * @return the in memory user details manager
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("user").password("{noop}password").authorities("USER").build();
        UserDetails admin = User.withUsername("admin").password("{noop}password").authorities("USER", "ADMIN").build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}
