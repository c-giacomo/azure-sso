package it.azure.sso.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/test")
//    @PreAuthorize("hasAuthority('APPROLE_Admin')")
    public String Admin() {
        return "Admin message";
    }

}
