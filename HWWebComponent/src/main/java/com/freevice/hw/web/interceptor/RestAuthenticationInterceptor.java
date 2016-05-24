package com.freevice.hw.web.interceptor;
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
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.freevice.hw.web.model.Account;
import com.freevice.hw.web.model.User;
import com.freevice.hw.web.service.AuthenticationService;



	
	public class RestAuthenticationInterceptor implements HandlerInterceptor {
	
		public RestAuthenticationInterceptor(){
			System.out.println("RestAuthenticationInterceptor called");
		}

		private AuthenticationService authenticationService;

		public AuthenticationService getAuthenticationService() {
			return authenticationService;
		}

		public void setAuthenticationService(AuthenticationService authenticationService) {
			//System.out.println("called setAuthenticationService");
			this.authenticationService = authenticationService;
		}

		public static final String AUTHENTICATION_HEADER = "Authorization";

	

		private boolean doAuthenticateUser(String authCredentials) {
			
			if(authCredentials==null){
				return false;
			}
			// better injected
			Account account = new Account();
			boolean authenticationStatus = authenticationService
					.authenticate(authCredentials);
			
			return authenticationStatus;
		}

		

		public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
				throws Exception {
			System.out.println("afterCompletion called");
			
		}
		public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
				throws Exception {
			System.out.println("postHandle called");
			
		}
		public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
			
			boolean authenticationStatus = true;
			// Avoid a redirect loop for some urls
			if( !request.getRequestURI().contains("/createUser"))
			  {
				String authCredentials = request.getHeader(AUTHENTICATION_HEADER);
				authenticationStatus = doAuthenticateUser(authCredentials);
			}
			return authenticationStatus;
		}
	}
