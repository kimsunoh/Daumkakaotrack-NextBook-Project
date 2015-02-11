package com.scratchback.spring.service;

import org.springframework.stereotype.Service;

@Service
public class SampleImpl implements Sample {

	@Override
	public String getSampleString(String str) {
		return "hello" + str;
	}

}
