package webtech.frogscheduler.frogschedulerbackend.configuration;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.web.SecurityFilterChain;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Configuration
public class SecurityConfiguration {
    @Value("${jwt.public.key}")
    RSAPublicKey key;

    @Value("${jwt.private.key}")
    RSAPrivateKey priv;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults());
        http
                .authorizeHttpRequests((authorize) -> authorize
//                                .antMatchers(HttpMethod.DELETE, "/users/**").hasAuthority("ROLE_admin")
//                        .antMatchers(HttpMethod.DELETE, "/users/**").hasRole("admin")
                                // Disallow everything else...
                                .antMatchers(HttpMethod.POST, "/users").permitAll()
                                .antMatchers(HttpMethod.POST, "/requests").authenticated()
                                .antMatchers(HttpMethod.PUT, "/requests/**").authenticated()
                                .antMatchers(HttpMethod.PUT, "/users/**").permitAll()
                                .antMatchers(HttpMethod.GET, "/director/**").authenticated()
                                .antMatchers(HttpMethod.GET, "/team/**").authenticated()
                                .antMatchers(HttpMethod.GET, "/customer/**").authenticated()
                                .antMatchers(HttpMethod.GET, "/users/superfrogs").hasAuthority("ROLE_director")
                                .antMatchers(HttpMethod.GET, "/users/customers").hasAuthority("ROLE_director")
                )

                .csrf((csrf) -> csrf.disable()
//                                csrf.ignoringAntMatchers("/auth/login")
//                                    .ignoringAntMatchers("/users")
                )
                .httpBasic(Customizer.withDefaults()) // using HTTP Basic Authentication
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling((exceptions) -> exceptions
                        .authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
                        .accessDeniedHandler(new BearerTokenAccessDeniedHandler())
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(this.key).build();
    }

    @Bean
    JwtEncoder jwtEncoder() {
        JWK jwk = new RSAKey.Builder(this.key).privateKey(this.priv).build();
        JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
        return new NimbusJwtEncoder(jwks);
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();

        // Let’s say that that your authorization server communicates authorities in a custom claim called authorities.
        // In that case, you can configure the claim that JwtAuthenticationConverter should inspect, like so:
        grantedAuthoritiesConverter.setAuthoritiesClaimName("authorities");

        // You can also configure the authority prefix to be different as well.
        // For example, you can change it to ROLE_ like so:
        grantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
        return jwtAuthenticationConverter;
    }
}
