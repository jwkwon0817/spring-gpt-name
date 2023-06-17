package com.codemos.name.secrets;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Api {
	
	public static String getOpenApiKey() {
		final String filePath = "/Users/jwkwon0817/IdeaProjects/spring-gpt-name/src/main/resources/key.json";
		
		try {
			String content = new String(Files.readAllBytes(Paths.get(filePath)));
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readTree(content).get("key").asText();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
