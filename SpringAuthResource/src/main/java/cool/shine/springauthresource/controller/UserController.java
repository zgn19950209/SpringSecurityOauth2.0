package cool.shine.springauthresource.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述: 用户端点
 */
@Slf4j
@RestController
public class UserController {

    @GetMapping(value = "/get")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Authentication> get(Authentication authentication) {
        authentication.getCredentials();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        return ResponseEntity.ok(authentication);
    }
}
