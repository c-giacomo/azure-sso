package it.azure.sso.client.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

//@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class AzureActiveDirectoryAuth extends WebSecurityConfigurerAdapter {
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers(PROTECTED_URLS).authenticated()
            ).oauth2Login();
            
    }
	
	private static final RequestMatcher PROTECTED_URLS = new OrRequestMatcher(
            new AntPathRequestMatcher("/aadauth/**")
    );

}
