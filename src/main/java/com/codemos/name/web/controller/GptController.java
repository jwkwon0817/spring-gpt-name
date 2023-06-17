package com.codemos.name.web.controller;

import com.codemos.name.domain.dto.ResultDto;
import com.codemos.name.domain.service.GptService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class GptController {
	
	@PostMapping("/name")
	public ResultDto chat(@RequestBody String payload) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		
		String usage = mapper.readTree(payload).get("usage").asText();
		String description = mapper.readTree(payload).get("description").asText();
		String caseStyle = mapper.readTree(payload).get("caseStyle").asText();
		String language = mapper.readTree(payload).get("language").asText();

		GptService gptService = new GptService();
		
		return gptService.result(usage, description, caseStyle, language);
	}
}
