package it.azure.sso.client.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms365auth")
public class AzureActiveDirectoryLoginProvider {
	
	public final static Logger logger = LoggerFactory.getLogger(AzureActiveDirectoryLoginProvider.class);
	
	@GetMapping("/redirect")
	public ResponseEntity<String> redirect(@RegisteredOAuth2AuthorizedClient("graph") OAuth2AuthorizedClient client) {
		
		OAuth2AccessToken token = client.getAccessToken();
		OAuth2RefreshToken refreshtoken = client.getRefreshToken();
		
		ClientRegistration clientReg = client.getClientRegistration();
		
		logger.info(String.format("Client Id %s, Client Name %s, Client Scopes %s", clientReg.getClientId(), clientReg.getClientName(), clientReg.getScopes()));
		
		logger.info(String.format("Token Value %s", token.getTokenValue()));
		logger.info(String.format("Refresh Token Value %s", refreshtoken.getTokenValue()));
				
		return new ResponseEntity<String>(token.getTokenValue(), HttpStatus.OK);
	}

}
