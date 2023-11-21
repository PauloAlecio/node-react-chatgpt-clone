package com.paulo.alecio.javagpt.controller;

import com.paulo.alecio.javagpt.dto.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulo.alecio.javagpt.service.OpenService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("api/prompt")
public class ChatGptController {

    private OpenService service;

    public ChatGptController(OpenService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> getMessage(@RequestBody String message) {

        ResponseBody<String> response = new ResponseBody<>();
        response.setData(service.StartChat(message));
        response.setMessage("Sucesso");
        log.info("Response: {} SERVICE: {}", response.getData(), ChatGptController.class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
