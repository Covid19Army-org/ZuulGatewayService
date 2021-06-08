package com.covid19army.ZuulGatewayService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.covid19army.ZuulGatewayService.dtos.UserResponseDto;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class AuthorizationFilter extends ZuulFilter {
	private static Logger log = LoggerFactory.getLogger(AuthorizationFilter.class);

	@Autowired
	RequestScopedUserContext userContext;	
	

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		log.info("executed zuul auth filter");
		RequestContext ctx = RequestContext.getCurrentContext();
		var isAuthenticated = SecurityContextHolder.getContext().getAuthentication() != null;
		if(isAuthenticated) {
			var userdto = userContext.getUserdto();
			if(userdto != null) {
				ctx.addZuulRequestHeader("X-Auth-User", String.valueOf(userdto.getUserid()));
				//TODO: set roles for user here
			}			
		}
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
