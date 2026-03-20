package com.edutech.progressive.config;

<<<<<<< HEAD
import com.edutech.progressive.jwt.JwtRequestFilter;
=======
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
<<<<<<< HEAD
=======
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
<<<<<<< HEAD
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

=======

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.edutech.progressive.jwt.JwtRequestFilter;
import com.edutech.progressive.service.LoginService;


>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
<<<<<<< HEAD
    private final UserDetailsService userDetailsService;
    private final JwtRequestFilter jwtRequestFilter;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService,
                          JwtRequestFilter jwtRequestFilter,
                          PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
=======

    @Autowired private JwtRequestFilter jwtRequestFilter;
    @Autowired private LoginService userService;

    @Bean
    public PasswordEncoder passwordEncoder() { return PasswordEncoderFactories.createDelegatingPasswordEncoder(); }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(passwordEncoder());
        auth.authenticationProvider(provider);
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
<<<<<<< HEAD
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/register", "/user/login").permitAll()
                .antMatchers(HttpMethod.GET, "/supplier/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/supplier/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/supplier/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.DELETE, "/supplier/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/warehouse/**").hasAnyAuthority("USER", "ADMIN") // Repeat for accounts
                .antMatchers(HttpMethod.POST, "/warehouse/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/warehouse/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/warehouse/**").hasAuthority("ADMIN")
                .antMatchers("/product/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/shipment/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/insurance/**").hasAnyAuthority("USER", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
=======
        http.csrf().disable()
           .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
           .and()
           .authorizeRequests()
             .antMatchers("/user/register", "/user/login", "/h2-console/**").permitAll()
             .antMatchers(HttpMethod.GET, "/product/**").authenticated()
             .antMatchers("/supplier/**").authenticated()
             .antMatchers("/warehouse/**").authenticated()
             .anyRequest().authenticated()
           .and()
           .headers().frameOptions().disable();
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

<<<<<<< HEAD
    @Bean
    @Override
=======
    @Override
    @Bean
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}