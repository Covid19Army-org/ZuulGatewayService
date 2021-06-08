package com.covid19army.ZuulGatewayService;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.covid19army.ZuulGatewayService.dtos.UserResponseDto;

@Component
@RequestScope
public class RequestScopedUserContext {

	UserResponseDto userdto;

	public UserResponseDto getUserdto() {
		return userdto;
	}

	public void setUserdto(UserResponseDto userdto) {
		this.userdto = userdto;
	}
	
}
