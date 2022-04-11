//package it.azure.sso.server.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import com.azure.spring.aad.webapi.AADJwtBearerTokenAuthenticationConverter;
//
//import it.azure.sso.client.security.AzureActiveDirectoryAuth;
//
//@Configuration
//public class SecurityConfig {
//	
//	@Configuration
//	@Order(1)
//	public static class RestApiSecurityConfig extends WebSecurityConfigurerAdapter {
//		
//		@Override
//        protected void configure(HttpSecurity http) throws Exception {
//			
//	        http.cors()
//	        	.and()
//	        	.requestMatchers().antMatchers("/api/**")
//	        	.and()
//	        	.authorizeRequests().anyRequest().authenticated()
//	            .and()
//	            .oauth2ResourceServer()
//	            .jwt()
//                .jwtAuthenticationConverter(new AADJwtBearerTokenAuthenticationConverter());
//		}
//    }
//	
//	@Configuration
//	@Import(AzureActiveDirectoryAuth.class)
//	public static class AzureConfiguration {}
//
//}
