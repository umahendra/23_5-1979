package com.freevice.hw.web.filter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.freevice.hw.web.model.Account;
import com.freevice.hw.web.model.User;
import com.freevice.hw.web.service.AuthenticationService;



	
	public class RestAuthenticationFilter implements javax.servlet.Filter {
		private FilterConfig filterConfig;
		public RestAuthenticationFilter(AuthenticationService authenticationService){
			this.authenticationService = authenticationService;
		}
		public RestAuthenticationFilter(){
			
		}

		private AuthenticationService authenticationService;

		public AuthenticationService getAuthenticationService() {
			return authenticationService;
		}

		public void setAuthenticationService(AuthenticationService authenticationService) {
			System.out.println("called setAuthenticationService");
			this.authenticationService = authenticationService;
		}

		public static final String AUTHENTICATION_HEADER = "Authorization";

		public void doFilter(ServletRequest request, ServletResponse response,
				FilterChain filter) throws IOException, ServletException {
			System.out.println("doFilter is invoked");
			//filter.
			if (request instanceof HttpServletRequest) {
				
				User user = new User();
				
				
				HttpServletRequest httpServletRequest = (HttpServletRequest) request;
				String authCredentials = httpServletRequest
						.getHeader(AUTHENTICATION_HEADER);

				
				boolean authenticationStatus = doAuthenticateUser(user, authCredentials);

				
				if (authenticationStatus) {
					System.out.println("Auth process done, process further filters");
					
					filter.doFilter(request, response);
				} else 
				{
					System.out.println("Auth process failed, process further filters for testing only");
					
					//TODO:MS:Uncomment out below for actual check,This is to just by pass
					filter.doFilter(request, response);
					//TODO:MS:Comment out below for actual check
					/*if (response instanceof HttpServletResponse) {
						HttpServletResponse httpServletResponse = (HttpServletResponse) response;
						httpServletResponse
								.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					}*/
				}
				
				// Now Return;
				System.out.println("Done with filtering Now send response Back");
				if (response instanceof HttpServletResponse) {
					HttpServletResponse httpServletResponse = (HttpServletResponse) response;
					/*httpServletResponse.setHeader("WWW-Authenticate", "BASIC realm=\"executives\"");
					httpServletResponse.setHeader("Author", "token");*/
					httpServletResponse
							.setStatus(HttpServletResponse.SC_OK);
				}
			}
		}

		private boolean doAuthenticateUser(User user, String authCredentials) {
			
			if(authCredentials==null){
				/*user.resetUserName("admin");
				user.resetUserName("admin");*/
			}
			// better injected
			Account account = new Account();
			boolean authenticationStatus = authenticationService
					.authenticate(authCredentials);
			 // Issue a token for the user
			String accessKey = issueToken(user.getEmail());
			//user.resetAccessKey(accessKey);
         
			//account.set(token);
			// Return the token on the response
         //return httpServletResponse.ok(token).build();
			return authenticationStatus;
		}

		private String issueToken(String firstname) {
			Random random = new SecureRandom();
			System.out.println("User name is:"+firstname);
			String token = new BigInteger(130, random).toString(32);
		    return token;
		}

		public void destroy() {
		}

		public void init(FilterConfig filterConfig) throws ServletException {
			System.out.println("RestAuthenticationFilter called init of Filter");
			this.filterConfig = filterConfig;
			/*AuthenticationService authenticationService = WebApplicationContextUtils.getRequiredWebApplicationContext(filterConfig.getServletContext()).
			  getBean(AuthenticationService.class);
			setAuthenticationService(authenticationService);*/
		}
	}
	/*Before the RESTful resource is invoked, we get control in the above class. We get the HTTP Header value for Authorization. That’s the Basic authentication credential and we will pass it on to AuthenticationService for validation.

	Step 3: AuthenticationService
*/
	
	
	
	/*aopalliance-repackaged-2.4.0-b06.jar
	asm-debug-all-5.0.2.jar
	hk2-api-2.4.0-b06.jar
	hk2-locator-2.4.0-b06.jar
	hk2-utils-2.4.0-b06.jar
	javassist-3.18.1-GA.jar
	javax.annotation-api-1.2.jar
	javax.inject-2.4.0-b06.jar
	javax.servlet-api-3.0.1.jar
	javax.ws.rs-api-2.0.1.jar
	jaxb-api-2.2.7.jar
	jersey-client.jar
	jersey-common.jar
	jersey-container-servlet-core.jar
	jersey-container-servlet.jar
	jersey-guava-2.15.jar
	jersey-server.jar
	org.osgi.core-4.2.0.jar
	osgi-resource-locator-1.0.1.jar
	persistence-api-1.0.jar
	validation-api-1.1.0.Final.jar*/