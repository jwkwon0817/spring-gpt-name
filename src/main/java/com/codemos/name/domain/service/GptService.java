package com.codemos.name.domain.service;

import com.codemos.name.domain.dto.ResultDto;
import com.codemos.name.secrets.Api;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GptService {
	
	public ResultDto result(String usage, String description, String caseStyle, String language) {
		String prompt = "I'm trying to name a " + usage + " in " + language + " that " + description + ". The Code style is " + caseStyle + ". Please suggest a name for me.";
		
		OpenAiService service = new OpenAiService(Api.OPEN_AI_API_KEY);
		CompletionRequest completionRequest = CompletionRequest.builder()
			.prompt(prompt)
			.model("text-davinci-003")
			.echo(false)
			.build();
		
		String text = service.createCompletion(completionRequest).getChoices().get(0).getText().trim();
		
		ResultDto resultDto = new ResultDto();
		resultDto.setResult(text);
		return resultDto;
	}
}
