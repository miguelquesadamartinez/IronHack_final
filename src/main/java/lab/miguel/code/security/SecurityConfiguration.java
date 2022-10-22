package lab.miguel.code.security;

import lab.miguel.code.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConf) throws Exception {
        return authConf.getAuthenticationManager();
    }

    /*

/
/
/{id}

    * */

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();

        httpSecurity.authorizeRequests()
                .mvcMatchers(HttpMethod.POST,"/create-third-pàrty").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.POST,"/pay-third-party").hasAnyRole("ADMIN", "USER")
                .mvcMatchers(HttpMethod.POST,"/transfer-to-third-party").hasRole("ADMIN")

                .mvcMatchers(HttpMethod.POST,"/transfer-to-account").hasAnyRole("ADMIN", "USER")
                .mvcMatchers(HttpMethod.GET,"/get-all-accounts").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.GET, "/get-account-balance").hasAnyRole("ADMIN", "USER")

                .mvcMatchers(HttpMethod.POST,"/create-student").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.POST,"/create-savings").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.POST,"/create-credit-card").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.POST,"/create-checking").hasRole("ADMIN")

                .mvcMatchers(HttpMethod.POST,"/create-address").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.POST,"/GET-addresses").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.POST,"/get-address/**").hasRole("ADMIN")

                .mvcMatchers(HttpMethod.POST,"/create-account-holder").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.POST,"/get-accounts").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.POST,"/get-account-holder/**").hasRole("ADMIN")

                .mvcMatchers(HttpMethod.GET,"/users").denyAll()


                .anyRequest().permitAll();

        httpSecurity.csrf().disable();

        return httpSecurity.build();

    }

}
