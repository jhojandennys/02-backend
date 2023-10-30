package com.dennys.ecommerce.config;
 
import com.okta.spring.boot.oauth.Okta;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import static org.springframework.security.config.Customizer.withDefaults;

//import com.okta.spring.boot.oauth.Okta;
 
@Configuration
public class SecurityConfiguration {
   
   @Bean
   protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      
      //protect endpoint /api/orders
      http.cors(withDefaults()).authorizeHttpRequests(requests ->
                  requests 
                        .requestMatchers("/api/orders/**")
                        .authenticated()
                        .anyRequest().permitAll())
                        .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));;
                     
      //add content negotiation strategy
      http.setSharedObject(ContentNegotiationStrategy.class, new
            HeaderContentNegotiationStrategy());
      
      //force a non-empty response body for 401's to make the response more friendly
      Okta.configureResourceServer401ResponseBody(http);
      
      // disable CSRF since we are not using Cookies for session tracking      
      return http.csrf(csrf -> csrf.disable())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
   }

 
}