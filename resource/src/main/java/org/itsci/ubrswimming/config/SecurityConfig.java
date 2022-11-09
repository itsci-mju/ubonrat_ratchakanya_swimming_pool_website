package org.itsci.ubrswimming.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//   @Bean
//   public UserDetailsService userDetailsService() {
//       InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//       manager.createUser(User.withUsername("john").password("{noop}test123").roles("web").build());
//       manager.createUser(User.withUsername("mary").password("{noop}test123").roles("1", "2").build());
//       manager.createUser(User.withUsername("susan").password("{noop}test123").roles("1", "3").build());
//       return manager;
//   }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(configurer -> {
        	configurer.antMatchers("/member/**").authenticated()
            .antMatchers("/trainee/**").hasRole("1")
            .antMatchers("/shop/**").hasRole("MANAGER")
            .antMatchers("/category/**").hasRole("ADMIN")
            .antMatchers("/member/**").hasRole("ADMIN");
        });

        http.exceptionHandling(configurer -> {
            configurer.accessDeniedPage("/access-denied");
        });

        http.formLogin(configurer -> {
                    try {
                        configurer.loginPage("/loginpage")
                                .loginProcessingUrl("/authenticate")
                                .permitAll()
                                .and()
                                .logout().permitAll();
                    } catch (Exception e) { e.printStackTrace(); }
                }
        );
        return http.build();
    }
}
