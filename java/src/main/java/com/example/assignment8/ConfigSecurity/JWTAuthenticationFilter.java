package com.example.assignment8.ConfigSecurity;

import com.example.assignment8.entity.Account;
import com.example.assignment8.service.Account.IAccountService;
import com.example.assignment8.service.Account.JWTTokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	private IAccountService accountService;

    public JWTAuthenticationFilter(String url, AuthenticationManager authManager, IAccountService accountService) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
        this.accountService = accountService;
    }

    @Override
    public Authentication attemptAuthentication(
    		HttpServletRequest request, 
    		HttpServletResponse response) 
    		throws AuthenticationException, IOException, ServletException {
    	
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	
    	Account account = accountService.getAccountByUsername(username);
    	if(account == null){
            return null;
        }
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                		username,
                		password,
                		AuthorityUtils.createAuthorityList(account.getRole())
                )
        );
    }

    @Override
    protected void successfulAuthentication(
    		HttpServletRequest request, 
    		HttpServletResponse response, 
    		FilterChain chain, 
    		Authentication authResult) throws IOException, ServletException {
        JWTTokenService.addJWTTokenToHeader(response, authResult.getName(), accountService);
    }
}
