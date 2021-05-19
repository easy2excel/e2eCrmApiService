package com.easy2excel.crm.controller;/*
package com.app.korero.controller;


import com.app.korero.authentication.config.AuthToken;
import com.app.korero.authentication.config.TokenProvider;
import com.app.korero.authentication.dto.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/token")
@Slf4j
public class AuthenticationController {

	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

   
    
 

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody LoginUser loginUser, HttpServletRequest request) {
    	
    	log.debug("inside generate token...");

		log.debug("user name ... "  +  loginUser.getUsername());
		log.debug("password ... "  +  loginUser.getPassword());


    	
    	try {
    		
    		
    		final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginUser.getUsername(),
                            loginUser.getPassword()
                    )
            );
			  
            SecurityContextHolder.getContext().setAuthentication(authentication);
            
            final String token = jwtTokenUtil.generateToken(authentication);
           

            
            if (null != token && !token.isEmpty()) {
            	
            	return ResponseEntity.ok(new AuthToken(token));
			}else {
       return new ResponseEntity<String>("You have entered an invalid username or password", HttpStatus.FORBIDDEN);
				
			}
        	
    		
		} catch (Exception e) {
			e.printStackTrace();
		   	
			return new ResponseEntity<String>("You have entered an invalid username or password ", HttpStatus.FORBIDDEN);
		}
		
    	

    }


}
*/
