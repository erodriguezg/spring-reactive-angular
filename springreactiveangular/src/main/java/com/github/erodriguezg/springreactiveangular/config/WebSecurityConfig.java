package com.github.erodriguezg.springreactiveangular.config;

import com.github.erodriguezg.security.jwt.StatelessAuthenticationFilter;
import com.github.erodriguezg.security.jwt.TokenAuthenticationHttpHandler;
import com.github.erodriguezg.security.jwt.TokenService;
import com.github.erodriguezg.springreactiveangular.security.SecurityMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.concurrent.TimeUnit;

/**
 * @author eduardo
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TokenAuthenticationHttpHandler jwtTokenAuthenticationHttpHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/*.html", "**/*.html").permitAll()
                .antMatchers("/*.js", "**/*.js").permitAll()
                .antMatchers("/*.css", "**/*.css").permitAll()

                // Protected refresh jwt token
                .antMatchers("/security/refresh").authenticated()

                // Allow anonymous logins
                .antMatchers("/security/**").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .and()
                .anonymous()
                .and()
                .servletApi()
                .and()
                .headers().cacheControl().disable()
                .and()
                .addFilterAt(new StatelessAuthenticationFilter(this.jwtTokenAuthenticationHttpHandler), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public TokenAuthenticationHttpHandler jwtTokenAuthenticationHttpHandler(
            TokenService tokenService, SecurityMappings securityMappings) {
        return new TokenAuthenticationHttpHandler(
                tokenService,
                securityMappings::tokenSubjectMapToAuth,
                securityMappings::authToTokenSubjectMap);
    }

    @Bean
    public TokenService jwtTokenService(
            @Value("${app.jwt.secret-phrase}") String jwtSecretPhrase,
            @Value("${app.jwt.expiration-minutes}") Long jwtExpirationMinutes) {
        return new TokenService(jwtSecretPhrase, TimeUnit.MINUTES, jwtExpirationMinutes);
    }

    @Bean
    public SecurityMappings securityMappers() {
        return new SecurityMappings();
    }

}
