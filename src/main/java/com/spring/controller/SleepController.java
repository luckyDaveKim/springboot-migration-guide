package com.spring.controller;

import static java.lang.Thread.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.service.SleepService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/sleep")
@Api(description = "sleep 처리 API")
public class SleepController {
	@Autowired
	private SleepService sleepService;

	@RequestMapping(value = "/{msSec}", method = GET)
	public String sleepMsSec(@PathVariable Long msSec) throws InterruptedException {
		sleep(msSec);
		return String.format("sleep %d msSec", msSec);
	}

	@RequestMapping(value = "/timeout", method = GET)
	public String timeout() {
		return sleepService.timeout();
	}
}