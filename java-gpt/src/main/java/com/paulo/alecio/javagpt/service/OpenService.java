package com.paulo.alecio.javagpt.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class OpenService {
        @Value("${openaikey}")
        private String OPEN_AI_KEY;
        public final String StartChat(String message) {

                log.info("Mensagem: {}, SERVICE: {}", message, OpenAiService.class);
                OpenAiService service = new OpenAiService(OPEN_AI_KEY);
                CompletionRequest completionRequest = CompletionRequest.builder()
                                .prompt(message)
                                .model("text-davinci-003")
                                .maxTokens(3500)
                                .temperature(0.0)
                                .frequencyPenalty(0.5)
                                .presencePenalty(0.0)
                                .echo(false)
                                .build();

                return service.createCompletion(completionRequest).getChoices().get(0).getText();
        }
}
