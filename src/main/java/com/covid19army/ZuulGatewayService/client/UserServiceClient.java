package com.covid19army.ZuulGatewayService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.covid19army.ZuulGatewayService.dtos.UserResponseDto;

@FeignClient(name="UserServiceClient", url="${app.client.userservice.url}")
public interface UserServiceClient {
	@GetMapping("/user/{mobileNumber}")
	public UserResponseDto findByUsername(@PathVariable String mobileNumber);
}
