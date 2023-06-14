package com.praneeth.productService.Configuration;

import com.praneeth.productService.Filter.JwtAuthFilter;
import com.praneeth.productService.Model.UserDetailsLoader;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Data
@Configuration
@EnableWebSecurity
//@EnableMethodSecurity
public class SecurityConfiguration {

    @Autowired
    private JwtAuthFilter jwtAuthFilter;
    @Bean
    public UserDetailsService userDetailsService (  ) {
//        UserDetails admin = User.withUsername ( "Admin" ).password ( passwordEncoder.encode ( "Admin@123" ) ).roles ( "adm" ).build ( );
        return new UserDetailsService ( ) {
            @Override
            public UserDetails loadUserByUsername ( String username ) throws UsernameNotFoundException {
                return new UserDetailsLoader ();
            }
        };
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return  authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain ( HttpSecurity httpSecurity ) throws Exception {
        httpSecurity.csrf ( AbstractHttpConfigurer::disable ).
                cors ( Customizer.withDefaults () )
                . authorizeHttpRequests( auth ->
                        auth.requestMatchers("/auth","/order","/getAllFoods").permitAll()
                ).authorizeHttpRequests( auth ->
                auth.requestMatchers("/**").authenticated ()
        )
                .sessionManagement(http -> http.sessionCreationPolicy( SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider()).addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
;
        return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authenticationManager( AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }



    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


}
